package com.chapter10.innerClass;

public class AnonymousInnerClass {
    public static void main(String[] args) {

    }
}

class Outer04 {
    private int n1 = 10;
    void asyncHello() {
        Interface01 r = new Interface01() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        //new了一个Father对象
        Father father = new Father("Jack");
        //new了匿名类的对象，该匿名类继承了Father
        Father father1 = new Father("Tom"){};
    }
}

interface Interface01 {//接口
    void run();
}

class Father {
    private String name;
    Father(String name) {
        this.name = name;
    }
    public void test() {
    }
}
