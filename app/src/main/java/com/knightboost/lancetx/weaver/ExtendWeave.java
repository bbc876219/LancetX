package com.knightboost.lancetx.weaver;

import com.knightboost.lancet.api.annotations.ChangeClassExtends;
import com.knightboost.lancet.api.annotations.Group;
import com.knightboost.lancet.api.annotations.Weaver;
import com.knightboost.lancetx.ProxyThread;

@Weaver
@Group("ExtendTest")
public class ExtendWeave {

    @ChangeClassExtends(
            beforeExtend = "java.lang.Thread",
            afterExtend = "com.yxy.monitormodel.proxy.TBaseThread",
            classNameFilterRegex = ""
    )
    public void extendThreadChange(){};
    @ChangeClassExtends(
            beforeExtend = "android.os.Handler",
            afterExtend = "com.yxy.monitormodel.proxy.GlobalHandler",
            classNameFilterRegex = ""
    )
    public void extendHandlerChange(){};
    @ChangeClassExtends(
            beforeExtend = "android.os.HandlerThread",
            afterExtend = "com.yxy.monitormodel.proxy.TBaseHandlerThread",
            classNameFilterRegex = ""
    )
    public void extendHandlerThreadChange(){};
    @ChangeClassExtends(
            beforeExtend = "java.util.concurrent.ScheduledThreadPoolExecutor",
            afterExtend = "com.yxy.monitormodel.proxy.TBaseScheduledThreadPoolExecutor",
            classNameFilterRegex = ""
    )
    public void extendScheduledThreadPoolExecutor(){};
    @ChangeClassExtends(
            beforeExtend = "java.util.concurrent.ThreadPoolExecutor",
            afterExtend = "com.yxy.monitormodel.proxy.TBaseThreadPoolExecutor",
            classNameFilterRegex = ""
    )
    public void extendThreadPoolExecutor(){};
    @ChangeClassExtends(
            beforeExtend = "java.util.concurrent.ThreadFactory",
            afterExtend = "com.yxy.monitormodel.proxy.TBaseThreadFactory",
            classNameFilterRegex = ""
    )
    public void extendThreadFactory(){};

    @ChangeClassExtends(
            beforeExtend = "java.lang.Runnable",
            afterExtend = "com.yxy.monitormodel.proxy.TBaseRunnable",
            classNameFilterRegex = ""
    )
    public void extendRunnable(){};
}
