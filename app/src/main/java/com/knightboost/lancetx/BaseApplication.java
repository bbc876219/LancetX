package com.knightboost.lancetx;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import de.robv.android.xposed.DexposedBridge;
import de.robv.android.xposed.XC_MethodHook;



public class BaseApplication extends Application {
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    private static final String TAG = "BaseApplication";
    public void onCreate() {
        super.onCreate();

        //int i=XposedBridge.getXposedVersion();
        //Log.d(TAG, "onCreate() called getXposedVersion="+i);
        if (Build.VERSION.SDK_INT<=31) {
            class ThreadMethodHook extends XC_MethodHook {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    Thread t = (Thread) param.thisObject;
                    Log.i(TAG, "thread:" + t + ", started..\n"+Log.getStackTraceString(new Throwable()));
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Thread t = (Thread) param.thisObject;
                    Log.i(TAG, "thread:" + t + ", exit..");
                }
            }

            DexposedBridge.hookAllConstructors(Thread.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Thread thread = (Thread) param.thisObject;
                    Class<?> clazz = thread.getClass();
                    if (clazz != Thread.class) {
                        Log.d(TAG, "found class extend Thread:" + clazz);
                        DexposedBridge.findAndHookMethod(clazz, "run", new ThreadMethodHook());
                    }
                    Log.d(TAG, "Thread: " + thread.getName() + " class:" + thread.getClass() + " is created.\n"
                    //        +Log.getStackTraceString(new Throwable())
                    );
                }
            });
            DexposedBridge.findAndHookMethod(Thread.class, "run", new ThreadMethodHook());
        }
    }
}
