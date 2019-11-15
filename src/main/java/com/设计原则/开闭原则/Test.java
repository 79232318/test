package com.设计原则.开闭原则;

public class Test {
    public static void main(String[] args) {
        SnowCake sc = new SnowCake(100,"原味",55.0);
        System.out.println(sc);
        SnowCake sc1 = new SnowCakeDiscount(100,"原味",55.0);
        System.out.println(sc1);
    }
}
