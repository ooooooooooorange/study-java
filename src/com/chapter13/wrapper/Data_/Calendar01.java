package com.chapter13.wrapper.Data_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/1 0:04
 */
public class Calendar01 {
    public static void main(String[] args) {
//1.获取日历类对象，默认是当前日期
        Calendar calendar = Calendar.getInstance();

//2.获取日历的某个字段
        System.out.println(calendar.get(Calendar.YEAR));//年
        System.out.println(calendar.get(Calendar.MONTH) + 1);//月,从0开始，所以要+1
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//日
        System.out.println(calendar.get(Calendar.HOUR));//12时
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//24时
        System.out.println(calendar.get(Calendar.MINUTE));//分
        System.out.println(calendar.get(Calendar.SECOND));//秒

    }
}
