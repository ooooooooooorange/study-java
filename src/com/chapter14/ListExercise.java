package com.chapter14;

import java.util.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/2 1:03
 */
public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add("hello" + i);
        }
        list.add(1, "javaEdu");
        System.out.println(list.get(4));
        list.remove(5);
        list.set(6, "666");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
//        Object[] objects = list.toArray();
//        Arrays.sort(objects, new Comparator<Object>(){
//            @Override
//            public int compare(Object o1, Object o2) {
//                String s1 = (String) o1;
//                String s2 = (String) o2;
//                return s1.compareTo(s2);
//            }
//        });
//        System.out.println(Arrays.toString(objects));

        list.sort(new Comparator() {
                      @Override
                      public int compare(Object o1, Object o2) {
                          String s1 = (String) o1;
                          String s2 = (String) o2;
                          return s1.compareTo(s2);
                      }
                  }
        );
        System.out.println(list);
        Collection collection = new ArrayList<>();
        collection.add(null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Integer(1));
        ArrayList arrayList1 = new ArrayList(5);

        Vector vector = new Vector<>();
        vector.add(null);
    }
}
