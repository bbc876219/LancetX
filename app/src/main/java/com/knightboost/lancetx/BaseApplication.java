package com.knightboost.lancetx;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.StrictMode;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bbc.IActivityManagerTranscationInput;
import com.bbc.IPackageManangerTranscationInput;
import com.bbc.NativeHacker;
import com.hdquantum.android.slowdoctor.BuildConfig;
import com.taobao.android.dexposed.ClassUtils;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import dalvik.system.DexFile;
import de.robv.android.xposed.DexposedBridge;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;


public class BaseApplication extends Application {
    private static final String TAG = "BaseApplication";

    {
        Log.d(TAG, "instance initializer() called");
    }

    static {
        Log.d("BaseApplication", "static initializer() called");
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        NativeHacker.isDebug = true;
        NativeHacker.init(new NativeHacker.ConfigBuilder()
                .setHookOpen(true)
                .setHookClose(false)
                .setHookPTheadCreate(true)
                .setHookPTheadRun(true)
                .setInterceptCrash(true)
                .setHookPTheadDetach(false)
                .setHookPTheadSetName(false)
                .setHookPTheadJoin(false)
                .setHookPTheadExit(true)
        )

        ;

        NativeHacker.unhook();

        try {
            NativeHacker.hook(-2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //initStrictMode();
        if (Build.VERSION.SDK_INT <= 31) {
//            hookByDexposed();
//            pictureMonitor();
//            class ThreadMethodHook extends XC_MethodHook {
//                long start = 0L;
//
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    super.beforeHookedMethod(param);
//                    start = System.currentTimeMillis();
//                    Thread t = (Thread) param.thisObject;
//                    Log.i(TAG, "thread:" + t + ".run(), started..\n" + getStackTrace(new Throwable(), 5, 3));
//                }
//
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    super.afterHookedMethod(param);
//                    Thread t = (Thread) param.thisObject;
//                    Log.i(TAG, "thread:" + t + ".run(), exit..  cost:" + (System.currentTimeMillis() - start));
//                }
//            }
//
//            DexposedBridge.hookAllConstructors(Thread.class, new XC_MethodHook() {
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    super.afterHookedMethod(param);
//                    Thread thread = (Thread) param.thisObject;
//                    Class<?> clazz = thread.getClass();
//                    if (clazz != Thread.class) {
//                        Log.d(TAG, "found class extend Thread:" + clazz);
//                        DexposedBridge.findAndHookMethod(clazz, "run", new ThreadMethodHook());
//                    }
//                    Log.d(TAG, "Thread: " + thread.getName() + " class:" + thread.getClass() + " is created.\n"
//                            + getStackTrace(new Throwable(), 0)
//                    );
//                }
//            });
//            DexposedBridge.findAndHookMethod(Thread.class, "run", new ThreadMethodHook());
//            try {
//                DexposedBridge.findAndHookMethod(Class.forName("android.content.pm.IPackageManager"), "checkPermission",
//                        String.class,String.class,int.class, new XC_MethodHook() {
//                            private long start = 0L;
//                            private String methodName = "";
//
//                            @Override
//                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
////                                Log.i(TAG, "BinderProxy.transact beforeHookedMethod " + param.thisObject.getClass().getSimpleName()
////                                        //+ "\n" + getStackTrace(new Throwable())
////                                );
//                                //methodName = getBinderProxyMethodNameFormStackMsg(new Throwable());
//                                methodName = getStackTrace(new Throwable(), 3, 10);
//                                start = System.currentTimeMillis();
//                                super.beforeHookedMethod(param);
//
//                            }
//
//                            @Override
//                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                                super.afterHookedMethod(param);
//                                long cost = (System.currentTimeMillis() - start);
//                                //if (cost>5)
//                                {
//                                    Log.i("Transca", String.format("IPackageManager cost:%s args.lenght=%d args=%s methodName=%s ", cost, param.args.length, param.args, methodName));
//                                    if (param.args.length > 0) {
//                                        for (int i = 0; i < param.args.length; i++) {
//                                            Log.i("Transca", String.format("IPackageManager args[%d] = %s ", i, param.args[i]));
////                                            if (i == 1 && param.args[i] != null && param.args[i] instanceof Parcel) {
////                                                if (methodName.contains("android.app.IActivityManager$Stub$Proxy")) {
////                                                    IActivityManagerTranscationInput.onTransactPrintParcel((Integer) param.args[0], (Parcel) param.args[i]);
////                                                }
////                                                if (methodName.contains("android.content.pm.IPackageManager$Stub$Proxy")) {
////                                                    IPackageManangerTranscationInput.onTransactPrintParcel((Integer) param.args[0], (Parcel) param.args[i]);
////                                                }
////
////
////                                            }
//                                        }
//                                    }
//
//                                    Log.i("Transca", String.format("IPackageManager rs.class=%s  ,result=%s ", (param.getResult() != null ? param.getResult().getClass().getName() : "no result"), param.getResult()));
//                                }
//                            }
//                        });
//
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
            try {
                 DexposedBridge.findAndHookMethod(Class.forName("android.os.BinderProxy"), "transact",
                        int.class, Parcel.class, Parcel.class, int.class, new XC_MethodHook() {
                            private long start = 0L;
                            private String methodName = "";

                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                                Log.i(TAG, "BinderProxy.transact beforeHookedMethod " + param.thisObject.getClass().getSimpleName()
//                                        //+ "\n" + getStackTrace(new Throwable())
//                                );
                                //methodName = getBinderProxyMethodNameFormStackMsg(new Throwable());
                                methodName = getStackTrace(new Throwable(), 3, 10);
                                start = System.currentTimeMillis();
                                super.beforeHookedMethod(param);

                            }

                            @Override
                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                super.afterHookedMethod(param);
                                long cost = (System.currentTimeMillis() - start);
                                //if (cost>5)
                                {
                                    Log.i("Transca", String.format("BinderProxy cost:%s args.lenght=%d args=%s methodName=%s ", cost, param.args.length, param.args, methodName));
                                    if (param.args.length > 0) {
                                        for (int i = 0; i < param.args.length; i++) {
                                            Log.i("Transca", String.format("BinderProxy args[%d] = %s ", i, param.args[i]));
//                                            if (i == 1 && param.args[i] != null && param.args[i] instanceof Parcel) {
//                                                if (methodName.contains("android.app.IActivityManager$Stub$Proxy")) {
//                                                    IActivityManagerTranscationInput.onTransactPrintParcel((Integer) param.args[0], (Parcel) param.args[i]);
//                                                }
//                                                if (methodName.contains("android.content.pm.IPackageManager$Stub$Proxy")) {
//                                                    IPackageManangerTranscationInput.onTransactPrintParcel((Integer) param.args[0], (Parcel) param.args[i]);
//                                                }
//
//
//                                            }
                                        }
                                    }

                                    Log.i("Transca", String.format("BinderProxy rs.class=%s  ,result=%s ", (param.getResult() != null ? param.getResult().getClass().getName() : "no result"), param.getResult()));
                                }
                            }
                        });
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
//            DexposedBridge.findAndHookMethod(DexFile.class, "loadDex", String.class, String.class, int.class, new XC_MethodHook() {
//                long start = 0L;
//
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    super.beforeHookedMethod(param);
//                    start = System.currentTimeMillis();
//
//                }
//
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    super.afterHookedMethod(param);
//                    String dex = (String) param.args[0];
//                    String odex = (String) param.args[1];
//                    Log.i(TAG, String.format("DexFile.loadDex.afterHookedMethod exit.. cost:%s   input:%s   out:%s \n%s", (System.currentTimeMillis() - start), dex, odex, getStackTrace(new Throwable(), 3, 1)));
//                }
//            });
//            try {
//                DexposedBridge.findAndHookMethod(Class.forName("java.lang.ClassLoader"), "findClass",
//                        java.lang.String.class, new XC_MethodHook() {
//                            @Override
//                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                                String name = (String) param.args[0];
//                                Log.i(TAG, "app start loaded class: " + name
//                                        + "\n" + Log.getStackTraceString(new Throwable()));
//                                super.beforeHookedMethod(param);
//                            }
//                        });
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//            DexposedBridge.findAndHookMethod(WebView.class, "loadUrl", String.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    Log.e("epic.hook", "loadUrl:" + param.args[0]);
//                }
//            });
////            String SQLiteDatabaseClass = "com.tencent.wcdb.database.SQLiteDatabase";
////            try {
////                Class cls = ClassUtils.getClass(SQLiteDatabaseClass);
////                DexposedBridge.findAndHookMethod(cls, "rawQueryWithFactory",
////                        SQLiteDatabaseClass + ".CursorFactory", String.class, Object[].class, String.class, "com.tencent.wcdb.support.CancellationSignal",
////                        new XC_MethodHook() {
////                            @Override
////                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
////                                Log.e("rawQueryWithFactory", param.args[1] + ":" + param.args[3]);
////                            }
////                        });
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//            DexposedBridge.findAndHookMethod(TelephonyManager.class, "getDeviceId", new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    super.beforeHookedMethod(param);
//                    String className = param.method.getDeclaringClass().getName();
//                    String methodName = param.method.getName();
//                    Log.i(TAG, "检测到风险函数被调用: " + className + "#" + methodName);
//                    Log.d(TAG, getStackTrace(new Throwable(), 3));
//                }
//
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    super.afterHookedMethod(param);
//                    Log.d(TAG, "afterHookedMethod getDeviceId");
//                }
//            });
////            DexposedBridge.findAndHookMethod(Activity.class, "onCreate", Bundle.class, new XC_MethodReplacement() {
////
////                @Override protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
////                    // Re-writing the method logic outside the original method context is a bit tricky but still viable.
////				//...
////                    return null;
////                }
////
////            });
//            // Target class, method with parameter types, followed by the hook callback (XC_MethodHook).
////            DexposedBridge.findAndHookMethod(Activity.class, "onCreate", Bundle.class, new XC_MethodHook() {
////
////                // To be invoked before Activity.onCreate().
////                @Override
////                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
////                    // "thisObject" keeps the reference to the instance of target class.
////                    Activity instance = (Activity) param.thisObject;
////
////                    // The array args include all the parameters.
////                    Bundle bundle = (Bundle) param.args[0];
////                    Intent intent = new Intent();
////                    // XposedHelpers provide useful utility methods.
////                    XposedHelpers.setObjectField(param.thisObject, "mIntent", intent);
////
////                    // Calling setResult() will bypass the original method body use the result as method return value directly.
//////                    if (bundle.containsKey("return"))
//////                        param.setResult(null);
////                }
////
////                // To be invoked after Activity.onCreate()
////                @Override
////                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                    XposedHelpers.callMethod(param.thisObject, "sampleMethod", 2);
////                }
////            });
////            proxyArrayList_grow();
////            proxyHashMap_resize();
        }

    }

    /**
     * 初始化严苛模式——卡顿优化
     */
    private void initStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectCustomSlowCalls() //API等级11，使用StrictMode.noteSlowCode
                    .detectDiskReads() // 磁盘读取
                    .detectDiskWrites() // 磁盘写入
                    .detectNetwork()// or .detectAll() for all detectable problems
                    .penaltyLog() //在Logcat 中打印违规异常信息，Log通过StrictMode字段查看
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .setClassInstanceLimit(MainActivity.class, 1) // 限制某类的数量
                    .detectLeakedClosableObjects() //API等级11
                    .penaltyLog()
                    .build());
        }
    }
//    public static void proxyHashMap_resize() {
//        DexposedBridge.findAndHookMethod(HashMap.class, "resize", new XC_MethodHook() {
//            long start = 0L;
//
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                super.beforeHookedMethod(param);
//                start = System.currentTimeMillis();
//
//            }
//
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                super.afterHookedMethod(param);
//
//                Log.i(TAG, String.format("HashMap.resize.afterHookedMethod exit.. cost:%s   size:%s    \n%s", (System.currentTimeMillis() - start), ((HashMap) param.thisObject).size(), getStackTrace(new Throwable(), 0, 50)));
//            }
//        });
//    }
//
//    public static void proxyArrayList_grow() {
//        DexposedBridge.findAndHookMethod(ArrayList.class, "toArray",  new XC_MethodHook() {
//            long start = 0L;
//
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                super.beforeHookedMethod(param);
//                start = System.currentTimeMillis();
//
//            }
//
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                super.afterHookedMethod(param);
//                ArrayList list = (ArrayList) param.thisObject;
//                //Object arg = (Object) param.args[0];
//                long cost = System.currentTimeMillis() - start;
//                //if (list.size()>0)
//                {
//                    Log.i(TAG, String.format("ArrayList.add.afterHookedMethod exit.. cost:%s   list.size:%s    arg:%s \n%s", cost, list.size(), "null", getStackTrace(new Throwable(), 0)));
//                }
//            }
//        });
//    }

    private static String getStackTrace(Throwable e, int index) {

        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackArray = e.getStackTrace();
        for (int i = index; stackArray.length > index && i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }
        return sb.toString();
    }

    private static String getStackTrace(Throwable e, int index, int len) {

        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackArray = e.getStackTrace();
        for (int i = index; stackArray.length > index && i < stackArray.length && len > 0; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
            len--;
        }
        return sb.toString();
    }

    private static String getBinderProxyMethodNameFormStackMsg(Throwable e) {


        StackTraceElement[] stackArray = e.getStackTrace();
        StackTraceElement element = stackArray[5];
        if (stackArray.length > 5)
            return element.toString();
        else return "";

    }

    public void onCreate() {
        super.onCreate();
    }

    private static final String METHOD_SHOW_INPUT = "showSoftInput";
    private static final String METHOD_HIDE_INPUT = "hideSoftInputFromWindow";

    public static void hookByDexposed() {
        DexposedBridge.findAndHookMethod(InputMethodManager.class, "showSoftInput", View.class, int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                Log.d(TAG, "show beforeHookedMethod: " + param.thisObject);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Log.d(TAG, "show afterHookedMethod: " + param.thisObject);
            }
        });

        DexposedBridge.findAndHookMethod(InputMethodManager.class, "hideSoftInputFromWindow", IBinder.class, int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                Log.d(TAG, "hide beforeHookedMethod: " + param.thisObject);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Log.d(TAG, "hide afterHookedMethod: " + param.thisObject);
            }
        });

        DexposedBridge.findAndHookMethod(View.class, "setOnClickListener",
                View.OnClickListener.class, new XC_MethodHook() {


                    public void afterHookedMethod(MethodHookParam param) throws Throwable {
                        View instance = (View) param.thisObject;
                        View view = (View) param.args[0];
                        Log.w(TAG, "View.OnClickListener.afterHookedMethod() called with: param = [" + view + "]" + instance);
                    }
                }
        );

    }


    //    @Override
//    public XC_MethodHook.Unhook fetchHook() throws Exception {
//        return DexposedBridge.findAndHookMethod(Class.forName("com.xiaomi.channel.commonutils.android.MIUIUtils"),
//                "getIsMIUI", new XC_MethodReplacement() {
//                    @Override
//                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
//                        return MIUIUtils.IS_MIUI;
//                    }
//                });
//    }
//    private void replaceBitmapFactory(String str, Object... objArr) {
//        try {
//            DexposedBridge.findAndHookMethod(BitmapFactory.class, str, objArr);
//        } catch (Exception e2) {
//            if (this.mWebpErrorCallback != null) {
//                this.mWebpErrorCallback.onWebpError(2, e2.toString());
//            }
//        }
//    }
//    Class<BitmapFactory> cls = BitmapFactory.class;
//        try {
//        Method decodeByteArrayMethod = cls.getDeclaredMethod("decodeByteArray", new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, BitmapFactory.Options.class});
//        Method decodeFileDescriptorMethod = cls.getDeclaredMethod("decodeFileDescriptor", new Class[]{FileDescriptor.class, Rect.class, BitmapFactory.Options.class});
//        Method decodeStreamMethod = cls.getDeclaredMethod("decodeStream", new Class[]{InputStream.class, Rect.class, BitmapFactory.Options.class});
//        Method decodeFileMethod = cls.getDeclaredMethod("decodeFile", new Class[]{String.class, BitmapFactory.Options.class});
//    } catch (NoSuchMethodException unused) {
//    }
    public static void pictureMonitor() {
        DexposedBridge.findAndHookMethod(ImageView.class, "setImageBitmap", Bitmap.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                if (param.thisObject instanceof ImageView) {
                    final ImageView imageView = (ImageView) param.thisObject;
                    if (imageView.getDrawable() instanceof BitmapDrawable) {
                        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
                        final Bitmap bitmap = drawable.getBitmap();
                        bitmapListener(imageView, bitmap);
                    }
                }
            }
        });
    }

    private static void bitmapListener(ImageView imageView, Bitmap bitmap) {
        if (bitmap != null) {
            //bitmap 宽高
            int bitmapWidth = bitmap.getWidth();
            int bitmapHeight = bitmap.getHeight();
            //视图宽高
            int viewWidth = imageView.getWidth();
            int viewHeight = imageView.getHeight();
            if (viewHeight > 0 && viewWidth > 0) {
                //view 有宽高
                //当图片宽高都大于视图宽高的2倍时就报出警告
                if (bitmapWidth >= viewWidth << 2 && bitmapHeight >= viewHeight << 2) {
                    warn(bitmapWidth, bitmapHeight, viewWidth, viewHeight);
                }
            } else {
                imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        int bitmapWidth = bitmap.getWidth();
                        int bitmapHeight = bitmap.getHeight();
                        int viewWidth = imageView.getWidth();
                        int viewHeight = imageView.getHeight();
                        if (bitmapWidth >= viewWidth << 2 && bitmapHeight >= viewHeight << 2) {
                            warn(bitmapWidth, bitmapHeight, viewWidth, viewHeight);
                        } else {
                            warn(bitmapWidth, bitmapHeight, viewWidth, viewHeight);
                        }
                        imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                        return true;
                    }
                });
            }
        }
    }

    private static void warn(int bitmapWidth, int bitmapHeight, int viewWidth, int viewHeight) {
        StringBuffer msg = new StringBuffer();
        msg.append("图片大小不合理：")
                .append("bitmapWidth=").append(bitmapWidth)
                .append(",bitmapHeight=").append(bitmapHeight)
                .append(",viewWidth=").append(viewWidth)
                .append(",viewHeight=").append(viewHeight);
        //不合理
        Log.e(TAG, Log.getStackTraceString(new Throwable(msg.toString())));
    }

}
