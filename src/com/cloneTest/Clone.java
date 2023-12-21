package com.cloneTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Description: 深拷贝、浅拷贝
 * @Author: xuzixin9
 * @Date: 2023/12/21 21:30
 */
public class Clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("apple"));
        list.add(new Fruit("banana"));

        List<Fruit> newList;

        // 浅拷贝
        System.out.println("通过构造函数方法浅拷贝：");
        newList = new ArrayList<>(list);
        printList(list, newList);

        //addAll()方法
        System.out.println("通过addAll方法浅拷贝：");
        newList = new ArrayList<>();
        newList.addAll(list);
        printList(list, newList);

        System.out.println("通过Collections.copy方法浅拷贝：");
        newList = new ArrayList<>();
        newList.addAll(list);
        Collections.copy(newList, list);
        printList(list, newList);

        System.out.println("通过stream方法浅拷贝：");
        newList = new ArrayList<>();
        newList = list.stream().collect(toList());
        printList(list, newList);

        System.out.println("通过clone方法浅拷贝：");
        newList = new ArrayList<>();
        newList = (List<Fruit>) ((ArrayList<Fruit>) list).clone();
        printList(list, newList);

        // 深拷贝
        System.out.println("使用序列化方法可以实现深拷贝：");
        newList = new ArrayList<>();
        for(Fruit fruit: list) {
            Fruit newFruit = CloneUtil.deepClone(fruit);
            newList.add(newFruit);
        }
        printList(list, newList);

        System.out.println("使用序列化方法可以实现深拷贝：");
        newList = new ArrayList<>();
        newList = CloneUtil.deepClone(list);
        printList(list, newList);

    }

    static void printList(List<Fruit> oldlist, List<Fruit> newList){
        String oldName = oldlist.get(0).name;
        newList.get(0).name = "orange";
        System.out.print("oldList:");
        oldlist.forEach(fruit -> System.out.print(fruit.name + ","));
        System.out.print("\nnewList:");
        newList.forEach(fruit -> System.out.print(fruit.name + ","));
        System.out.println();
        System.out.println();
        newList.get(0).name = oldName;
    }
}

class Fruit implements Serializable {
    String name;
    public Fruit(String name){
        this.name = name;
    }

}
