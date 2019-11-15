package com.设计原则.依赖倒置原则.面向实现编程的例子;
//小明对淘宝上卖的鼠标 和 键盘都比较感兴趣
//这个是与 依赖倒置 原则 是背道而驰的
public class Test {
    public static void main(String[] args) {
       Buy buy = new Buy();
       buy.buyMouse();
       buy.buyKeyboard();
    }
}
