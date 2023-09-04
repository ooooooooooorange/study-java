package com.chapter23.chapter24;

import java.sql.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/20 23:46
 */
public class JavaMysql {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/study?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&tinyInt1isBit=false&&useSSL=false&autoReconnect=true&allowMultiQueries=true";
        String user = "root";
        String password = "password";
        String sql = "creatr table test(id int)";
        Connection conn = null;
        Statement statement = null;
        // 原生执行ddl
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, user, password);//获取mysql连接
            statement = conn.prepareStatement(sql);
            //statement.executeUpdate("create table test(id int)");
            statement.executeUpdate("insert into test values(1)");
            System.out.println("创建成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
