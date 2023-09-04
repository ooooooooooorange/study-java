package com.chapter17;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/12 23:05
 */
public class Homework03 {
    public static void main(String[] args) {
        User user1 = new User("张三");
        User user2 = new User("李四");
        user1.start();
        user2.start();
    }
}

class Bank {
    private int count = 10000;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class User extends Thread {
    private static Bank bank = new Bank();
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bank) {
                if (bank.getCount() <= 0) {
                    System.out.println("余额不足，" + name + "取款失败");
                    break;
                }
                bank.setCount(bank.getCount() - 1000);
                System.out.println(name + "取了1000元，还剩" + bank.getCount() + "元");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
