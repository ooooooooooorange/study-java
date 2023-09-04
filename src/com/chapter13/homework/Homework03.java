package com.chapter13.homework;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/1 1:47
 */
public class Homework03 {
    public static void main(String[] args) {
        printName("AAA bbb ccc");
    }
    public static void printName(String name) {
        if(name == null){
            System.out.println("名字不能为空");
            return;
        }
        String[] strings = name.split(" ");
        if(strings.length != 3){
            System.out.println("名字格式不正确");
            return;
        }
        System.out.printf("%s,%s .%c", strings[2], strings[0], Character.toUpperCase(strings[1].charAt(0)));
    }
}
