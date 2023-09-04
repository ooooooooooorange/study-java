package com.chapter16.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/10 16:55
 */
import javax.swing.*;
import java.awt.*;

/**
 * java绘制简单圆形
 * 继承JFrame框架
 */
//面板类，其对象是一个画板
public class DrawCircle extends JFrame {
    private MyPanel mp = null;//面板
    public DrawCircle(){
        mp = new MyPanel();//初始化面板
        this.add(mp);//把面板放入到窗口（画框）
        this.setSize(400, 300);//设置窗口大小
        this.setVisible(true);//设置可见性为可见
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口会同步结束程序
    }
    public static void main(String[] args) {
        new DrawCircle();
    }
}

/**
 * 定义一个画板
 * JPanel是java提供的一个绘图类
 */
//面板类，其对象是一个画板
class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("paint方法被调用了");
//        g.drawOval(10, 10, 100, 100);
        //获取图片资源，从项目的根目录开始查找获取
        Image image = Toolkit.getDefaultToolkit().getImage("/img.png");
        g.drawImage(image, 10, 10,200, 200, this);

//        g.setFont(new Font("隶书", Font.BOLD, 50));//设置画笔字体、粗细、字号
//        g.drawString("学习",100,100);//写字
    }
}