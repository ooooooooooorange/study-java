package com.chapter15;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/9 14:45
 */
public class Generic02 {
    public static void main(String[] args) {
        Pair<String> stringPair = new Pair<>();
        System.out.println(stringPair.getClass().getSimpleName());
        Pair<Integer> integerPair = new Pair<>();
//只能是引用类型
        List<Integer> list =  new ArrayList<Integer>();//正确
        //List<int> list =  new ArrayList<int>();//报错

        List<String> list2 =  new ArrayList<String>();
        Class c1 = list.getClass();
        Class c2 = list2.getClass();
        System.out.println(c1);
        System.out.println(c1 == c2);//true
        //System.out.println(list instanceof List<Integer>);

        List<? extends Number> extendsList = null;//用通配符实例化
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        extendsList = integers;
//只能读
        Number numObject = extendsList.get(0);  //正确，可以读
        Integer intObject = (Integer) extendsList.get(0); //错误，要根据实际类型
        System.out.println(numObject);
        System.out.println(intObject);
//不能写
        //extendsList.add(new Integer(1));//错误
//
//        List<? super Integer> superList = null;//用通配符实例化
//        superList = new ArrayList<Number>();
////不能读
//        Number numObj = superList.get(0);  //错误
//        Integer intObj = superList.get(0); //错误
////只能写
//        superList.add(new Integer(1));  //正确
    }
}
class Pair<T> {
    private T first ;
    private T last;

    //private T[] arr = new T[8];//编译器报错
    private T[] arr1;//可以

    public Pair() {
    }

    public Pair(Class<T> first) throws InstantiationException, IllegalAccessException {
        //this.first = new T();//编译器报错
        this.first = first.newInstance();//编译器报错
    }

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }

    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }
}