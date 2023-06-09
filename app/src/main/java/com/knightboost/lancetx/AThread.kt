package com.knightboost.lancetx

import android.util.Log

class AThread(runnable: Runnable) :Thread() {
    override fun run(){
        Log.d("AThread", "run() called start")
        super.run()
        Log.d("AThread", "run() called end")
    }
    override fun start(){
        Log.d("AThread", "start() called start")
        super.run()
        Log.d("AThread", "start() called end")
    }
}