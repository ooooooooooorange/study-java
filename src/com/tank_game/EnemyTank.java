package com.tank_game;

import java.util.List;
import java.util.Vector;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/12 11:34
 */
public class EnemyTank extends Tank implements Runnable {
    private int shotTime = 2000;
    public List<Shot> shots = new Vector<>();
    private Vector<EnemyTank> enemyTanks = new Vector<>();
    public EnemyTank(int x, int y) {
        super(x, y);
        setDirect(2);
    }

    public int getShotTime() {
        return shotTime;
    }

    public void setShotTime(int shotTime) {
        this.shotTime = shotTime;
    }

    public List<Shot> getShots() {
        return shots;
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public void shotBullet() {
        switch (getDirect()) {
            case 0:
                shots.add(new Shot(getX() + 20, getY(), getDirect()));
                break;
            case 1:
                shots.add(new Shot(getX() + 60, getY() + 20, getDirect()));
                break;
            case 2:
                shots.add(new Shot(getX() + 20, getY() + 60, getDirect()));
                break;
            case 3:
                shots.add(new Shot(getX(), getY() + 20, getDirect()));
                break;
        }
        Thread t = new Thread(shots.get(shots.size() - 1));
        t.start();
    }

    @Override
    public void run() {
        while (isLive()) {
            Vector<Tank> tanks = new Vector<>();
            tanks.add(MyPanel.hero);
            //保持一个方向，走30步
            for (int i = 0; i < 30; i++) {
                if (this.canMove(MyPanel.borderX, MyPanel.borderY, tanks) && !this.isTouchOtherTank(enemyTanks)) {
                    move();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //随机改变坦克的方向
            setDirect((int) (Math.random() * 4));

            //若子弹消亡，则再发射一颗子弹
            if(shots.size() == 0){
                shotBullet();
            }
        }
        return;
    }
}
