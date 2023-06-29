package com.bbc;

import android.util.Log;

public class NativeHookee {
    public static void test() {
        nativeTest();
    }

    private static native void nativeTest();
    public static native void createNativeThreadCreate();


    private static final String TAG = "NativeHookee";
}
