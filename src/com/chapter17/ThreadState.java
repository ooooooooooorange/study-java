package com.chapter17;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/12 20:27
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T1());
        System.out.println("t1的状态：" + t1.getState());//NEW
        t1.start();
        System.out.println("t1的状态：" + t1.getState());//RUNNABLE
        while (Thread.State.TERMINATED != t1.getState()) {
            System.out.println("t1的状态：" + t1.getState());//RUNNABLE、TIMED_WAITING
            Thread.sleep(500);
        }
        System.out.println("t1的状态：" + t1.getState());//TERMINATED
    }
}
