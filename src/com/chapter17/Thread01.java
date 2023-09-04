package com.chapter17;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/12 12:48
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();//启动新线程→最终执行myThread的run方法

        //启动MyThread2线程，这里没有办法直接调用start，需要先创建线程对象
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();

        //验证：myThread线程并不会阻塞main线程，是交替执行的
        for (int i = 0; i < 30; i++) {
            System.out.println("线程名:"+ Thread.currentThread().getName() +",运行"+i+"次");
            Thread.sleep(1000);
            System.out.println();
        }
    }
}

//1当一个类继承了Thread类，该类就可以当做线程使用
class MyThread1 extends Thread {
    @Override
    //Thread类实现了Runnable接口的run方法
    public void run() {//重写run方法，写上自己的业务代码
        int i = 0;
        while (true) {
            i++;
            System.out.println("线程名:"+ Thread.currentThread().getName() +",运行"+i+"次");
            try {
                sleep(1000);//休眠线程一秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i > 100){
                break;
            }
        }
    }
}

//2当一个类实现Runnable接口，该类就可以当做线程使用
class MyThread2 implements Runnable {
    @Override
    //Thread类实现了Runnable接口的run方法
    public void run() {//重写run方法，写上自己的业务代码
        int i = 0;
        while (true) {
            i++;
            System.out.println("线程名:"+ Thread.currentThread().getName() +",运行"+i+"次");
            try {
                Thread.sleep(1000);//休眠线程一秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i > 100){
                break;
            }
        }
    }
}
