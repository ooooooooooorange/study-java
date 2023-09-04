package com.chapter19;

import java.io.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/6 23:17
 */
public class ObjectInputStream01 {
    public static void main(String[] args) throws Exception {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src//com//chapter19//ObjectOutputStream01.txt"))){
            output.writeInt(100);//int -> Integer,自动装箱，且Integer是Number的子类，Number实现了Serializable接口
            output.writeBoolean(true);
            output.writeChar('a');
            output.writeDouble(3.14);
            output.writeUTF("HelloWorld");//String实现了Serializable接口
            output.writeObject(new Person("张三", 18));//Person实现了Serializable接口
        }

        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("src//com//chapter19//ObjectOutputStream01.txt"))){
            //读取（反序列化）的顺序要和写入（序列化）的顺序一致，否则抛异常
            System.out.println(input.readInt());
            System.out.println(input.readBoolean());
            System.out.println(input.readChar());
            System.out.println(input.readDouble());
            System.out.println(input.readUTF());
            System.out.println(input.readObject());
        }
    }
}
class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    int sex;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "Person[name=" + name + ",age=" + age + "]";
    }
}
