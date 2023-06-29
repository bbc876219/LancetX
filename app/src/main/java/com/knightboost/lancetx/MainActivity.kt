package com.knightboost.lancetx

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bbc.NativeHacker
import com.bbc.NativeHookee
import com.hdquantum.android.slowdoctor.R
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.button2
import kotlinx.android.synthetic.main.activity_main.button3
import kotlinx.android.synthetic.main.activity_main.imageView
import kotlinx.android.synthetic.main.activity_main.init_method_insert_test

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        System.loadLibrary("hookee") // test for load-before-init

        NativeHacker.isDebug = true
        NativeHacker.init()
        NativeHacker.unhook()
        NativeHacker.hook(2)
        setContentView(R.layout.activity_main)
        ImplA().testMethod()
        ClassA().printMessage("haha!")

        init_method_insert_test.setOnClickListener {
            ConstructorTest(" original call^");
        }
        button.setOnClickListener {
            val createBitmap = Bitmap.createBitmap(300, 600, Bitmap.Config.RGB_565)
            println(createBitmap)
            val bitmap = Bitmap.createBitmap(310, 412, Bitmap.Config.RGB_565)
//            val bitmap =
//                BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
            imageView.setImageBitmap(bitmap);
//            BaseApplication.proxyArrayList_grow();
            val list = ArrayList<String>();
            for (i in 0 until 1) {
                list.add(it.toString());
            }
            println(list.toArray())


        }
        button2.setOnClickListener {
//            Handler().postDelayed(Runnable {
//                //BaseApplication.proxyHashMap_resize();
//                val map: HashMap<String, Int> = HashMap<String, Int>()
//                for (i in 0 until 300) {
//                    map.put("key "+i + "", i)
//                    println("map.size="+map.size)
//                }
//                println(map) },1000)
            NativeHookee.createNativeThreadCreate()


        }
        button3.setOnClickListener {

            NativeHookee.test();
            //HandlerThreadTest().start()

        }
    }

    val runnable = Runnable { Log.e("test", "runnable") }

    override fun onResume() {
        super.onResume()
        val thread = Thread()
        thread.name = "onResume1"
        val intent = Intent()
        Log.i("Activity", "onResume")
        val thread0 = Thread(runnable)
        thread0.name = "thread0"
        thread0.start()
        Log.i("Activity", "onResume1")
        val thread1 = AThread(runnable)
        thread1.name = "thread1"
        thread1.start()
        Log.i("Activity", "onResume2")
        val thread2 = BThread(runnable)
        thread2.name = "thread2"
        thread2.start()
        Log.i("Activity", "onResume3")
    }

    fun normalMethod() {
        Log.i("Activity", "normalMethod")
        val thread = AThread(runnable)
    }


}