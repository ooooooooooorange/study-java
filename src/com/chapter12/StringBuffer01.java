package com.chapter12;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/5/29 22:18
 */
public class StringBuffer01 {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();//value = char[16],用于存放字符内容
        StringBuffer sb2 = new StringBuffer("123");
        StringBuffer sb3 = new StringBuffer(30);//value = char[capacity],用于存放字符内容
        System.out.println(sb2);
    }
}
