package com.chapter19;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Properties;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/9 23:02
 */
public class Properties01 {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(Properties01.class.getResourceAsStream("/mysql.properties"));
        properties.list(System.out);//将配置信息通过标准打印流输出到显示器
        properties.setProperty("user","orange");//新增或修改配置信息
        System.out.println(properties.getProperty("user"));//获取配置信息
        String ip = properties.getProperty("ip");
        System.out.println(ip);
        int pwd = properties.getProperty("pwd") == null ? 0 : Integer.parseInt(properties.getProperty("pwd"));
        System.out.println(pwd);
        properties.store(new FileOutputStream("src\\mysql.properties"),null);//将配置信息写入到文件中
    }
}
