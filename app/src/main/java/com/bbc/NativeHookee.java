package com.bbc;

public class NativeHookee {
    public static void test() {
        nativeTest();
    }

    private static native void nativeTest();
}
