package com.tank_game;


import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/10 18:07
 */
public class TankGame01 extends JFrame{
    private MyPanel mp = null;//面板
    private static Scanner scanner = new Scanner(System.in);
    public TankGame01 (){
        String key;
        if(!Recorder.hasRecordFile()){
            System.out.println("开始新游戏");
            key = "1";
        } else {
            System.out.println("请输入选择：1.重新开始游戏；2.继续上次游戏 ");
            key = scanner.next();
        }
        mp = new MyPanel(key);//初始化面板
        new Thread(mp).start();//启动线程
        this.add(mp);//把面板放入到窗口（画框）
        this.setSize(mp.borderX, mp.borderY);//设置窗口大小
        this.addKeyListener(mp);//放入监听器之后，窗口对象就可以监听到键盘事件
        this.setVisible(true);//设置可见性为可见
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口会同步结束程序

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Recorder.saveRecord();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("窗口关闭");
            }
        });
    }

    public static void main(String[] args) {
        new TankGame01();
        AtomicInteger atomicInteger = new AtomicInteger(0);
    }

}
