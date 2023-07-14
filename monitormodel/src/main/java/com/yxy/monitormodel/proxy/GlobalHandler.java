package com.yxy.monitormodel.proxy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.yxy.monitormodel.TrackerUtils;

import org.json.JSONObject;

public class GlobalHandler extends Handler {

    private long mStartTime = System.currentTimeMillis();

    public GlobalHandler() {
        super(Looper.myLooper(), null);
        Log.w(TAG, "GlobalHandler() called"+ TrackerUtils.getStackTrace(new Throwable("GlobalHandler()"),3,7));
    }

    public GlobalHandler(Callback callback) {
        super(Looper.myLooper(), callback);
        Log.d(TAG, "GlobalHandler() called with: callback = [" + callback + "]");
    }

    public GlobalHandler(Looper looper, Callback callback) {
        super(looper, callback);
        Log.d(TAG, "GlobalHandler() called with: looper = [" + looper + "], callback = [" + callback + "]");
    }

    public GlobalHandler(Looper looper) {
        super(looper);
        Log.d(TAG, "GlobalHandler() called with: looper = [" + looper + "]"+ TrackerUtils.getStackTrace(new Throwable("GlobalHandler(Looper looper)"),3,7));
    }

    @Override
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        boolean send = super.sendMessageAtTime(msg, uptimeMillis);
        // 1
        if (send) {
            GetDetailHandlerHelper.getMsgDetail().put(msg, Log.getStackTraceString(new Throwable()).replace("java.lang.Throwable", ""));
        }else{
            Log.d(TAG, "sendMessageAtTime(FAIL) called with: msg = [" + msg + "], uptimeMillis = [" + uptimeMillis + "]");
        }
        return send;
    }

    @Override
    public void dispatchMessage(Message msg) {
        mStartTime = System.currentTimeMillis();
        super.dispatchMessage(msg);
        if (GetDetailHandlerHelper.getMsgDetail().containsKey(msg)){
            long cost=System.currentTimeMillis() - mStartTime;
            if (cost>5) {
                Log.d(TAG, "dispatchMessage() called with: msg = [" + msg + "] cost:" + (cost)+" target="+msg.getTarget());
            }
            GetDetailHandlerHelper.getMsgDetail().remove(msg);
        }

    }

    private static final String TAG = "GlobalHandler";
}
