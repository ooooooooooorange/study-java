package com.chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/9 15:29
 */
public class Generic03 {
    public static void main(String[] args) {
        Car car = new Car();
        car.run3("宝马");//当调用方法时，编译器会根据传入的参数类型确定泛型类型

    }
}
class Car<T>{
    public void run1(){}//普通方法
    public void run2(T t){}//普通方法
    public <V> void run3(V v){}//泛型方法
}
