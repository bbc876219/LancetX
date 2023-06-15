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
}
