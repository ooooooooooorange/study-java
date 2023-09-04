package com.chapter18.waitNotify;

/**
 * @Description: 5.集合点
 * @Author: xuzixin9
 * @Date: 2023/6/16 16:54
 */
public class AssemblePointDemo {

    public static void main(String[] args) {
        int num = 10;
        Tourist[] threads = new Tourist[num];
        AssemblePoint ap = new AssemblePoint(num);//定义一个集合点
        for(int i = 0; i < num; i++) {
            threads[i] = new Tourist(ap);//定义10个旅行者线程，共用一个集合点
            threads[i].start();
        }
    }
}
class AssemblePoint {//集合点类
    private int n;//集合点人数
    public AssemblePoint(int n) {
        this.n = n;
    }
    public synchronized void await() throws InterruptedException {
        if(n > 0) {//如果还有人没到达
            n--;//当前旅行者到达，计数器减1
            if(n == 0) {//如果所有人都到达了
                notifyAll();//唤醒所有旅行者
            } else {
                while(n != 0) {
                    wait();//等待其他旅行者
                }
            }
        }
    }
}

class Tourist extends Thread {//旅行者类
    AssemblePoint ap;
    public Tourist(AssemblePoint ap) {
        this.ap = ap;
    }
    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000));//模拟旅行者独自旅行
            ap.await();//到集合点集合
            System.out.println("arrived");//所有人集合完毕，执行后续操作
        } catch (InterruptedException e) {
        }
    }
}