package com.chapter13.wrapper;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/5/31 21:59
 */
public class Arrays01 {
    public static void main(String[] args) {
        Integer[] a = {5,2,3};
        Arrays.toString(a);
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.copyOf(a, a.length));
        Arrays.fill(a, 99);
        System.out.println(Arrays.toString(a));
    }
}
