package com.knightboost.lancet.api.annotations;

import com.knightboost.lancet.api.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 要修改的目标类
 */
@Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({ElementType.TYPE, ElementType.METHOD})
public @interface TargetClass {
    /**
     * 目标类名
     */
    String value();


    /**
     * 从继承体系角度 控制  weave 操作范围
     */

    Scope scope() default Scope.SELF;

    /**
     * 类名正则匹配限定
     * 过滤用的正则表达式："(?!me/ele/).*"
     */
    String nameRegex() default "";
}
