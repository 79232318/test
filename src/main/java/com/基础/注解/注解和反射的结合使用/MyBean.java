package com.基础.注解.注解和反射的结合使用;
public class MyBean {
    @MyAnnotation(20)
    private int value;
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}