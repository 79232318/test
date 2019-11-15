package com.基础.泛型.demo;
/**
 * 自定义泛型类：
 * 1，<> -->单个字母，尽可能见名知意
 * 2，T   Type
 *    K V  Key Value
 *    E  Element
 * 3，注意泛型不能使用在静态属性上
 */
//T  type ，类型
public class MyStudent<T> {
    private T javase;
//    private static T test;//静态编译错误

    public MyStudent(){}
    public MyStudent(T javase) {
        super();
        this.javase = javase;
    }

    public T getJavase() {
        return javase;
    }

    public void setJavase(T javase) {
        this.javase = javase;
    }
}