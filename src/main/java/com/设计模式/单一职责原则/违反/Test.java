package com.设计模式.单一职责原则.违反;

public class Test {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.mainMoveMode("猫头鹰");
        bird.mainMoveMode("变色龙");
    }
}
