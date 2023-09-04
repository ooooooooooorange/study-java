package com.chapter18.waitNotify;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description: 1.生产者消费者
 * @Author: xuzixin9
 * @Date: 2023/6/16 16:28
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        TaskQueue<String> queue = new TaskQueue<>(10);
        new Producer(queue).start();
        new Consumer(queue).start();
    }
}

class TaskQueue<E> {
    private Queue<E> queue = null;//任务队列
    private int limit;//数量上限
    public TaskQueue(int limit) {
        this.limit = limit;
        queue = new ArrayDeque<>(limit);
    }

    public synchronized void put(E e) throws InterruptedException {//生产者
        while(queue.size() == limit) {//条件不成立
            wait();// 释放this锁
            // 被消费者唤醒，若重新获取到this锁，wait()返回
        }//再次判断条件
        //执行条件满足后的操作
        queue.add(e);
        notifyAll();// 唤醒消费者
    }
    public synchronized E take() throws InterruptedException {//消费者
        while(queue.isEmpty()) {//条件不成立
            wait();// 释放this锁
            // 被生产者唤醒，若重新获取到this锁，wait()返回
        }//再次判断条件
        //执行条件满足后的操作
        E e = queue.poll();
        notifyAll();// 唤醒生产者
        return e;
    }
}
class Producer extends Thread {
    TaskQueue<String> queue;
    public Producer(TaskQueue<String> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        int num = 0;
        try {
            while(true) {
                String task = String.valueOf(num);
                queue.put(task);
                System.out.println("produce task " + task);
                num++;
                Thread.sleep((int) (Math.random() * 100));
            }
        } catch (InterruptedException e) {
        }
    }
}

class Consumer extends Thread {
    TaskQueue<String> queue;
    public Consumer(TaskQueue<String> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while(true) {
                String task = queue.take();
                System.out.println("handle task " + task);
                Thread.sleep((int)(Math.random()*100));
            }
        } catch(InterruptedException e) {
        }
    }
}