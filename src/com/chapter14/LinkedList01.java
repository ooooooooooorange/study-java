package com.chapter14;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/3 20:08
 */
public class LinkedList01 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList<>();
        Set set = new HashSet<>();
        set.add("lucy");//添加成功
        set.add("lucy");//添加失败
        set.add(new Dog("tom"));//添加成功
        set.add(new Dog("tom"));//添加成功
        set.add(new String("jack"));//添加成功
        set.add(new String("jack"));//添加失败

    }
}
class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}