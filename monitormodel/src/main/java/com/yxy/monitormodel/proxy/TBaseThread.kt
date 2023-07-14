package com.yxy.monitormodel.proxy

import android.os.SystemClock
import android.util.Log
import com.yxy.monitormodel.ThreadInfoManager
import com.yxy.monitormodel.TrackerUtils
import com.yxy.monitormodel.bean.ThreadInfo

open class TBaseThread : Thread {
    val isDebug = true;

    internal constructor() : super()
    internal constructor(runnable: Runnable?) : super(runnable)
    internal constructor(group: ThreadGroup?, target: Runnable?) : super(group, target)
    internal constructor(group: ThreadGroup?, name: String) : super(group, name)
    internal constructor(target: Runnable?, name: String) : super(target, name)
    internal constructor(group: ThreadGroup?, target: Runnable?, name: String) : super(
        group,
        target,
        name
    )

    internal constructor(
        group: ThreadGroup?,
        target: Runnable?,
        name: String,
        stackSize: Long
    ) : super(group, target, name, stackSize)
    init{
        if (isDebug) {
            val callStack = TrackerUtils.getStackTrace(Throwable(), 0, 10)
            if (isDebug) {
                Log.d(TAG + ".init", "thread $id init callStack  $callStack")
            }
        }
    }

    @Synchronized
    override fun start() {
        val callStack = TrackerUtils.getStackTrace(Throwable(),0,10)
        if (isDebug) {
            Log.d(TAG+".start", "thread ${id} start callStack  $callStack")
        }
        // 有则更新没有则新增
        val info = ThreadInfoManager.INSTANCE.getThreadInfoById(id)
        info?.also {
            it.id = id
            it.name = name
            it.state = state
            if (it.callStack.isEmpty()) { // 如果来自线程池，callStack意义为任务添加栈，可能已经有值了，不能更新为start调用栈
                it.callStack = callStack.toString()
                it.callThreadId = currentThread().id
            }
            if (isDebug) {
                Log.d(TAG+".start", "thread  id $id")
            }
        } ?: apply {
            val newInfo = ThreadInfo()
            newInfo.id = id
            newInfo.name = name
            newInfo.callStack = callStack.toString()
            newInfo.callThreadId = currentThread().id
            newInfo.state = state
            newInfo.startTime = SystemClock.elapsedRealtime()
            ThreadInfoManager.INSTANCE.putThreadInfo(id, newInfo,"basethread")
            if (isDebug) {
                Log.d(TAG+".start", "thread  newInfo id $id")
            }
        }
        super.start()


//        if (isDebug) {
//            Log.d(TAG, "proxy $id thread start end ")
//        }
    }

    override fun run() {
        val start = System.currentTimeMillis();
        if (isDebug) {
            Log.d(TAG+".run", "thread($id) start ")
        }
        super.run()
        ThreadInfoManager.INSTANCE.removeThreadInfo(id)
        if (isDebug) {
            Log.d(
                TAG+".run",
                String.format(
                    "thread $id  end cost=%d ",
                    (System.currentTimeMillis() - start)
                )
            )
        }
    }

    companion object {
        private const val TAG = "thread"
    }
}