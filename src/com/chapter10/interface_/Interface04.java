package com.chapter10.interface_;

public class Interface04 {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("悟空");
        littleMonkey.climbing();
        littleMonkey.swimming();
        littleMonkey.flying();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println( name + " 会爬树...");
    }

    public String getName() {
        return name;
    }
}

class LittleMonkey extends Monkey implements Fishable, Birdable{
    LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println( getName() + " 通过学习，可以像🐟一样游泳...");
    }

    @Override
    public void flying() {
        System.out.println( getName() + " 通过学习，可以像鸟一样飞翔...");
    }
}

interface Fishable {
    void swimming();
}

interface Birdable {
    void flying();
}