package com.bbc;

import android.util.Log;


import androidx.annotation.Keep;

import com.bytedance.android.bytehook.ByteHook;
@Keep
public class NativeHacker {
    private static final String TAG = "NativeHacker";
    private static boolean isInit = false;
    public static boolean isDebug = true;

    public static void init() {
        // init bytehook
        int r = ByteHook.init(new ByteHook.ConfigBuilder()
                .setMode(ByteHook.Mode.AUTOMATIC)
//                .setMode(ByteHook.Mode.MANUAL)
                .setDebug(isDebug)
                .setRecordable(true)
                .build());
        Log.i(TAG, "bytehook init, return: " + r);

        // load hacker
        System.loadLibrary("hacker");
        isInit = true;
//        NativeHacker.hook(2);
    }

    public static boolean getDebug() {
        if (!isInit) init();
        return ByteHook.getDebug();
    }

    public static void setDebug(boolean debug) {
        if (!isInit) init();
        ByteHook.setDebug(debug);
    }

    public static void hook(int type) {
        if (!isInit) init();
        nativeHook(type);
    }

    public static void unhook() {
        if (!isInit) init();
        nativeUnhook();
    }

    public static void dumpRecords(String pathname) {
        if (!isInit) init();
        nativeDumpRecords(pathname);
    }

    private static native int nativeHook(int type);

    private static native int nativeUnhook();

    private static native void nativeDumpRecords(String pathname);
}
