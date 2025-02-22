package com.yxy.monitormodel.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.os.Looper
import android.os.SystemClock
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.util.Log
import android.view.View
import android.widget.Toast

import com.yxy.monitormodel.R
import com.yxy.monitormodel.ThreadInfoManager
import com.yxy.monitormodel.TrackerUtils.setStatusBarColor
import com.yxy.monitormodel.UserPackage
import com.yxy.monitormodel.bean.ShowInfo
import com.yxy.monitormodel.bean.ThreadInfo
import com.yxy.monitormodel.bean.ThreadPoolInfo
import kotlinx.android.synthetic.main.threadtracker_activity_details.*

/**
 * 线程/线程池详情页，包括基础信息和调用栈
 */
class ThreadDetailsActivity : Activity() {
    private val colorBlue = Color.argb(0xff, 0x22, 0x22, 0xee)

    companion object {
        fun startDetailsActivity(context: Context, showInfo: ShowInfo) {
            val intent = Intent()
            intent.setClass(context, ThreadDetailsActivity::class.java)
            intent.putExtra("threadId", showInfo.threadId)
            intent.putExtra("poolName", showInfo.poolName)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.threadtracker_activity_details)
        setStatusBarColor(window)
        backBtn.setOnClickListener { onBackPressed() }
        showDetails()
    }

    private fun showDetails() {
        val threadIdOut = intent.getLongExtra("threadId", -1)
        val poolNameOut = intent.getStringExtra("poolName")
        var threadInfo: ThreadInfo? = null
        var poolInfo: ThreadPoolInfo? = null

        if (threadIdOut == -1L && poolNameOut == null) {
            Toast.makeText(this, "not find", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        var type = ShowInfo.SINGLE_THREAD

        if (threadIdOut != -1L) {
            threadInfo = ThreadInfoManager.INSTANCE.getLastThreadInfoById(threadIdOut)
            threadInfo?.apply {
                if (poolName != null) {
                    type = ShowInfo.POOL_THREAD
                } else {
                    type = ShowInfo.SINGLE_THREAD
                }
            } ?: apply {
                Toast.makeText(this, "not find\nmaybe $threadIdOut has destroy", Toast.LENGTH_SHORT)
                    .show()
                finish()
                return
            }
        } else if (poolNameOut != null) {
            poolInfo = ThreadInfoManager.INSTANCE.getLastThreadPoolInfoByName(poolNameOut)
            type = ShowInfo.POOL
            if (poolInfo == null) {
                Toast.makeText(this, "not find", Toast.LENGTH_SHORT).show()
                finish()
                return
            }
        }
        when (type) {
            ShowInfo.SINGLE_THREAD -> { // 展示独立线程详细信息
                Log.d(TAG, "details:${threadInfo}")
                showSingleThreadInfo(threadInfo)
            }
            ShowInfo.POOL -> { // 展示线程池详细信息
                Log.d(TAG, "details:${poolInfo}")
                showPoolInfo(poolInfo)
            }
            ShowInfo.POOL_THREAD -> { // 展示线程池中线程详细信息
                Log.d(TAG, "details:${threadInfo}")
                showPoolThreadInfo(threadInfo)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showSingleThreadInfo(threadInfo: ThreadInfo?) {
        threadInfo?.apply {
            var cost=endTime-startTime
            if (endTime==-1L){
                cost=android.os.SystemClock.elapsedRealtime()-startTime
            }

            infoDetails.text =
                "id: ${id}\n\n" +
                        "name: ${name}\n\n" +
                        "singlethread: ${name}\n\n" +
                        "state: $state \n\n" +
                        "cost:  ${cost}ms"
            stack1Details.text = highlightStack(callStack)
            if (callStack.isEmpty()) {
                stack1Details.setTextColor(colorBlue)
                stack1Details.text = "unknown"
                stack1TipsLayout.visibility = View.GONE
            } else {
                if (callThreadId != Looper.getMainLooper().thread.id) {
                    stack1Tips.text = "Call from thread $callThreadId"
                    stack1Jump.paint.flags = Paint.UNDERLINE_TEXT_FLAG
                    stack1Jump.visibility = View.VISIBLE
                    stack1Jump.setOnClickListener {
                        startDetailsActivity(
                            this@ThreadDetailsActivity,
                            ShowInfo(threadId = callThreadId)
                        )
                    }
                } else {
                    stack1Tips.text = "Call from main thread"
                    stack1Jump.visibility = View.GONE
                }
            }
            stack2Details.text = highlightStack(runningStack)
        }
        infoTitle.text = "Thread Info"
        stack1Title.text = "Call Stack" // start调用栈
    }

    @SuppressLint("SetTextI18n")
    private fun showPoolInfo(poolInfo: ThreadPoolInfo?) {
        poolInfo?.apply {
            infoDetails.text = "poolName: ${poolName}"
            stack1Details.text = highlightStack(createStack)
            if (createStack.isEmpty()) {
                stack1Details.setTextColor(colorBlue)
                stack1Details.text = "unknown"
                stack1TipsLayout.visibility = View.GONE
            } else {
                if (createThreadId != Looper.getMainLooper().thread.id) {
                    stack1Tips.text = "Create from thread $createThreadId"
                    stack1Jump.paint.flags = Paint.UNDERLINE_TEXT_FLAG
                    stack1Jump.visibility = View.VISIBLE
                    stack1Jump.setOnClickListener {
                        startDetailsActivity(
                            this@ThreadDetailsActivity,
                            ShowInfo(threadId = createThreadId)
                        )
                    }
                } else {
                    stack1Tips.text = "Create from main thread"
                    stack1Jump.visibility = View.GONE
                }
            }
        }
        infoTitle.text = "ThreadPool Info"
        stack1Title.text = "Create Stack" // 线程池创建栈

        stack2Title.visibility = View.GONE
        stack2Details.visibility = View.GONE
    }

    @SuppressLint("SetTextI18n")
    private fun showPoolThreadInfo(threadInfo: ThreadInfo?) {
        threadInfo?.apply {
            infoDetails.text =
                "id: ${id}\n\n" +
                        "name: ${name}\n\n" +
                        "state: ${state}\n\n" +
                        "pool: ${poolName}"
            stack1Details.text = highlightStack(callStack)
            if (callStack.isEmpty()) {
                stack1Details.setTextColor(colorBlue)
                stack1Details.text = "no task running"
                stack1TipsLayout.visibility = View.GONE
            } else {
                if (callThreadId != Looper.getMainLooper().thread.id) {
                    stack1Tips.text = "Task add from thread $callThreadId"
                    stack1Jump.paint.flags = Paint.UNDERLINE_TEXT_FLAG
                    stack1Jump.visibility = View.VISIBLE
                    stack1Jump.setOnClickListener {
                        startDetailsActivity(
                            this@ThreadDetailsActivity,
                            ShowInfo(threadId = callThreadId)
                        )
                    }
                } else {
                    stack1Tips.text = "Task add from main thread"
                    stack1Jump.visibility = View.GONE
                }
            }

            infoTitleJump.paint.flags = Paint.UNDERLINE_TEXT_FLAG
            infoTitleJump.setOnClickListener {
                startDetailsActivity(
                    this@ThreadDetailsActivity,
                    ShowInfo(poolName = poolName)
                )
            }
            infoTitleTipsLayout.visibility = View.VISIBLE

            stack2Details.text = highlightStack(runningStack)
        }
        infoTitle.text = "Thread Info"
        stack1Title.text = "Task Add Stack" // 线程池中线程正在运行任务的添加栈
    }

    private fun highlightStack(stack0: String): SpannableString {
        val stack = stack0.replace("\n", "\n\n")
        var indexA = -1
        var indexZ = -1
        for (s in UserPackage.getPackageList()) {
            val indexTemp = stack.indexOf(s)
            if (indexTemp != -1) {
                if (indexA == -1 || (indexTemp < indexA)) {
                    indexA = indexTemp
                    indexZ = stack.indexOf("\n", startIndex = indexA)
                    if (indexA == 0)
                        break
                }
            }
        }

        val span = SpannableString(stack)
        if (indexA != -1) {
            val styleSpan = StyleSpan(Typeface.BOLD)
            span.setSpan(styleSpan, indexA, indexZ, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            val relativeSizeSpan = RelativeSizeSpan(1.1f)
            span.setSpan(relativeSizeSpan, indexA, indexZ, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            val foregroundColorSpan = ForegroundColorSpan(Color.parseColor("#FFF76347"))
            span.setSpan(foregroundColorSpan, indexA, indexZ, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return span
    }
    private  val TAG = "ThreadDetailsActivity"
}