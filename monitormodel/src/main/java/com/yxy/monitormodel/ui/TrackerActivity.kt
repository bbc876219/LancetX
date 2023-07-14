package com.yxy.monitormodel.ui

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yxy.monitormodel.R
import com.yxy.monitormodel.ThreadInfoManager
import com.yxy.monitormodel.TrackerUtils.setStatusBarColor
import kotlinx.android.synthetic.main.threadtracker_activity_tracker.*
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory

/**
 * 线程/线程池列表
 */
class TrackerActivity : Activity() {

    private val refreshHandlerThread = HandlerThread("ThreadTracker-Refresh").apply {
        start()
    }
    private val refreshHandler = object : Handler(refreshHandlerThread.looper) {
        override fun handleMessage(msg: Message) {
            refreshList(msg.what == 1)
            if (needShutDown) {
                ex.shutdownNow()
                needShutDown = false
                msg.what=+1
                sendMessageDelayed(Message.obtain(msg), 2000)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.threadtracker_activity_tracker)
        setStatusBarColor(window)

        refreshBtn.setOnClickListener {
            refreshBtn.visibility = View.GONE
            refreshProgress.visibility = View.VISIBLE
            refreshHandler.sendEmptyMessage(1)
        }
        val adapter = TrackerAdapter(emptyList(), object : OnItemClickListener {
            override fun onItemClick(view: View) {
                val position: Int = recyclerView.getChildAdapterPosition(view)
                ThreadDetailsActivity.startDetailsActivity(
                    this@TrackerActivity,
                    (recyclerView.adapter as TrackerAdapter).getItemList()[position]
                )
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        ex.submit(Runnable {
            System.err.println(Thread.currentThread())
            Thread.sleep(1000);
        })
        ex.submit(Callable {
            System.err.println(Thread.currentThread())
            Thread.sleep(2000);
            needShutDown = true;
        })
        val test = Thread() { System.err.println(Thread.currentThread()) }
        test.name = "testt"
        test.start()
        refreshHandler.sendEmptyMessage(0)
    }

    var needShutDown = false;

    val ex: ExecutorService = Executors.newCachedThreadPool()
    private val TAG = "TrackerActivity"
    private fun refreshList(toast: Boolean) {
        Log.d(TAG, "refreshList() called with: toast = $toast")
        val infoResult = ThreadInfoManager.INSTANCE.buildAllThreadInfo()
        runOnUiThread {
            (recyclerView.adapter as TrackerAdapter).setItemList(infoResult.list)
            refreshBtn.visibility = View.VISIBLE
            refreshProgress.visibility = View.GONE
            // statisticsText.text = "total: ${infoResult.totalNum}      system/unknown: ${infoResult.unknownNum}"
            if (toast) {
                Toast.makeText(
                    this,
                    "total: ${infoResult.totalNum}  system/unknown: ${infoResult.unknownNum}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroy() {
        refreshHandler.removeCallbacksAndMessages(null)
        refreshHandlerThread.quit()
        super.onDestroy()
    }
}