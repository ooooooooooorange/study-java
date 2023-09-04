package com.chapter12;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/5/28 23:39
 */
public class Exception01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            int res = a/b;
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
        System.out.println("程序继续执行");
    }

}
