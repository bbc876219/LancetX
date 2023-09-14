package com.knightboost.lancetx

import android.annotation.SuppressLint
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
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bbc.NativeHookee
import com.hdquantum.android.test.R
import com.yxy.monitormodel.ui.TrackerActivity
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.button2
import kotlinx.android.synthetic.main.activity_main.button3
import kotlinx.android.synthetic.main.activity_main.imageView
import java.lang.Math.sqrt
import java.util.Objects

class MainActivity : AppCompatActivity() {
    var textView: TextView? = null
    var textView2: TextView? = null
    var textView3: TextView? = null
    var textView4: TextView? = null
    var textView5: TextView? = null
    var textView6: TextView? = null
    var textView7: TextView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        System.loadLibrary("hookee") // test for load-before-init


        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        textView7 = findViewById(R.id.textView7)
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
            try {
                val runtimeClass = Class.forName("dalvik.system.VMRuntime")
                val nativeLoadMethod = runtimeClass.getDeclaredMethod(
                    "setTargetSdkVersionNative",
                    *arrayOf<Class<*>?>(Int::class.javaPrimitiveType)
                )
                Log.d("whulzz", "setTargetSdkVersionNative success!")
            } catch (e: Exception) {
                e.printStackTrace()
            }

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
        //sensorManager?.unregisterListener(sensorListener)
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
            val isDebug = (System.currentTimeMillis() - timerStart > 100)
            if (isDebug) {
                timerStart = System.currentTimeMillis();
            }

            // Fetching x,y,z values
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
           return;
            textView?.setText("X:${x}")
            textView2?.setText("Y:${y}")
            textView3?.setText("Z:${z}")
            lastAcceleration = currentAcceleration

            textView4?.setText("lastAcceleration:${lastAcceleration}")

            // Getting current accelerations
            // with the help of fetched x,y,z values
            currentAcceleration = sqrt((x * x + y * y + z * z).toDouble()).toFloat()
            textView5?.setText("currentAcceleration:${currentAcceleration}")
            if (isDebug)
                Log.d(
                    TAGS,
                    "onSensorChanged() called with: x = ${event.values[0]} y = ${event.values[1]} z = ${event.values[2]}"
                )

            val delta: Float = currentAcceleration - lastAcceleration
            acceleration = acceleration * 0.9f + delta
            textView6?.setText("delta:${delta}")
            textView7?.setText("acceleration:${acceleration}")
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

    fun starthreadInfoActivity(view: View) {
        val intent = Intent()
        intent.setClass(this, TrackerActivity::class.java)
//        intent.putExtra("threadId", showInfo.threadId)
//        intent.putExtra("poolName", showInfo.poolName)
        startActivity(intent)
    }
    fun testHook(view: View){

//        BaseApplication.hookBinderProxy()
//        BaseApplication.hookParcel()
//        Thread.sleep(30);
//        starthreadInfoActivity(view)
//        Thread.sleep(30);
//        BaseApplication.unHookParcel()
//        BaseApplication.unhookBinderProxy();

    }


}