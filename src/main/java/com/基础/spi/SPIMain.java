package com.基础.spi;

import java.util.ServiceLoader;
//需要META-INF/services下有文件
public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
    }
}