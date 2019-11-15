package com.设计原则.开闭原则;

public class SnowCake implements ICake {
    private Integer id;
    private String taste;
    private Double price;

    public SnowCake(Integer id, String taste, Double price) {
        this.id = id;
        this.taste = taste;
        this.price = price;
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    @Override
    public String getTaste() {
        return this.taste;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "SnowCake{" +
                "id=" + id +
                ", taste='" + taste + '\'' +
                ", price=" + price +
                '}';
    }
}
