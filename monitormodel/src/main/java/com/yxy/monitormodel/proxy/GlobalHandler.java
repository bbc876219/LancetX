package com.yxy.monitormodel.proxy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import org.json.JSONObject;

public class GlobalHandler extends Handler {

    private long mStartTime = System.currentTimeMillis();

    public GlobalHandler() {
        super(Looper.myLooper(), null);
        Log.w(TAG, "GlobalHandler() called");
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
        Log.d(TAG, "GlobalHandler() called with: looper = [" + looper + "]");
    }

    @Override
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        boolean send = super.sendMessageAtTime(msg, uptimeMillis);
        // 1
        if (send) {
            GetDetailHandlerHelper.getMsgDetail().put(msg, Log.getStackTraceString(new Throwable()).replace("java.lang.Throwable", ""));
        }
        return send;
    }

    @Override
    public void dispatchMessage(Message msg) {
        mStartTime = System.currentTimeMillis();
        super.dispatchMessage(msg);

        if (GetDetailHandlerHelper.getMsgDetail().containsKey(msg)
                && Looper.myLooper() == Looper.getMainLooper()) {
            JSONObject jsonObject = new JSONObject();
            try {
                // 2
                jsonObject.put("Msg_Cost", System.currentTimeMillis() - mStartTime);
                jsonObject.put("MsgTrace", msg.getTarget() + " " + GetDetailHandlerHelper.getMsgDetail().get(msg));

                // 3
                Log.i(TAG, "MsgDetail " + jsonObject.toString());
                GetDetailHandlerHelper.getMsgDetail().remove(msg);
            } catch (Exception e) {
            }
        }
    }

    private static final String TAG = "GlobalHandler";
}
