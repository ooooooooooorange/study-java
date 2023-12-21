package com.cloneTest;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * @Description: 深拷贝工具类
 * @Author: xuzixin9
 * @Date: 2023/12/21 21:57
 */
public class CloneUtil {
    /**
     * 深拷贝对象
     * @param obj 要拷贝的对象（需要实现序列化Serializable）
     * @return 深拷贝后的新对象
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deepClone(T obj){
        T cloneObj = null;
        //写入字节流
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();

            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return cloneObj;
    }

    /**
     * 深拷贝List
     * @param list 要拷贝的List(对象需要实现序列化Serializable)
     * @return 深拷贝后的新List
     */
    public static <T extends Serializable> List<T> deepClone(List<T> list){
        List<T> cloneList = new ArrayList<>();
        list.forEach(item -> cloneList.add(deepClone(item)));
        return cloneList;
    }
}
