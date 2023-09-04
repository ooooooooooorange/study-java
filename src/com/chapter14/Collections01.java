package com.chapter14;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/7 13:44
 */
public class Collections01 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(new AA("1"));
        list.add(new AA("44"));
        list.add(new AA("3"));
        list.add(new AA("2"));
//        list.add("1");
//        list.add("4");
//        list.add("3");
//        list.add("2");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.swap(list, 0, 3);
        System.out.println(list);
    }

}

class AA implements Comparable{
    private String name;

    public AA(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AA{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        AA other = (AA) o;
        return this.getName().compareTo(other.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AA aa = (AA) o;
        return Objects.equals(name, aa.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
