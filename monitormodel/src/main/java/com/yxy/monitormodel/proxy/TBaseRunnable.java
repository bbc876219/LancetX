package com.yxy.monitormodel.proxy;

import android.util.Log;

import com.yxy.monitormodel.TrackerUtils;

public class TBaseRunnable extends ProxyRunnable {
    private static final String TAG = "TBaseRunnable";

    public TBaseRunnable() {
        super();
        Log.d(TAG, "TBaseRunnable() called"+ TrackerUtils.getStackString(false));
    }



    public void run() {
        long start = System.currentTimeMillis();
        super.run();
        Log.d(TAG, super.getClass().getName() + " run() cost : " + (System.currentTimeMillis() - start) + "ms in thread:" + Thread.currentThread().getName() + "[" + Thread.currentThread().getId() + "]");
    }
}
