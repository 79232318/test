package com.设计原则.合成复用or组合复用原则;

public class MySQLConnection extends DBConnection{
    @Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}

