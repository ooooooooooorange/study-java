package com.chapter10.innerClass;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
        System.out.println(cellphone.new Inner());//成员内部类：Cellphone$Inner
        System.out.println(new Cellphone.InnerStatic());//静态内部类：Cellphone$InnerStatic
    }
}

interface Bell{
    void ring();
}

class Cellphone {
   public void alarmClock(Bell bell){
       bell.ring();
   }
   public class Inner{

   }

    public static class InnerStatic{
       String name;
    }
}