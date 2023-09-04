package com.chapter14;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/7 11:07
 */
public class TreeMap01 {
    public static void main(String[] args) {
//        TreeSet treeSet = new TreeSet<>(new Comparator<Object>() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 1;
//            }
//        });
//        treeSet.add(null);
//        treeSet.add(null);
//        treeSet.add(null);

//        treeSet.add(new B("hello1"));
//        treeSet.add(new B("hello2"));
//        treeSet.add(new B("hello3"));
//        treeSet.add(new C());
//        System.out.println(treeSet);

        TreeMap treeMap = new TreeMap<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 1;
            }
        });
        treeMap.put(null,null);
        treeMap.put(null,null);
        treeMap.put(null,null);
        System.out.println(treeMap);
    }
}
class A implements Comparable{
    private String name;

    public A(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                "}\n";
    }

    @Override
    public int compareTo(Object o) {
        A other = (A) o;
        return this.getName().compareTo(other.getName());
    }
}
class B extends A{
    public B(String name) {
        super(name);
    }
}
class C{

}
