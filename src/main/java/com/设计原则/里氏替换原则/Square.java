package com.设计原则.里氏替换原则;

public class Square implements QRangle{
    private long sideLength;

    public long getSideLength() {
        return sideLength;
    }

    public void setSideLength(long sideLength) {
        this.sideLength = sideLength;
    }

    public long getWidth() {
        return sideLength;
    }

    public long getLength() {
        return sideLength;
    }
}

