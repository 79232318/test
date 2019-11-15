package com.设计模式.单一职责原则;

public class Test {
    public static void main(String[] args) {
        FlyBird flyBird = new FlyBird();
        WalkAnimal walkAnimal = new WalkAnimal();
        //应用层判断
        flyBird.mainMoveMode("猫头鹰");
        walkAnimal.mainMoveMode("变色龙");
    }
}
