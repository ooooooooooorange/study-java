package com.chapter23;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Period;

/**
 * @Description: 通过反射获取类的结构信息
 * @Author: xuzixin9
 * @Date: 2023/7/18 16:14
 */
public class ReflectionUtils {
    @Test
    public void test1() throws ClassNotFoundException {
        Class personCls = Class.forName("com.chapter23.Person");
        //获取类的全名
        System.out.println("类全名：" + personCls.getName());
        //获取类的简单名
        System.out.println("类简单名：" + personCls.getSimpleName());
        //获取类的属性（父类+子类的public属性）
        Field[] fields = personCls.getFields();
        System.out.print("类的属性（父类+子类的public属性）：");
        for (Field field : fields) {
            System.out.print(field.getName() + " ");
        }
        //获取类的属性（本类的所有属性）
        Field[] declaredFields = personCls.getDeclaredFields();
        System.out.print("\n类的属性（本类的所有属性）：");
        for (Field declaredField : declaredFields) {
            System.out.print(declaredField.getName() + " ");
        }
        //获取类的方法（父类+子类的public方法）
        System.out.print("\n类的方法（父类+子类的public方法）：");
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + " ");
        }
        //获取类的方法（本类的所有方法）
        System.out.print("\n类的方法（本类的所有方法）：");
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.print(declaredMethod.getName() + " ");
        }
        //获取类的构造器（本类z的public构造器）
        System.out.print("\n类的构造器（本类的public构造器）：");
        Constructor[] constructors = personCls.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.print(constructor.getName() + " ");
        }
        //获取类的构造器（本类的所有构造器）
        System.out.print("\n类的构造器（本类的所有构造器）：");
        Constructor[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.print(declaredConstructor.getName() + " ");
        }
        //获取类的包名
        Package package1 = personCls.getPackage();
        System.out.println("\n类的包名：" + package1.getName());
        //获取类的父类
        Class superCls = personCls.getSuperclass();
        System.out.println("类的父类：" + superCls.getName());
        //获取类的接口信息
        Class[] interfaces = personCls.getInterfaces();
        System.out.print("类的接口信息：");
        for (Class anInterface : interfaces) {
            System.out.print(anInterface.getName() + " ");
        }
        //获取类的注解信息
        System.out.print("\n类的注解信息：");
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.print(annotation + " ");
        }
    }
    
    @Test
    public void test2() throws Exception {
        Class personCls = Class.forName("com.chapter23.Person");
        //获取类的属性（本类的所有属性）
        Field[] declaredFields = personCls.getDeclaredFields();
        System.out.println("\n类的属性（本类的所有属性）：");
        for (Field declaredField : declaredFields) {
            System.out.println("属性名：" + declaredField.getName() + "，修饰符：" + declaredField.getModifiers());
        }

        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        //获取类的特定字段
        Field salField = p1.getClass().getDeclaredField("sal");
        //设置字段的可访问性
        salField.setAccessible(true);
        //通过反射设置字段的值
        salField.set(p1, 100);
        salField.set(p2, 200);
        salField.set(p3, 300);
        //通过反射获取字段的值
        System.out.println("p1.sal = " + salField.get(p1));
        System.out.println("p2.sal = " + salField.get(p2));
        System.out.println("p3.sal = " + salField.get(p3));

        //获取类的特定方法
        Method m1 = p1.getClass().getDeclaredMethod("m1", String.class, int.class);
        //设置方法的可访问性
        m1.setAccessible(true);
        System.out.println(m1.getParameterTypes());
        //获取返回值类型
        System.out.println(m1.getReturnType());
        //通过反射调用方法
        System.out.println(m1.invoke(p1, "hello", 10));

        //获取类的特定构造器
        Constructor constructor = p1.getClass().getDeclaredConstructor(String.class, int.class);
        //设置构造器的可访问性
        constructor.setAccessible(true);
        //获取全类名
        System.out.println(constructor.getName());
        System.out.println(constructor);
        System.out.println(constructor.getAnnotatedReturnType());
        //通过反射创建对象
        Person p4 = (Person) constructor.newInstance("张三", 20);
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
@Deprecated
class Person extends A implements I1,I2{
    String job;

    public String name;
    private int sal;
    protected int age;

    static String n1;
    final String n2 = "n2";

    public int m1(String s, int n1){
        return n1*10;
    }

    protected void m2(){
    }

    void m3(){
    }

    private void m4() {
    }

    public Person(){
    }

    private Person(String name){
    }

    protected Person(String name, int age){
    }
}

class A{
    public String hobby;
    private String car;

    public void hi(){
        System.out.println("hi");
    }

    public A(){

    }
}
interface I1{
}
interface I2{
}
