package com.knightboost.lancet.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ChangeClassExtends {
    String beforeExtend() default "";
    String afterExtend() default "";
    String classNameFilterRegex() default "";

}
