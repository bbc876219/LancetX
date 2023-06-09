package com.knightboost.lancetx;

import android.util.Log;

import androidx.annotation.Nullable;

public class BThread extends Thread{
    private static final String TAG = "BThread";
    public BThread(@Nullable Runnable target) {
        super(target);
    }
    public void start(){
        Log.d(TAG, "start() called start");
        super.start();
        Log.d(TAG, "start() called end");
    }
    public void run(){
        Log.d(TAG, "run() called start");
        super.run();
        Log.d(TAG, "run() called end");
    }
}
