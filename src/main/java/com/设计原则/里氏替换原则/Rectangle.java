package com.设计原则.里氏替换原则;

public class Rectangle implements QRangle{
    private long length;
    private long width;

    public long getLength() {
        return length;
    }

    public long getWidth() {
        return width;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
