package com.yxy.monitormodel.proxy;

import android.util.Log;

import java.util.concurrent.Callable;

public class ProxyCallable<V> implements Callable<V> {
    private static final String TAG = "ProxyCallable";

    private ProxyCallable() {

    }

    Callable callable;

    public ProxyCallable(Callable callable) {
        this.callable = callable;
    }


    public V call() throws Exception {
        V rs = null;
        long start = System.currentTimeMillis();
        try {
            if (callable != null) {
                rs = (V) callable.call();
            }
            return rs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            Log.d(TAG, callable.getClass().getName()+"  call()  cost : " + (System.currentTimeMillis() - start) + "ms  rs= " + rs + "  in thread:" + Thread.currentThread().getName() + "[" + Thread.currentThread().getId() + "]");
        }


    }


}
