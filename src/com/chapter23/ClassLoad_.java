package com.chapter23;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/17 22:37
 */

import java.lang.reflect.*;
import java.util.*;
public class ClassLoad_{
public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入key");
        String key = scanner.next();
        switch(key) {
            case "1":
            Dog dog = new Dog();//静态加载
            dog.cry();
            break;
        case "2":
            Class cls = Class.forName("Person");//动态加载
            Object o = cls.newInstance();
            Method m = cls.getMethod("hi");
            m.invoke(o);
            break;
        default:
            System.out.println("do nothing..");
        }
    }
}
class Dog{
    public void cry(){
        System.out.println("wang~");
    }
}