package com.knightboost.lancetx.weaver;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;

import com.knightboost.lancet.api.Origin;
import com.knightboost.lancet.api.Scope;
import com.knightboost.lancet.api.This;
import com.knightboost.lancet.api.annotations.Group;
import com.knightboost.lancet.api.annotations.NameRegex;
import com.knightboost.lancet.api.annotations.Proxy;
import com.knightboost.lancet.api.annotations.TargetClass;
import com.knightboost.lancet.api.annotations.TargetMethod;
import com.knightboost.lancet.api.annotations.Weaver;
import com.knightboost.lancetx.ClassA;
import com.yxy.monitormodel.proxy.ProxyExecutors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

@Weaver
@Group("proxyTest")
public class ProxyTest {

//    @Proxy()
//    @TargetClass(value = "android.util.Log", scope = Scope.SELF)
//    @TargetMethod(methodName = "i")
//    public static int replaceLogI(String tag, String msg) {
//        msg = msg + "被替换proxy";
//        return (int) Origin.call();
//    }

    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "newCachedThreadPool")
    @NameRegex("(?!com/yxy/monitormodel/proxy/).*")
    public static ExecutorService newCachedThreadPool() {
//        Executors.newCachedThreadPool()
        return ProxyExecutors.newCachedThreadPool();
    }

    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "newCachedThreadPool")
    @NameRegex("(?!com/yxy/monitormodel/proxy/).*")
    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return ProxyExecutors.newCachedThreadPool(threadFactory);
    }

    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "newFixedThreadPool")
    @NameRegex("(?!com/yxy/monitormodel/proxy/).*")
    public static ExecutorService newFixedThreadPool(int threads) {
        return ProxyExecutors.newFixedThreadPool(threads);
    }

    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "newFixedThreadPool")
    @NameRegex("(?!com/yxy/monitormodel/proxy/).*")
    public static ExecutorService newFixedThreadPool(int threads, ThreadFactory threadFactory) {
        return ProxyExecutors.newFixedThreadPool(threads, threadFactory);
    }

    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "newWorkStealingPool")
    @NameRegex("(?!com/yxy/monitormodel/proxy/).*")
    public static ExecutorService newWorkStealingPool(int parallelism) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return ProxyExecutors.newWorkStealingPool(parallelism);
        } else {
            return (ExecutorService) Origin.call();
        }
    }

    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "newWorkStealingPool")
    public static ExecutorService newWorkStealingPool() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return ProxyExecutors.newWorkStealingPool();
        } else {
            return (ExecutorService) Origin.call();
        }
    }


    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "newSingleThreadExecutor")
    @NameRegex("(?!com/yxy/monitormodel/proxy/).*")
    public static ExecutorService newSingleThreadExecutor() {

        return ProxyExecutors.newSingleThreadExecutor();

    }

    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "newSingleThreadExecutor")
    @NameRegex("(?!com/yxy/monitormodel/proxy/).*")
    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {

        return ProxyExecutors.newSingleThreadExecutor(threadFactory);

    }

    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "newSingleThreadScheduledExecutor")
    @NameRegex("(?!com/yxy/monitormodel/proxy/).*")
    public static ExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        return ProxyExecutors.newSingleThreadScheduledExecutor(threadFactory);
    }

    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "newScheduledThreadPool")
    @NameRegex("(?!com/yxy/monitormodel/proxy/).*")
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return ProxyExecutors.newScheduledThreadPool(corePoolSize);

    }


    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "unconfigurableExecutorService")
    @NameRegex("(?!com/yxy/monitormodel/proxy/).*")
    public static ExecutorService unconfigurableExecutorService(ExecutorService executorService) {
        return ProxyExecutors.unconfigurableExecutorService(executorService);
    }


    @Proxy()
    @TargetClass(value = "java.util.concurrent.Executors", scope = Scope.SELF)
    @TargetMethod(methodName = "unconfigurableScheduledExecutorService")
    @NameRegex("(?!com/yxy/monitormodel/proxy/).*")
    public static ExecutorService unconfigurableScheduledExecutorService(ScheduledExecutorService executorService) {
        return ProxyExecutors.unconfigurableScheduledExecutorService(executorService);
    }


//    @Proxy()
//    @TargetClass(value = "com.knightboost.lancetx.ClassA", scope = Scope.SELF)
//    @TargetMethod(methodName = "printMessage")
//    public static void printMessage(ClassA a, String msg) {
//        msg = msg + "被替换proxy <- printMessage";
//        Log.e("ClassA", msg);
//    }

//    @Proxy()
//    @TargetClass(value = "android.graphics.Bitmap", scope = Scope.ALL)
//    @TargetMethod(methodName = "createBitmap")
//    public static Bitmap createBitmap(int width, int height, Bitmap.Config config) {
//
//        //分析该Bitmap的大小
//        float factor = 1;
//        if (config.name().equals(Bitmap.Config.ARGB_8888.name())) {
//            factor = 4;
//        } else if (config.name().equals(Bitmap.Config.ARGB_4444.name()) || config.name().equals(Bitmap.Config.RGB_565.name())) {
//            factor = 2;
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && config.name().equals(Bitmap.Config.RGBA_F16.name())) {
//            factor = 8;
//        }
//        float size = width * height * factor / (1024f * 1024f);
//        Log.d("xfhy666", "这里在创建Bitmap size=" + size + "M");
//        //这里如果遇到size过大的可以打印堆栈
//        return (Bitmap) Origin.call();
//    }
//监控list，hashmap的扩容
//    当前方法不行
//    @Proxy()
//    @TargetClass(value = "java.util.ArrayList", scope = Scope.SELF)
//    @TargetMethod(methodName = "grow")
//    private void grow(int minCapacity) {
//        ArrayList temp = (ArrayList) This.get();
//        int size = temp.size();
//        Origin.call();
//        int newsize = temp.size();
//        Log.i(TAG, "grow() called with: source = [" + size + "] ,newsize = [" + newsize + "]");
//    }
//要用
// try {
//        DexposedBridge.findAndHookMethod(Class.forName("java.util.ArrayList"), "grow",
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        LogHelper.i( "ArrayList grow " + param.thisObject.getClass().getSimpleName()
//                                + "\n" + Log.getStackTraceString(new Throwable()));
//                        super.beforeHookedMethod(param);
//                    }
//                });
//    } catch (ClassNotFoundException e) {
//        e.printStackTrace();
//    }

//    @Proxy()
//    @TargetClass(value = "java.util.HashMap", scope = Scope.SELF)
//    @TargetMethod(methodName = "resize")
//    final Object resize() {
//        HashMap temp = (HashMap) This.get();
//        int size = temp.size();
//        Object rs = Origin.call();
//        int newsize = temp.size();
//        Log.i(TAG, "grow() called with: source = [" + size + "] ,newsize = [" + newsize + "]");
//        return rs;
//    }

    private static final String TAG = "ProxyTest";
}
