package com.knightboost.lancetx.weaver;

import android.util.Log;

import com.knightboost.lancet.api.Origin;
import com.knightboost.lancet.api.Scope;
import com.knightboost.lancet.api.annotations.Group;
import com.knightboost.lancet.api.annotations.Proxy;
import com.knightboost.lancet.api.annotations.TargetClass;
import com.knightboost.lancet.api.annotations.TargetMethod;
import com.knightboost.lancet.api.annotations.Weaver;
import com.knightboost.lancetx.ClassA;

@Weaver
@Group("proxyTest")
public class ProxyTest {

    @Proxy()
    @TargetClass(value = "android.util.Log",scope = Scope.SELF)
    @TargetMethod(methodName = "i")
    public static int replaceLogI(String tag,String msg){
        msg = msg + "被替换proxy";
        return (int) Origin.call();
    }



    @Proxy()
    @TargetClass(value = "com.knightboost.lancetx.ClassA",scope = Scope.SELF)
    @TargetMethod(methodName = "printMessage")
    public static void printMessage(ClassA a, String msg){
        msg = msg + "被替换proxy <- printMessage";
        Log.e("ClassA",msg);
    }
}
