package com.knightboost.lancetx

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ImplA().testMethod()
        ClassA().printMessage("haha!")

        init_method_insert_test.setOnClickListener {
            ConstructorTest(" original call^");
        }
    }
    val runnable = Runnable{ Log.e("test","runnable")}

    override fun onResume() {
        super.onResume()
        val thread = Thread()
        val intent = Intent()
        Log.i("Activity","onResume")
        Thread(runnable).start()
        Log.i("Activity","onResume1")
        val thread1 = AThread(runnable)
        thread1.start()
        Log.i("Activity","onResume2")
        val thread2 = BThread(runnable)
        thread2.start()
        Log.i("Activity","onResume3")
    }

    fun normalMethod(){
        Log.i("Activity","normalMethod")
        val thread = AThread(runnable)
    }

}