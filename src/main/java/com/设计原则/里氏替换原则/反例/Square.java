package com.设计原则.里氏替换原则.反例;

public class Square extends Rectangle{
    private long sideLength;

    public long getSideLength() {
        return sideLength;
    }

    public void setSideLength(long sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public long getLength() {
        return getSideLength();
    }

    @Override
    public long getWidth() {
        return getLength();
    }

    @Override
    public void setLength(long length) {
       setSideLength(length);
    }

    @Override
    public void setWidth(long width) {
        setSideLength(width);
    }
}

