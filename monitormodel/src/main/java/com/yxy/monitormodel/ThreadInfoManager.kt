package com.yxy.monitormodel

import android.os.SystemClock
import android.util.Log
import com.yxy.monitormodel.bean.ShowInfo
import com.yxy.monitormodel.bean.ThreadInfo
import com.yxy.monitormodel.bean.ThreadInfoResult
import com.yxy.monitormodel.bean.ThreadPoolInfo
import java.util.concurrent.ConcurrentHashMap

class ThreadInfoManager private constructor() {

    companion object {
        @JvmStatic
        val INSTANCE: ThreadInfoManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { ThreadInfoManager() }
        private const val TAG = "ThreadInfoManager"
    }

    // 随时在更新
    private val threadInfo = ConcurrentHashMap<Long, ThreadInfo>()
    private val threadPoolInfo = ConcurrentHashMap<String, ThreadPoolInfo>()

    // 用于展示页面获取细节，只在buildAllThreadInfo时更新
    private val lastThreadInfo = HashMap<Long, ThreadInfo>()
    private val lastThreadPoolInfo = HashMap<String, ThreadPoolInfo>()

    fun putThreadInfo(threadId: Long, info: ThreadInfo,form:String) {
        Log.d("thread.m", "putThreadInfo($form) called with: threadId = $threadId, info = $info")
        threadInfo[threadId] = info
    }

    fun removeThreadInfo(threadId: Long) {

        //threadInfo.remove(threadId)
        if (threadInfo[threadId]!=null) {
            threadInfo[threadId]!!.name +="_TERMINATED"
            threadInfo[threadId]!!.state = Thread.State.TERMINATED
            threadInfo[threadId]!!.endTime = SystemClock.elapsedRealtime();
        }
        //Log.d("thread.m", "removeThreadInfo() called with: threadId = $threadId  threadinfo=${threadInfo[threadId]}")

    }

    fun getThreadInfoById(threadId: Long): ThreadInfo? {
        return threadInfo[threadId]
    }

    fun getLastThreadInfoById(threadId: Long): ThreadInfo? {
        return lastThreadInfo[threadId]
    }


    fun getLastThreadPoolInfoByName(poolName: String?): ThreadPoolInfo? {
        return poolName?.let { lastThreadPoolInfo[it] }
    }

    fun shutDownPool(poolName: String) {
        Log.d(Companion.TAG, "shutDownPool() called with: poolName = $poolName  info=${threadPoolInfo[poolName]}")
        threadPoolInfo[poolName]?.shutDown = true
    }

    fun removePool(poolName: String) {
        threadPoolInfo.remove(poolName)
    }

    fun putThreadPoolInfo(poolName: String, pool: ThreadPoolInfo,form: String) {
        Log.d(TAG, "putThreadPoolInfo() called with: poolName = $poolName, pool = $pool  form = $form")
        threadPoolInfo[poolName] = pool
    }

    // 获取当前所有线程并和已保存线程信息比较、融合，返回用于展示的结果
    fun buildAllThreadInfo(log: Boolean = false): ThreadInfoResult {
        Log.d(TAG, "buildAllThreadInfo() called with: log = $log  Thread.name=${Thread.currentThread().name}")
        // 暂时规定必须在TrackerActivity刷新线程中
        if (Thread.currentThread().name != "ThreadTracker-Refresh") {
            throw RuntimeException("not in ThreadTracker-Refresh thread")
        }
        val ignoreId = Thread.currentThread().id

        val threadInfoResult = ThreadInfoResult()

        // 初始化一些字段
        val values = threadInfo.values.iterator()
        Log.d(TAG, "buildAllThreadInfo() called with: values0 = ${threadInfo.values.size}")
        while (values.hasNext()) {
            val v=values.next();
            if (v.state == Thread.State.TERMINATED) {
                v.hit = ThreadInfo.HIT_TERMINATED
            } else {
                v.hit = ThreadInfo.HIT_NO
            }
        }
        Log.d(TAG, "buildAllThreadInfo() called with: values1 = ${threadInfo.values.size}")
        val poolValues = threadPoolInfo.values.iterator()
        while (poolValues.hasNext()) {
            poolValues.next().threadIds.clear()
        }

        // 获取当前所有线程
        val threadMap = Thread.getAllStackTraces()
        for ((thread, stackElements) in threadMap) {
            if (thread.id == ignoreId)
                continue
            var info = threadInfo[thread.id]
            // info存在就更新不算在就新建
            info = (info ?: ThreadInfo()).apply {
                hit = ThreadInfo.HIT_YES // 已被找到，表示此线程信息对应线程当前正在活动
                id = thread.id
                name = thread.name // 这个name可以随时改 这里更新下
                state = thread.state
                poolName?.also { poolName ->
                    // 在线程池信息中查出poolName对应的线程池，并把此线程id添加进去，建立线程池与线程关系
                    val pool = threadPoolInfo[poolName]
                    pool?.threadIds?.add(id)
                }
                runningStack = TrackerUtils.getThreadRunningStack(stackElements)
            }
            putThreadInfo(thread.id, info,"ThreadInfoManager")
        }

        lastThreadInfo.clear()
        lastThreadPoolInfo.clear()

        // 清除没有被命中的thread，将剩下的复制到lastThreadInfo中
        val afterValues = threadInfo.values.iterator()
        while (afterValues.hasNext()) {
            val it = afterValues.next()
            if (it.hit == ThreadInfo.HIT_NO) {
                afterValues.remove()
                Log.d(TAG, "afterValues  remove = $it")
            } else {
                lastThreadInfo[it.id] = it.copy()
            }
        }

        // 清除threadIds为空并且shutdown的pool，将剩下的复制到lastThreadPoolInfo中
        val afterPoolValues = threadPoolInfo.values.iterator()
        while (afterPoolValues.hasNext()) {
            afterPoolValues.next().apply {
//                if (threadIds.isEmpty() && shutDown) {
//                    //afterPoolValues.remove()
//                } else {
                    val newInfo = this.copy()
                    newInfo.threadIds = mutableListOf()
                    this.threadIds.forEach {
                        newInfo.threadIds.add(it)
                    }
                    lastThreadPoolInfo[poolName] = newInfo
//                }
            }
        }

        if (log) print()

        // 生成listShowInfo供列表显示
        val listShowInfo = mutableListOf<ShowInfo>()
        lastThreadInfo.forEach {
            if (it.value.poolName.isNullOrEmpty() && it.value.callStack.isNotEmpty())
            {
                // 独立的、有调用栈的线程
                listShowInfo.add(ShowInfo().apply {
                    threadId = it.value.id
                    threadName = it.value.name
                    threadState = it.value.state
                    type = ShowInfo.SINGLE_THREAD
                })
            }
        }
        lastThreadPoolInfo.forEach {
            if (it.value.threadIds.isNotEmpty()) { // 忽略没有线程在运行的线程池
                listShowInfo.add(ShowInfo().apply {
                    if (it.value.shutDown) {
                        poolName = "SHUTDOWN_" + it.value.poolName + "_EMPTY"
                    } else {
                        poolName = it.value.poolName + "_EMPTY"
                    }
                    type = ShowInfo.POOL
                })
                it.value.threadIds.forEach { id ->
                    lastThreadInfo[id]?.also {
                        listShowInfo.add(ShowInfo().apply {
                            threadId = it.id
                            threadName = it.name
                            threadState = it.state
                            poolName = it.poolName
                            type = ShowInfo.POOL_THREAD
                        })
                    }
                }
            }
        }
        lastThreadInfo.forEach {
            if (it.value.poolName == null && it.value.callStack.isEmpty()) {
                // 未知、系统线程
                listShowInfo.add(ShowInfo().apply {
                    threadId = it.value.id
                    threadName = it.value.name
                    threadState = it.value.state
                    type = ShowInfo.SINGLE_THREAD
                })
                threadInfoResult.unknownNum++
            }
        }

        threadInfoResult.list = listShowInfo
        threadInfoResult.totalNum = threadMap.size - 1 // 不算当前线程

        return threadInfoResult
    }

    private fun print() {
//        Log.d(LOG_TAG, "\n\n—————————————————thread———————————————")
//        val keys = threadInfo.keys()
//        while (keys.hasMoreElements()) {
//            threadInfo[keys.nextElement()]?.apply {
//                Log.d(LOG_TAG, "${toString()}\n")
//            }
//        }
//
//        Log.d(LOG_TAG, "\n\n—————————————————pool—————————————————")
//        val poolKeys = threadPoolInfo.keys()
//        while (poolKeys.hasMoreElements()) {
//            threadPoolInfo[poolKeys.nextElement()]?.apply {
//                if (threadIds.isNotEmpty()) {
//                    Log.d(LOG_TAG, "${toString()}\n")
//                }
//            }
//        }
    }
}