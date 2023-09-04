package com.tank_game;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/10 18:01
 */
public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direct;//坦克的方向：0上 1右 2下 3左
    private int speed = 1;//坦克的速度
    private boolean isLive = true;//坦克是否存活


    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
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

    public void move() {
        switch (direct) {
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
    }

    public boolean canMove(int borderX, int borderY, Vector<? extends Tank> tanks) {
        switch (direct) {
            case 0:
                if (y <= 0) {
                    return false;
                }
                if (tanks == null) {
                    break;
                }
                for (Tank tank : tanks) {
                    if (tank != this) {
                        if (x >= tank.getX() && x <= tank.getX() + 40 && y >= tank.getY() && y <= tank.getY() + 60) {
                            return false;
                        }
                    }
                }
                break;
            case 1:
                if (x + 60 >= borderX) {
                    return false;
                }
                if (tanks == null) {
                    break;
                }
                for (Tank tank : tanks) {
                    if (tank != this) {
                        if (x >= tank.getX() && x <= tank.getX() + 60 && y >= tank.getY() && y <= tank.getY() + 40) {
                            return false;
                        }
                    }
                }
                break;
            case 2:
                if (y + 60 >= borderY) {
                    return false;
                }
                if (tanks == null) {
                    break;
                }
                for (Tank tank : tanks) {
                    if (tank != this) {
                        if (x >= tank.getX() && x <= tank.getX() + 40 && y >= tank.getY() && y <= tank.getY() + 60) {
                            return false;
                        }
                    }
                }
                break;
            case 3:
                if (x <= 0) {
                    return false;
                }
                if (tanks == null) {
                    break;
                }
                for (Tank tank : tanks) {
                    if (tank != this) {
                        if (x >= tank.getX() && x <= tank.getX() + 60 && y >= tank.getY() && y <= tank.getY() + 40) {
                            return false;
                        }
                    }
                }
                break;
        }
        return true;
    }

    public boolean isTouchOtherTank(Vector<? extends Tank> tanks) {
        switch (this.getDirect()){
            case 0://上
                //遍历坦克数组
                for (int i = 0; i < tanks.size(); i++) {
                    Tank tank = tanks.get(i);
                    //比较除自己以外的别的坦克
                    if (tank != this) {
                        //如果其他坦克向上或向下
                        if (tank.getDirect()==0||tank.getDirect()==2){
                            if (this.getX() >= tank.getX()
                                    && this.getX() <= tank.getX() + 40
                                    && this.getY() >= tank.getY()
                                    && this.getY() <= tank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 40 >= tank.getX()
                                    && this.getX() + 40 <= tank.getX() + 60
                                    && this.getY() >= tank.getY()
                                    && this.getY() <= tank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果其他坦克向左或向右
                        if (tank.getDirect()==1||tank.getDirect()==3){
                            if (this.getX() >= tank.getX()
                                    && this.getX() <= tank.getX() + 60
                                    && this.getY() >= tank.getY()
                                    && this.getY() <= tank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 40 >= tank.getX()
                                    && this.getX() + 40 <= tank.getX() + 60
                                    && this.getY() >= tank.getY()
                                    && this.getY() <= tank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://右
                //遍历坦克数组
                for (int i = 0; i < tanks.size(); i++) {
                    Tank tank = tanks.get(i);
                    //比较除自己以外的别的坦克
                    if (tank != this) {
                        //如果其他坦克向上或向下
                        if (tank.getDirect()==0||tank.getDirect()==2){
                            if (this.getX() + 60 >= tank.getX()
                                    && this.getX() + 60 <= tank.getX() + 40
                                    && this.getY() >= tank.getY()
                                    && this.getY() <= tank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 60 >= tank.getX()
                                    && this.getX() + 60 <= tank.getX() + 60
                                    && this.getY() + 40 >= tank.getY()
                                    && this.getY() + 40 <= tank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果其他坦克向左或向右
                        if (tank.getDirect()==1||tank.getDirect()==3){
                            if (this.getX() + 60 >= tank.getX()
                                    && this.getX() + 60 <= tank.getX() + 60
                                    && this.getY() >= tank.getY()
                                    && this.getY() <= tank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 60 >= tank.getX()
                                    && this.getX() + 60 <= tank.getX() + 60
                                    && this.getY() + 40 >= tank.getY()
                                    && this.getY() + 40 <= tank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://下
                //遍历坦克数组
                for (int i = 0; i < tanks.size(); i++) {
                    Tank tank = tanks.get(i);
                    //比较除自己以外的别的坦克
                    if (tank != this) {
                        //如果其他坦克向上或向下
                        if (tank.getDirect()==0||tank.getDirect()==2){
                            if (this.getX() >= tank.getX()
                                    && this.getX() <= tank.getX() + 40
                                    && this.getY() + 60 >= tank.getY()
                                    && this.getY() + 60 <= tank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 40 >= tank.getX()
                                    && this.getX() + 40 <= tank.getX() + 60
                                    && this.getY() + 60 >= tank.getY()
                                    && this.getY() + 60 <= tank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果其他坦克向左或向右
                        if (tank.getDirect()==1||tank.getDirect()==3){
                            if (this.getX() >= tank.getX()
                                    && this.getX() <= tank.getX() + 60
                                    && this.getY() + 60 >= tank.getY()
                                    && this.getY() + 60 <= tank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 40 >= tank.getX()
                                    && this.getX() + 40 <= tank.getX() + 60
                                    && this.getY() + 60 >= tank.getY()
                                    && this.getY() + 60 <= tank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://左
                //遍历坦克数组
                for (int i = 0; i < tanks.size(); i++) {
                    Tank tank = tanks.get(i);
                    //比较除自己以外的别的坦克
                    if (tank != this) {
                        //如果其他坦克向上或向下
                        if (tank.getDirect()==0||tank.getDirect()==2){
                            if (this.getX() >= tank.getX()
                                    && this.getX() <= tank.getX() + 40
                                    && this.getY() >= tank.getY()
                                    && this.getY() <= tank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() >= tank.getX()
                                    && this.getX() <= tank.getX() + 60
                                    && this.getY() + 40 >= tank.getY()
                                    && this.getY() + 40 <= tank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果其他坦克向左或向右
                        if (tank.getDirect()==1||tank.getDirect()==3){
                            if (this.getX() >= tank.getX()
                                    && this.getX() <= tank.getX() + 60
                                    && this.getY() >= tank.getY()
                                    && this.getY() <= tank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() >= tank.getX()
                                    && this.getX() <= tank.getX() + 60
                                    && this.getY() + 40 >= tank.getY()
                                    && this.getY() + 40 <= tank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;

        }
        return false;
    }
}
