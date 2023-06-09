package com.knightboost.lancet.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 修改指定类的父类beforeExtend to afterExtend（）
 * classNameFilterRegex是用来过滤正则表达式
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ChangeClassExtends {
    /**
     * 目标父类，fullname
     */
    String beforeExtend() default "";

    /**
     * 新的父类名，fullname
     */
    String afterExtend() default "";

    /**
     * 过滤用的正则表达式："(?!me/ele/).*"
     *
     * @return
     */
    String classNameFilterRegex() default "";

}
