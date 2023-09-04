package com.chapter14;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/5 13:00
 */
public class MapExercise {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, new Emp("jack", 300000, 1));
        map.put(2, new Emp("tom", 1000, 2));
        map.put(3, new Emp("milan", 120000, 3));
        Set entrySet = map.entrySet();
        for (Object o : entrySet) {
            Map.Entry entry = (Map.Entry) o;
            Emp emp = (Emp)entry.getValue();
            if((emp).getSal() > 10000){
                System.out.println(entry.getValue());
            }
        }
    }
}

class Emp{
    private String name;
    private double sal;
    private int id;

    public Emp(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }

    public int getId() {
        return id;
    }
}