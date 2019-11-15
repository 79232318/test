package com.设计原则.依赖倒置原则.满足依赖倒置原则;

public class BuyMouse implements Things {
    @Override
    public void buyThins() {
        System.out.println("小明正在买鼠标");
    }
}
