package com.tank_game;

import java.util.List;
import java.util.Vector;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/10 18:02
 */
public class Hero extends Tank{
    public List<Shot> shots = new Vector<>();
    private int maxShotNum = 10;//最多能发射的子弹数
    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotBullet(){
        if(shots.size() >= maxShotNum){
            return;
        }
        switch (getDirect()){
            case 0:
                shots.add(new Shot(getX()+20,getY(),getDirect()));
                break;
            case 1:
                shots.add(new Shot(getX()+60,getY()+20,getDirect()));
                break;
            case 2:
                shots.add(new Shot(getX()+20,getY()+60,getDirect()));
                break;
            case 3:
                shots.add(new Shot(getX(),getY()+20,getDirect()));
                break;
        }
        Thread t = new Thread(shots.get(shots.size()-1));
        t.start();
    }
}
