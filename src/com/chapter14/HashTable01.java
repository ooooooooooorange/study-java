package com.chapter14;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/5 16:52
 */
public class HashTable01 {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put(null, 123);
        hashtable.put("john", null);
    }
}
