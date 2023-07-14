package com.knightboost.lancetx

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bbc.NativeHookee
import com.hdquantum.android.slowdoctor.R
import com.yxy.monitormodel.ui.ThreadDetailsActivity
import com.yxy.monitormodel.ui.TrackerActivity
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.button2
import kotlinx.android.synthetic.main.activity_main.button3
import kotlinx.android.synthetic.main.activity_main.imageView
import kotlinx.android.synthetic.main.activity_main.init_method_insert_test
import java.lang.Math.sqrt
import java.util.Objects

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        System.loadLibrary("hookee") // test for load-before-init


        setContentView(R.layout.activity_main)
//        ImplA().testMethod()
//        ClassA().printMessage("haha!")
//
//        init_method_insert_test.setOnClickListener {
//            ConstructorTest(" original call^");
//        }
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
            val thread = Thread(Runnable { -> NativeHookee.test() })
            thread.name = "nativetest"
            thread.start()

//            NativeHookee.test();
            //HandlerThreadTest().start()

        }
        initSensor()
    }

    val runnable = Runnable { Log.e("test", "runnable") }

    override fun onResume() {
        super.onResume()
//        val thread = Thread()
//        thread.name = "onResume1"
//        val intent = Intent()
//        Log.i("Activity", "onResume")
//        val thread0 = Thread(runnable)
//        thread0.name = "thread0"
//        thread0.start()
//        Log.i("Activity", "onResume1")
//        val thread1 = AThread(runnable)
//        thread1.name = "thread1"
//        thread1.start()
//        Log.i("Activity", "onResume2")
        val thread2 = BThread(runnable)
        thread2.name = "thread2"
        thread2.start()
//        Log.i("Activity", "onResume3")
        sensorManager?.registerListener(
            sensorListener, sensorManager!!.getDefaultSensor(
                Sensor.TYPE_ACCELEROMETER
            ), SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    override fun onPause() {
        sensorManager!!.unregisterListener(sensorListener)
        super.onPause()
    }

    fun normalMethod() {
        Log.i("Activity", "normalMethod")
        val thread = AThread(runnable)
    }

    private var sensorManager: SensorManager? = null;
    private var acceleration = 0f;
    private var currentAcceleration = 0f
    private var lastAcceleration = 0f
    fun initSensor() {
        try {
            sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager;
        } catch (e: Exception) {
          Log.e(TAGS,"getSystemService(Context.SENSOR_SERVICE) Exception:",e)
        }
        Log.d(TAGS, "initSensor() called sensorManager = $sensorManager")
        Objects.requireNonNull(sensorManager)!!.registerListener(
            sensorListener,
            sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    private var timerStart = 0L;
    private val sensorListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            val isDebug = (System.currentTimeMillis() - timerStart > 3000)
            if (isDebug) {
                timerStart = System.currentTimeMillis();
            }
            // Fetching x,y,z values
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            lastAcceleration = currentAcceleration

            // Getting current accelerations
            // with the help of fetched x,y,z values
            currentAcceleration = sqrt((x * x + y * y + z * z).toDouble()).toFloat()
            if (isDebug)
                Log.d(
                    TAGS,
                    "onSensorChanged() called with: x = ${event.values[0]} y = ${event.values[1]} z = ${event.values[2]}"
                )

            val delta: Float = currentAcceleration - lastAcceleration
            acceleration = acceleration * 0.9f + delta
            if (isDebug)
                Log.d(
                    TAGS,
                    "onSensorChanged() called with: acceleration = $acceleration  delta = $delta   currentAcceleration = $currentAcceleration   lastAcceleration = $lastAcceleration \n\n"
                )
            // Display a Toast message if
            // acceleration value is over 12
            if (acceleration > 12) {
                Toast.makeText(applicationContext, "Shake event detected", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            Log.d(TAGS, "onAccuracyChanged() called with: sensor = $sensor, accuracy = $accuracy")
        }
    }

    companion object {
        private const val TAGS = "sensor"
    }
    fun starthreadInfoActivity(view: View){
        val intent = Intent()
        intent.setClass(this, TrackerActivity::class.java)
//        intent.putExtra("threadId", showInfo.threadId)
//        intent.putExtra("poolName", showInfo.poolName)
        startActivity(intent)
    }


}