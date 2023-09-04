package com.chapter18.waitNotify;

/**
 * @Description: 2.同时开始
 * @Author: xuzixin9
 * @Date: 2023/6/16 16:11
 */
public class allRun {
    public static void main(String[] args) throws InterruptedException{
        int num = 10;
        FireFlag fireFlag = new FireFlag();//信号枪
        Thread[] racers = new Thread[num];
        for(int i = 0; i < num; i++) {
            racers[i] = new Racer(fireFlag);//新建10个运动员线程，共用一个信号枪
            racers[i].start();
        }
        Thread.sleep(1000);
        System.out.println("fire!");
        fireFlag.fire();//main线程充当发令员，发出开跑信号
    }
}

class FireFlag {
    private volatile boolean fired = false;//volatile保证可见性

    public synchronized void waitForFire() throws InterruptedException {//等待信号枪发令
        while(!fired){
            System.out.println(Thread.currentThread().getName() + " is waiting for firing.");
            wait();
        }
    }

    public synchronized void fire() {//信号枪发令
        this.fired = true;
        notifyAll();//唤醒运动员们
    }
}

class Racer extends Thread {//运动员类
    FireFlag fireFlag;
    public Racer(FireFlag fireFlag) {
        this.fireFlag = fireFlag;
    }
    @Override
    public void run() {
        try {
            this.fireFlag.waitForFire();
            System.out.println("start run " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
        }
    }
}