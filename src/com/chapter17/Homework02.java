package com.chapter17;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/12 22:53
 */
public class Homework02 {
    public static void main(String[] args) {
        A a = new A();
        a.start();

        B b = new B(a);
        b.start();
    }
}
class A extends Thread{
    //用属性running控制一直打印1-100的随机整数
    private boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (running){
            System.out.println((int)(Math.random()*100+1));
            //休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//如果输入了Q，就结束线程A
class B extends Thread{
    private A a;
    Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            if (scanner.next().equalsIgnoreCase("Q")) {
                a.setRunning(false);
                break;
            }
        }
    }
}