package com.chapter23.classload_;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/18 15:09
 */
public class ClassLoad03 {
    public static void main(String[] args) {
        System.out.println(B.num);//直接使用类的静态属性，导致类加载
        //输出：(不会执行构造函数)
        //B类的静态代码块被执行
        //100

        //加载类B的过程
        //1.加载：加载B类,并生成B的class对象
        //2.连接：
        //    a.验证：验证B类的正确性；
        //    b.准备：给类的静态成员变量num在方法区分配内存且赋默认值0；
        //    c.解析：把符号引用转换为直接引用
        //3.初始化：依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句，合并后按顺序执行（故执行顺序由语句在源文件中出现的顺序决定）
        //clinit(){
        //    System.out.println("B类的静态代码块被执行");
        //    num = 300;
        //    num = 100;
        //}

    }
}
class B{
    static {
        System.out.println("B类的静态代码块被执行");
        num = 300;
    }
    static int num = 100;
    public B() {
        System.out.println("B类的无参构造器被执行");
    }
}
