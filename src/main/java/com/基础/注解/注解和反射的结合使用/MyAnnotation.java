package com.基础.注解.注解和反射的结合使用;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//首先反射注解，那么保留策略必须是Runtime，也就是@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MyAnnotation {
    int value();
}