package com.tank_game;

import java.io.*;
import java.util.Vector;

/**
 * @Description:记录类：记录游戏信和文件读写操作
 * @Author: xuzixin9
 * @Date: 2023/7/10 12:50
 */
public class Recorder {
    private static int enemyTankNum;

    private static String recordFile = "src\\com\\tank_game\\myrecord.txt";

    private static Vector<EnemyTank> enemyTanks = new Vector<>();

    public static int getEnemyTankNum() {
        return enemyTankNum;
    }

    public static void setEnemyTankNum(int enemyTankNum) {
        Recorder.enemyTankNum = enemyTankNum;
    }

    public static void reduceEnemyTankNum(){
        Recorder.enemyTankNum--;
    }

    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static void saveRecord() throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(recordFile))){
            //写入敌方坦克数量
            bw.write(enemyTankNum+"");
            bw.newLine();

            //写入敌方坦克信息
            for(int i = 0; i < enemyTanks.size(); i++){
                EnemyTank enemyTank = enemyTanks.get(i);
                if(enemyTank.isLive()){
                    bw.write(enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect());
                    bw.newLine();
                }
            }
        }
    }

    public static void readRecord(){
        try(BufferedReader br = new BufferedReader(new FileReader(recordFile))){
            //读取敌方坦克数量
            enemyTankNum = Integer.parseInt(br.readLine());

            //读取敌方坦克信息
            for(int i = 0; i < enemyTankNum; i++){
                String[] tankInfo = br.readLine().split(" ");
                EnemyTank enemyTank = new EnemyTank(Integer.parseInt(tankInfo[0]),Integer.parseInt(tankInfo[1]));
                enemyTank.setDirect(Integer.parseInt(tankInfo[2]));
                enemyTanks.add(enemyTank);
                Thread t = new Thread(enemyTank);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean hasRecordFile(){
        return new File(recordFile).exists();
    }

}
