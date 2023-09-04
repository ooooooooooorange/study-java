package com.chapter10.innerClass;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1(500);
    }
}


class Outer02 {
    private int n1 = 100;
    public void m2() {
        System.out.println("m2()");
    }
    public void m1(final int param) {
        final int a2 = 1;
        System.out.println("m1()");
        class Inner022 {//局部内部类
            private int n1 = 10;
            public void f1(){
                System.out.println(param);
                System.out.println(a2);
                System.out.println(n1);
                System.out.println(Outer02.this.n1);
                m2();
            }
        }
        Inner022 inner022 = new Inner022();
        inner022.f1();
    }

    {
        final int a1 = 10;
        System.out.println("代码块");
        class Inner021 {//局部内部类
            private int n1 = 10;
            public void f1(){
                System.out.println(a1);
                System.out.println(n1);
                System.out.println(Outer02.this.n1);
                m2();
            }
        }
        Inner021 inner021 = new Inner021();
        inner021.f1();
    }

}
