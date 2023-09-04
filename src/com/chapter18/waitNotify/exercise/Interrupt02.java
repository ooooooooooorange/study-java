package com.chapter18.waitNotify.exercise;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/18 17:12
 */
public class Interrupt02 {
    public static void main(String[] args) {
        System.out.println("是否停止 1？=" + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("是否停止 1？=" + Thread.interrupted());
        System.out.println("是否停止 2？=" + Thread.interrupted());
        System.out.println("是否停止 2？=" + Thread.interrupted());
        System.out.println("是否停止 2？=" + Thread.interrupted());
        System.out.println("是否停止 2？=" + Thread.interrupted());
        System.out.println("是否停止 2？=" + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("end!");
    }
}
