package com.设计原则.合成复用or组合复用原则;

public class Test {

    public static void main(String[] args){
        ProductDao productDao = new ProductDao();
        productDao.setDbConnection(new MySQLConnection());
        productDao.addProduct();
    }
}

