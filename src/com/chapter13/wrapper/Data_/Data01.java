package com.chapter13.wrapper.Data_;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/5/31 23:20
 */
public class Data01 {
    public static void main(String[] args) throws ParseException {
//1.1获取当前系统时间
        Date date1 = new Date();
//1.2通过长整型的毫秒数获取时间
        Date date2 = new Date(123445555);

//2.设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//3.1 Date转String
        String s = sdf.format(date1);
        System.out.println(s);
//3.2 Date转String
        Date date3 = sdf.parse(s);

    }
}
