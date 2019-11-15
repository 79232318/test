package com.设计原则.依赖倒置原则.满足依赖倒置原则;

public class Test {
    public static void main(String[] args) {
    	Buy b = new Buy();
        b.setThings(new BuyMouse());
        b.buy();
    }
}
