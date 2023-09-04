package com.chapter18.waitNotify.exercise;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/18 17:00
 */
public class Interrupt01 {
    public static void main(String[] args) {
        Thread t = new Thread (){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(isInterrupted());
                }
            }
        };
        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        t.interrupt();
    }
}
