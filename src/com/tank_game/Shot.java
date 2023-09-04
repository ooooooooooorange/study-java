package com.tank_game;

/**
 * @Description: 射击子弹
 * @Author: xuzixin9
 * @Date: 2023/6/12 23:32
 */
public class Shot implements Runnable{
    private int x;//子弹的x坐标
    private int y;//子弹的y坐标
    private int direct;//子弹的方向
    private int speed = 1;//子弹的速度
    private boolean isLive = true;//子弹是否存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direct){
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            //System.out.println("子弹坐标：x="+x+",y="+y);
            //子弹何时死亡

            if(x < 0 || x > 1000 || y < 0 || y > 750 || !isLive){
                isLive = false;
                break;
            }
        }
    }
}
