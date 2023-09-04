package com.chapter17;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/12 20:03
 */
public class Homework01 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            System.out.println("hi" + i);
            if (i == 5) {
                Thread t1 = new Thread(new T1());
                t1.start();
                t1.join();
                System.out.println("子线程结束");
            }
        }
        System.out.println("主线程结束");
    }
}
class T1 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
