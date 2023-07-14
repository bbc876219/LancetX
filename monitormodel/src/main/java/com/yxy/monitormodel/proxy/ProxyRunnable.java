package com.yxy.monitormodel.proxy;

import android.util.Log;

public class ProxyRunnable implements Runnable {
    private static final String TAG = "ProxyRunnable";

    public ProxyRunnable() {

    }

    private Runnable runnable;

    public ProxyRunnable(Runnable runnable) {
        this.runnable = runnable;
    }


    public void run() {
        long start = System.currentTimeMillis();
        if (runnable != null) {
            runnable.run();
        }
        Log.d(TAG, runnable.getClass().getName()+" run() cost : " + (System.currentTimeMillis() - start) + "ms in thread:" + Thread.currentThread().getName() + "[" + Thread.currentThread().getId() + "]");
    }
}
