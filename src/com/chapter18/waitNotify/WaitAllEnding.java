package com.chapter18.waitNotify;

/**
 * @Description: 3.等待结束
 * @Author: xuzixin9
 * @Date: 2023/6/16 16:41
 */
public class WaitAllEnding {
    public static void main(String[] args) throws InterruptedException {
        int workerNum = 100;
        MyLatch latch = new MyLatch(workerNum);
        Worker[] workers = new Worker[workerNum];
        for(int i = 0; i < workerNum; i++) {
            workers[i] = new Worker(latch);
            workers[i].start();
        }
        latch.await();
        System.out.println("collect worker results");
    }
}
class MyLatch {
    private int count;//子线程个数
    public MyLatch(int count) {
        this.count = count;
    }
    public synchronized void await() throws InterruptedException {
        while(count > 0) {//如果还有子线程没结束，就wait
            wait();
        }
    }
    public synchronized void countDown() {
        count--;
        if(count <= 0) {
            notifyAll();
        }
    }
}

class Worker extends Thread {
    MyLatch latch;
    public Worker(MyLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000));//模拟子线程工作
            this.latch.countDown();//子线程结束
        } catch (InterruptedException e) {
        }
    }
}