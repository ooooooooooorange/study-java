package com.chapter23.classload_;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/18 14:56
 */
public class ClassLoad02 {
    public static void main(String[] args) {

    }
}
//分析类加载阶段的链接阶段-准备，属性是如何处理的
class A{
    //n1是实例属性，不是静态变量，因此在准备阶段并不会分配内存
    public int n1 =10;
    //n2是静态变量，会分配内存，赋默认值0，而不是20
    public static int n2 = 20;
    //n3是静态常量，它和静态变量不一样，也会分配内存，赋值为30（因为一旦赋值就不变，所以不会先赋默认值）
    public static final int n3 = 30;
}
