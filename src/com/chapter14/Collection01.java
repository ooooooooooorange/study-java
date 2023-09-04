package com.chapter14;

import java.util.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/1 22:30
 */
public class Collection01 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("jack");
        list.add(10);
        list.add(true);
        list.remove(new Integer(10));
        System.out.println(list);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        iterator.remove();
    }
}
