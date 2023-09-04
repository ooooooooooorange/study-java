package com.chapter10.interface_;

public class MysqlDB implements DBInterface{
    @Override
    public void connect() {
        System.out.println("连接mysql");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql");
    }
}
