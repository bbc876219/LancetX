package com.knightboost.lancetx;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

public class HandlerThreadTest {
    private static final String TAG = "HandlerThreadTest";
    // 步骤1：创建HandlerThread实例对象
// 传入参数 = 线程名字，作用 = 标记该线程
    HandlerThread mHandlerThread = new HandlerThread("handlerThread");


    // 步骤3：创建工作线程Handler & 复写handleMessage（）
// 作用：关联HandlerThread的Looper对象、实现消息处理操作 & 与其他线程进行通信
// 注：消息处理操作（HandlerMessage（））的执行线程 = mHandlerThread所创建的工作线程中执行
    Handler workHandler;

    public void start() {


// 步骤2：启动线程
        mHandlerThread.start();
        workHandler = new Handler(mHandlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                //消息处理
                switch (msg.what) {
                    case 2: {
                        Message xmsg = Message.obtain();
                        xmsg.what = 2; //消息的标识
                        xmsg.obj = "B"; // 消息的存放
                        Log.d(TAG, "handleMessage() called with: msg = [" + msg + "]");
                        workHandler.sendMessageDelayed(xmsg, 3000);
                    }
                    break;
                }
            }
        };
// 步骤4：使用工作线程Handler向工作线程的消息队列发送消息
// 在工作线程中，当消息循环时取出对应消息 & 在工作线程执行相关操作
        // a. 定义要发送的消息
        Message msg = Message.obtain();
        msg.what = 2; //消息的标识
        msg.obj = "B"; // 消息的存放
        // b. 通过Handler发送消息到其绑定的消息队列
        workHandler.sendMessage(msg);
    }
}
