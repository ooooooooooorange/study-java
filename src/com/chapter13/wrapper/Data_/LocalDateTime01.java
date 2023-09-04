package com.chapter13.wrapper.Data_;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/1 0:28
 */
public class LocalDateTime01 {
    public static void main(String[] args) {
        //1.获取日期对象，默认是当前日期/时间
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();

        //2.获取某个字段
        System.out.println(ldt.getYear());//年
        System.out.println(ldt.getMonth());//月:英文String
        System.out.println(ldt.getMonthValue());//月:
        System.out.println(ldt.getDayOfMonth());//日
        System.out.println(ldt.getHour());//24时
        System.out.println(ldt.getMinute());//分
        System.out.println(ldt.getSecond());//秒

        //3.格式化日期类
        //3.1 设置日期格式
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //3.2 日期类 转 String
        String s = dtf.format(ldt);
        System.out.println(s);
        //3.3 String 转 日期类
        LocalDateTime ldt1 = LocalDateTime.parse(s, dtf);
        System.out.println(ldt1);

        //4.Date类 和 第三代日期类的兼容
        //4.1 获取当前时间戳对象
        Instant instant = Instant.now();
        System.out.println(instant);
        //4.2 Instant 转 Date
        Date date = Date.from(instant);
        //4.3 Date 转 Instant
        Instant instant1 = date.toInstant();

        //5.对日期类做运算
        ldt.plusDays(999);//+999天
        ldt.minusMinutes(100);//-100分钟
    }
}
