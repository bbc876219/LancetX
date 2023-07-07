package com.bbc;

import android.util.Log;


import androidx.annotation.Keep;

import com.bytedance.android.bytehook.ByteHook;

@Keep
public class NativeHacker {
    private static final String TAG = "NativeHacker";
    private static boolean isInit = false;
    public static boolean isDebug = true;

    public static void init(NativeHacker.ConfigBuilder builder) {

        // init bytehook
        int r = ByteHook.init(new ByteHook.ConfigBuilder()
                .setMode(ByteHook.Mode.AUTOMATIC)
//                .setMode(ByteHook.Mode.MANUAL)
                .setDebug(isDebug)
                .setRecordable(true)
                .build());
        Log.i(TAG, "bytehook init, return: " + r);

        // load hacker

        if (builder != null) {
            builder.build();
        }
        isInit = true;
//        NativeHacker.hook(2);
    }

    public static boolean getDebug() {
        if (!isInit) init(new ConfigBuilder());
        return ByteHook.getDebug();
    }

    public static void setDebug(boolean debug) {
        if (!isInit) init(new ConfigBuilder());
        ByteHook.setDebug(debug);
    }

    public static void hook(int type) throws Exception {
        if (!isInit) init(new ConfigBuilder());
        nativeHook(type);
    }

    public static void unhook() {
        if (!isInit) init(new ConfigBuilder());
        nativeUnhook();
    }

    public static void dumpRecords(String pathname) {
        if (!isInit) init(new ConfigBuilder());
        nativeDumpRecords(pathname);
    }

    private static native int nativeHook(int type) throws Exception;

    private static native int nativeUnhook();

    private static native void nativeDumpRecords(String pathname);

    /**
     * 设置hook的开关
     *
     * @param key
     * @param value
     */
    private static native void setHookSwitch(String key, boolean value);

    public static void onError() {
        Log.d(TAG, "onError() called\n" + Log.getStackTraceString(new Throwable()));
    }

    public static void onHandleSignal() {
        Log.e(TAG, "onHandleSignal() called\n" + Log.getStackTraceString(new Throwable()));
    }

    public static class ConfigBuilder {

        private boolean isHookOpen = true;
        private boolean isHookClose = false;
        private boolean isHookPTheadCreate = true;
        private boolean isHookPTheadRun = true;
        private boolean isHookPTheadSetName = true;
        private boolean isHookPTheadExit = false;
        private boolean isHookPTheadDetach = false;
        private boolean isHookPTheadJoin = false;
        private boolean isInterceptCrash = false;

        public ConfigBuilder() {
        }

        public NativeHacker.ConfigBuilder setHookOpen(boolean hookOpen) {
            isHookOpen = hookOpen;
            return this;
        }

        public NativeHacker.ConfigBuilder setHookClose(boolean hookClose) {
            isHookClose = hookClose;
            return this;
        }

        public NativeHacker.ConfigBuilder setHookPTheadCreate(boolean hookPTheadCreate) {
            isHookPTheadCreate = hookPTheadCreate;
            return this;
        }

        public NativeHacker.ConfigBuilder setHookPTheadRun(boolean hookPTheadRun) {
            isHookPTheadRun = hookPTheadRun;
            if (hookPTheadRun) {
                isHookPTheadCreate = true;
            }
            return this;
        }

        public NativeHacker.ConfigBuilder setHookPTheadSetName(boolean hookPTheadSetName) {
            isHookPTheadSetName = hookPTheadSetName;
            return this;
        }

        public NativeHacker.ConfigBuilder setHookPTheadExit(boolean hookPTheadExit) {
            isHookPTheadExit = hookPTheadExit;
            return this;
        }

        public NativeHacker.ConfigBuilder setHookPTheadDetach(boolean hookPTheadDetach) {
            isHookPTheadDetach = hookPTheadDetach;
            return this;
        }

        public NativeHacker.ConfigBuilder setHookPTheadJoin(boolean hookPTheadJoin) {
            isHookPTheadJoin = hookPTheadJoin;
            return this;
        }

        public NativeHacker.ConfigBuilder setInterceptCrash(boolean interceptCrash) {
            isInterceptCrash = interceptCrash;
            return this;
        }

        private boolean isInit = false;

        public NativeHacker.ConfigBuilder build() {
            if (!isInit) {
                System.loadLibrary("hacker");
                isInit = true;
                setHookSwitch("isHookOpen", isHookOpen);
                setHookSwitch("isHookClose", isHookClose);
                setHookSwitch("isHookPTheadCreate", isHookPTheadCreate);
                setHookSwitch("isHookPTheadRun", isHookPTheadRun);
                setHookSwitch("isHookPTheadJoin", isHookPTheadJoin);
                setHookSwitch("isHookExit", isHookPTheadExit);
                setHookSwitch("isHookPTheadDetach", isHookPTheadDetach);
                setHookSwitch("isHookPTheadSetName", isHookPTheadSetName);
                setHookSwitch("isInterceptCrash", isInterceptCrash);

            }
            return this;
        }
    }

}
