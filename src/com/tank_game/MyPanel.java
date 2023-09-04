package com.tank_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/10 18:04
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    static final int borderX = 1300;//窗口的宽度
    static final int borderY = 750;//窗口的高度
    static Hero hero = null;//玩家的坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();//敌人的坦克
    int enemyTankSize;//敌人的坦克数量

    Vector<Bomb> bombs = new Vector<>();//用于存放炸弹

    //定义三张图片，用于显示爆炸效果
    static Image bombImage1 = null;
    static Image bombImage2 = null;
    static Image bombImage3 = null;

    static {
        //初始化三张爆炸图片
        bombImage1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_1.gif"));
        bombImage2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_2.gif"));
        bombImage3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_3.gif"));
    }

    public MyPanel(String key) {
        hero = new Hero(800, 100);
        hero.setSpeed(10);
        switch (key){
            case "1":
                enemyTankSize = 3;
                Recorder.setEnemyTankNum(enemyTankSize);
                for (int i = 0; i < enemyTankSize; i++) {
                    EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDirect(2);
                    enemyTank.shotBullet();
                    enemyTanks.add(enemyTank);
                    new Thread(enemyTank).start();
                }
                Recorder.setEnemyTanks(enemyTanks);
                break;
            case "2":
                Recorder.readRecord();
                enemyTankSize = Recorder.getEnemyTankNum();
                enemyTanks = Recorder.getEnemyTanks();
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    enemyTank.shotBullet();
                    new Thread(enemyTank).start();
                }
            default:
                System.out.println("输入错误");
                break;
        }
        //播放bgm
        //new AePlayWave("src\\com\\tank_game\\bgm.mp3").start();
    }

    //展示游戏信息
    public void showInfo(Graphics g){
        g.setColor(Color.BLACK);
        Font myFont = new Font("微软雅黑", Font.BOLD, 25);
        g.setFont(myFont);
        g.drawString("剩余敌方坦克数量", 1020, 30);

        //画出提示信息坦克
        this.drawTank(1020, 60, g, 0, 1);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getEnemyTankNum() + "", 1100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //设置面板的大小
        g.fillRect(0, 0, 1000, borderY);
        showInfo(g);
        //画出玩家的坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        //画出玩家的子弹
        if (hero.shots != null) {
            Iterator iterator = hero.shots.iterator();
            while (iterator.hasNext()) {
                Shot shot = (Shot) iterator.next();
                if (shot.isLive()) {
                    g.draw3DRect(shot.getX() - 1, shot.getY() - 1, 3, 3, false);
                } else {
                    iterator.remove();
                }
            }
        }
        //画出敌人的坦克
        Iterator enemyTankIterator = enemyTanks.iterator();
        while (enemyTankIterator.hasNext()) {
            EnemyTank enemyTank =  (EnemyTank)enemyTankIterator.next();
            //画出敌人的坦克
            if (enemyTank.isLive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                //画出敌人的子弹
                if (enemyTank.shots != null) {
                    Iterator iterator = enemyTank.shots.iterator();
                    while (iterator.hasNext()) {
                        Shot shot = (Shot) iterator.next();
                        if (shot.isLive()) {
                            g.draw3DRect(shot.getX() - 1, shot.getY() - 1, 3, 3, false);
                        } else {
                            iterator.remove();
                        }
                    }
                }
            } else {
                Recorder.reduceEnemyTankNum();
                enemyTankIterator.remove();
            }
        }
        //画出炸弹
        Iterator bombIterator = bombs.iterator();
        while (bombIterator.hasNext()) {
            Bomb bomb =  (Bomb)bombIterator.next();
            if (bomb.isLive()) {
                drawBomb(bomb, g);
            } else {
                bombIterator.remove();
            }
        }
    }

    private void drawBomb(Bomb bomb, Graphics g) {
        if (bomb.getLife() > 6) {
            g.drawImage(bombImage1, bomb.getX(), bomb.getY(), 60, 60, this);
        } else if (bomb.getLife() > 3) {
            g.drawImage(bombImage2, bomb.getX(), bomb.getY(), 60, 60, this);
        } else {
            g.drawImage(bombImage3, bomb.getX(), bomb.getY(), 60, 60, this);
        }
        bomb.lifeDown();
        if (bomb.getLife() == 0) {
            bomb.setLive(false);
        }
    }

    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上侧坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0://我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，来绘制坦克
        switch (direct) {
            case 0://表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1://表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2://表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3://表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    //判断子弹是否击中坦克
    public boolean hitTank(Shot shot, Tank tank) {
        switch (tank.getDirect()) {
            case 0://坦克向上
            case 2://坦克向下
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 40
                        && shot.getY() > tank.getY() && shot.getY() < tank.getY() + 60) {
                    shot.setLive(false);
                    tank.setLive(false);
                    //创建一颗炸弹对象，并加入到bombs
                    bombs.add(new Bomb(tank.getX(), tank.getY()));
                    return true;
                }
                break;
            case 1://坦克向右
            case 3://坦克向左
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 60
                        && shot.getY() > tank.getY() && shot.getY() < tank.getY() + 40) {
                    shot.setLive(false);
                    tank.setLive(false);
                    //创建一颗炸弹对象，并加入到bombs
                    bombs.add(new Bomb(tank.getX(), tank.getY()));
                    return true;
                }
                break;
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!hero.isLive()) {//如果我方坦克死亡，就不处理键盘事件
            return;
        }
        if (! hero.canMove(borderX, borderY, enemyTanks)) {//不能移动
            return;
        }

        if (e.getKeyChar() == KeyEvent.VK_W) {//按下w键
            hero.setDirect(0);//改变坦克方向
            hero.move();//移动坦克
        } else if (e.getKeyChar() == KeyEvent.VK_D) {//按下d键
            hero.setDirect(1);//改变坦克方向
            hero.move();//移动坦克
        } else if (e.getKeyChar() == KeyEvent.VK_S) {//按下s键
            hero.setDirect(2);//改变坦克方向
            hero.move();//移动坦克
        } else if (e.getKeyChar() == KeyEvent.VK_A) {//按下a键
            hero.setDirect(3);//改变坦克方向
            hero.move();//移动坦克
        }

        if (e.getKeyChar() == KeyEvent.VK_J) {//如果用户按下J键，就发射子弹
            hero.shotBullet();
        }
        System.out.println((char) e.getKeyChar() + "键被按下");
        this.repaint();//重绘
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);//每隔100毫秒重绘
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //遍历子弹看是否击中敌人坦克
            for (Shot shot : hero.shots) {
                for (EnemyTank enemyTank : enemyTanks) {
                    if(shot.isLive() && enemyTank.isLive()){
                        hitTank(shot, enemyTank);
                    }
                }
            }
            if(enemyTanks.size()==0){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("游戏胜利！");
                return;
            }
            //遍历敌人坦克看是否击中英雄坦克
            for (EnemyTank enemyTank : enemyTanks) {
                for (Shot shot : enemyTank.shots) {
                    if(shot.isLive() && hero.isLive()){
                        hitTank(shot, hero);
                    }
                }
            }
            if(!hero.isLive()){
                System.out.println("游戏失败！");
            }
            this.repaint();
        }
    }
}
