package com.chapter23;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/17 17:09
 */
public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //从配置文件中读取信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/chapter23/re.properties"));
        properties.list(System.out);
        String classFullName = properties.getProperty("classfullpath");
        String method = properties.getProperty("method");
        try {
            //使用反射机制：先获取Class对象
            Class cla = Class.forName(classFullName);
            System.out.println("cla = " + cla);
            //根据Class对象获取类型实例
            Object obj = cla.newInstance();
            System.out.println("obj的运行类型：" + obj.getClass());
            //获取cla对象对应类中的method方法对象
            Method method1 = cla.getMethod(method);
            System.out.println("method1 = " + method1);
            //调用obj对象的method方法:方法对象.invoke(类对象)
            method1.invoke(obj);
            //获取obj对象的name属性
            Field nameField = cla.getField("name");
            System.out.println("name = " + nameField.get(obj));
            //获取cls对象的无参构造器
            Constructor parameterlessConstructor = cla.getConstructor();
            System.out.println("parameterlessConstructor = " + parameterlessConstructor);
            Object obj2 = parameterlessConstructor.newInstance();//使用构造器创建对象
            //获取cls对象的有参构造器
            Constructor parameterizedConstructor = cla.getConstructor(String.class);
            System.out.println("parameterizedConstructor = " + parameterizedConstructor);
            Object obj3 = parameterizedConstructor.newInstance("小白");//使用构造器创建对象
        } catch (Exception e) {
            e.printStackTrace();
        }

        Reflection01 reflection01 = new Reflection01();
        reflection01.printMyself();
    }
    public void printMyself() throws ClassNotFoundException {
        Class cls = this.getClass();
        System.out.println(cls.getName());

        ClassLoader classLoader = this.getClass().getClassLoader();
        classLoader.loadClass("Java.lang.String");
    }
}
