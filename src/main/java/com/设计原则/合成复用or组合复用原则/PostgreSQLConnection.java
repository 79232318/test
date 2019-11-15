package com.设计原则.合成复用or组合复用原则;

public class PostgreSQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return " PostgreSQL数据库连接";
    }
}

