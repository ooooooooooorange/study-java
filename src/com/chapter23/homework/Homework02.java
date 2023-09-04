package com.chapter23.homework;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/19 15:26
 */
public class Homework02 {
    public static void main(String[] args) throws Exception {
        Class<File> fileClass = File.class;
        Constructor<?>[] constructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor<File> constructor = fileClass.getDeclaredConstructor(String.class);
        File file = constructor.newInstance("src/com/chapter23/homework/mynew.txt");
        Method method = fileClass.getMethod("createNewFile");
        method.invoke(file);
    }
}
