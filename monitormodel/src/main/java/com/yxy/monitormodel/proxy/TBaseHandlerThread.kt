package com.yxy.monitormodel.proxy

import android.os.HandlerThread
import android.os.SystemClock
import android.util.Log
import com.yxy.monitormodel.ThreadInfoManager
import com.yxy.monitormodel.TrackerUtils
import com.yxy.monitormodel.bean.ThreadInfo


/**
 * 因HandlerThread继承自Thread，所以复制ProxyThread方法
 */
open class TBaseHandlerThread : HandlerThread {
    constructor(name: String) : super(name)

    constructor(name: String, priority: Int) : super(name, priority)

    @Synchronized
    override fun start() {
        val callStack = TrackerUtils.getStackString()
        Log.d(Companion.TAG, "start() called callStack")
        // 有则更新没有则新增
        val info = ThreadInfoManager.INSTANCE.getThreadInfoById(id)
        info?.also {
            it.id = id
            it.name = name
            it.state = state
            if (it.callStack.isEmpty()) { // 如果来自线程池，callStack意义为任务添加栈，可能已经有值了，不能更新为start调用栈
                it.callStack = callStack
                it.callThreadId = currentThread().id
            }
        } ?: apply {
            val newInfo = ThreadInfo()
            newInfo.id = id
            newInfo.name = name
            newInfo.callStack = callStack
            newInfo.callThreadId = currentThread().id
            newInfo.state = state
            newInfo.startTime = SystemClock.elapsedRealtime()
            ThreadInfoManager.INSTANCE.putThreadInfo(id, newInfo, "basehandlerthread")
        }
        super.start()


    }

    override fun run() {
        Log.d(TAG, "run() called")
        val start = System.currentTimeMillis()
        super.run()
        Log.d(
            TAG,
            " run () cost : " + (System.currentTimeMillis() - start) + "ms in thread:" + Thread.currentThread().name + "[" + Thread.currentThread().id + "]"
        )
        ThreadInfoManager.INSTANCE.removeThreadInfo(id)
    }

    companion object {
        private const val TAG = "THandlerThread"
    }
}