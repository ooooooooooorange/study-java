package com.chapter18.waitNotify;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description: 4.异步结束
 * @Author: xuzixin9
 * @Date: 2023/6/16 17:05
 */
public class AsynchronousEnd {
    public static void main(String[] args) {
        MyExecutor executor = new MyExecutor();//线程管理者
        Callable<Integer> subTask = new Callable<Integer>() {//创建子任务
            @Override
            public Integer call() throws Exception {//执行异步任务
                int millis = (int) (Math.random() * 1000);
                Thread.sleep(millis);
                return millis;
            }
        };
        MyFuture<Integer> future = executor.execute(subTask);//异步调用，返回Future对象
        try {//获取子任务结果
            Integer result = future.get();
            System.out.println(result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
interface MyFuture <V> {
    //返回真正的结果：
    // 如果结果还没有计算完成,会阻塞直到计算完成；
    // 如果调用过程发生异常，则抛出调用过程中的异常
    V get() throws Exception ;
}

class MyExecutor<V> extends Thread {//
    private V result = null;//异步计算结果
    private Exception exception = null;//异步计算过程中发生的异常
    private boolean done = false;//是否计算完成
    private Callable<V> task;//异步计算任务
    private Object lock;//保证线程安全的锁
    public MyExecutor() {
    }
    public MyExecutor(Callable<V> task, Object lock) {
        this.task = task;
        this.lock = lock;
    }
    @Override
    public void run() {
        try {
            result = task.call();//执行异步任务
        } catch (Exception e) {
            exception = e;
        } finally {
            synchronized (lock) {
                done = true;
                lock.notifyAll();
            }
        }
    }
    public V getResult() {
        return result;
    }
    public boolean isDone() {
        return done;
    }
    public Exception getException() {
        return exception;
    }

    //执行子任务并返回异步结果
    public <V> MyFuture<V> execute(final Callable<V> task) {
        final Object lock = new Object();
        final MyExecutor<V> thread = new MyExecutor<>(task, lock);
        thread.start();//启动线程
        MyFuture<V> future = new MyFuture<V>() {
            @Override
            public V get() throws Exception {//返回真正的结果
                synchronized (lock) {
                    while(!thread.isDone()) {//如果任务还没有执行完毕
                        try {
                            lock.wait();//会阻塞直到计算完成
                        } catch (InterruptedException e) {
                        }
                    }
                    if(thread.getException() != null) {//如果调用过程发生异常
                        throw thread.getException();//抛出调用过程中的异常
                    }
                    return thread.getResult();//返回执行结果
                }
            }
        };
        return future;
    }
}