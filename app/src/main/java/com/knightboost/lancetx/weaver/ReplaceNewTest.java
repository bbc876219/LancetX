package com.knightboost.lancetx.weaver;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;

import com.knightboost.lancet.api.Origin;
import com.knightboost.lancet.api.Scope;

import com.knightboost.lancet.api.annotations.Group;
import com.knightboost.lancet.api.annotations.ReplaceNewInvoke;
import com.knightboost.lancet.api.annotations.Weaver;

import com.yxy.monitormodel.proxy.GlobalHandler;
import com.yxy.monitormodel.proxy.TBaseHandlerThread;
import com.yxy.monitormodel.proxy.TBaseThread;
import com.yxy.monitormodel.proxy.TBaseThreadFactory;
import com.yxy.monitormodel.proxy.TBaseThreadPoolExecutor;
import com.yxy.monitormodel.proxy.TBaseTimer;

import java.util.Timer;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

@Weaver
@Group("replaceNewTest")
public class ReplaceNewTest {

    @ReplaceNewInvoke()
    public static void replaceNewThread(Thread t, TBaseThread proxyThread) {
    }

    @ReplaceNewInvoke()
    public static void replaceNewHandlerThread(HandlerThread t, TBaseHandlerThread proxyHandlerThread) {
    }

    @ReplaceNewInvoke()
    public static void replaceNewTimer(Timer o, TBaseTimer no) {
    }

    @ReplaceNewInvoke()
    public static void replaceNewThreadFactory(ThreadFactory o, TBaseThreadFactory no) {
    }

    @ReplaceNewInvoke()
    public static void replaceNewThreadPoolExecutor(ThreadPoolExecutor o, TBaseThreadPoolExecutor no) {
    }

    @ReplaceNewInvoke()
    public static void replaceNewHandler(Handler o, GlobalHandler no) {
    }


    @ReplaceNewInvoke()
    public static void replaceIntent(Intent intent, WrappedIntent newIntent) {
    }
}
