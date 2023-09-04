package com.chapter10.interface_;

public class OracleDB implements DBInterface{
    @Override
    public void connect() {
        System.out.println("连接Oracle");
    }

    @Override
    public void close() {
        System.out.println("关闭Oracle");
    }
}

interface I1{
    int i = 0;
    void hi();
}

interface I2{
    void hi();
}

class AA implements I1, I2 {

    @Override
    public void hi() {

    }
}
