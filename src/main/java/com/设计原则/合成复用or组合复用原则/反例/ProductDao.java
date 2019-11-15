package com.设计原则.合成复用or组合复用原则.反例;

public class ProductDao extends DBConnection {
    public void addProduct(){
        String conn = super.getConnection();
        System.out.println("使用"+conn+"增加产品");
    }
}

