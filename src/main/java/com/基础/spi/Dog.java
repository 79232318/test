package com.基础.spi;
public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}