package com.设计模式.单一职责原则.违反;
//创建一个鸟类 违反单一原则
public class Bird {
    public void mainMoveMode(String birdName){
        if ("变色龙".equals(birdName)){
            System.out.println("变色龙用四肢走");
        }else {
            System.out.println(birdName+"用翅膀飞");
        }
    }
}

