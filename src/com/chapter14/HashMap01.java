package com.chapter14;

import java.util.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/5 12:25
 */
public class HashMap01 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("key1",1);
        map.put("key2",2);
        map.put("key3",3);
        //调用`entrySet()`获取所有键值对的`Set<Map.Entry<K, V>>` 再遍历`Set`依次拿到 ` key `和`value`
        Set entrySet = map.entrySet();
        //2.1 迭代器 遍历entrySet
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            //向下转型为Entry，才能get key 和 value
            Map.Entry next =  (Map.Entry)iterator.next();
            System.out.println("key="+next.getKey()+";value="+next.getValue());
        }
        for (Object o : entrySet) {
            Map.Entry entry =  (Map.Entry)o;
            System.out.println("key="+entry.getKey()+";value="+entry.getValue());

        }
        //2.获取到keySet，再遍历 key 依次拿到 value
        Set keySet = map.keySet();
        //2.1 迭代器 遍历keySet
        iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("key="+next+";value="+map.get(next));
        }
        //2.2 增强for循环遍历keySet
        for (Object key : keySet) {
            System.out.println("key="+key+";value="+map.get(key));
        }

        //3.只关心value时, 获取value的集合values
        Collection values = map.values();
        iterator = values.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("value="+next);
        }
        for (Object value : values) {
            System.out.println("value="+value);
        }
    }
}
