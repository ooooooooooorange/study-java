package com.chapter13.wrapper;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/5/29 14:46
 */
public class Integer01 {
    public static void main(String[] args) {
        boolean b1 = false;
        Boolean bObj1 = new Boolean(b1);	//手动装箱
        Boolean bObj2 = Boolean.valueOf(b1);	//手动装箱
        boolean b2 = bObj1.booleanValue();	//手动拆箱

        //包装类 转 String 的方法
        Integer i = 100;
        String s1 = "" + i;//很简单但效率最低
        String s2 = String.valueOf(i); //效率最高的方法
        String s3 = String.valueOf(new Integer(i)); //将一个char数组转换成String
        String s4 = Integer.toString(i);//实际上直接返回String.valueOf(char)
        String s5 = i.toString();



        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);//false,new出来的不是一个对象

        Integer.valueOf(127);
        Integer i3 = 127;//实质是调用Integer.valueOf(127);
        Integer i4 = 127;
        System.out.println(i3 == i4);//true.[-128,127]之间，是从ntegerCache.cache[]缓存数组中取，取出来是同一对象

        Integer i5 = 128;//实质是调用Integer.valueOf(128);
        Integer i6 = 128;
        System.out.println(i5 == i6);//false,[-128,127]范围之外，实质是new Integer(128),new出来的不是一个对象

        Integer i7 = 128;
        int i8 = 128;
        System.out.println(i7 == i8);//true,包装类型和基本类型判断==，比较的是值


        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = new String("abc");
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(a == c);
        System.out.println(a == c.intern());
        System.out.println(c == c.intern());
    }
}
