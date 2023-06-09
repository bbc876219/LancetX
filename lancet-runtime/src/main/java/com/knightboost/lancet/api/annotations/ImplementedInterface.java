package com.knightboost.lancet.api.annotations;

import com.knightboost.lancet.api.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 与TargetClass类似，表示修改的是实现了目标接口的类
 */
@Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({ElementType.TYPE, ElementType.METHOD})
public @interface ImplementedInterface {

    String[] value();

    Scope scope() default Scope.SELF;
}
