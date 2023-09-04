package com.hutool;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/25 13:27
 */
public class TestHuTool {
    //功能：将一个对象转换成Map<String, Object>，属性名为key，值为value，只支持实例变量。
    //参数解释：bean待转对象，isToUnderlineCase是否转下划线，ignoreNullValue是否忽略空值。
    //返回值：返回转换后的Map对象。
    @Test
    public void m1(){
        User user = new User(1001,"张三",0,null,8000.0,new Dog("旺财"));

        Map<String, Object> map1 = BeanUtil.beanToMap(user, false, false); // 不转下划线，不忽略空值
        Map<String, Object> map2 = BeanUtil.beanToMap(user, true, true); // 转下划线，忽略空值

        System.out.println(map1); // {id=1001, userName=张三, gender=0, birth=null, salary=8000.0, dog=Dog(name=旺财)}
        System.out.println(map2); // {id=1001, user_name=张三, gender=0, salary=8000.0, dog=Dog(name=旺财)}

        map2.put("测试多余的key", "多余的");
        map2.put("id", "222");
        User user1 = BeanUtil.mapToBean(map2, User.class, true); // 转下划线
        System.out.println(user1);
        User user2 = new User();
        BeanUtil.fillBeanWithMap(map2, user2, true, false); // 不转下划线
        System.out.println(user2);
    }

    //功能：复制属性，类似克隆，但比clone()方法更强大。
    //参数解释：source待克隆对象，tClass克隆后返回对象类型，ignoreProperties哪些属性忽略不克隆。
    //返回值：复制属性完成后，返回复制后的对象。
    @Test
    public void m2() {
        User user = new User(1001,"张三",1,DateUtil.parse("1997-12-08"), 8000.0,new Dog("旺财"));
        Employee employee = null;

        employee = BeanUtil.copyProperties(user, Employee.class, "id"); // 将user对象，克隆成Employee类型返回，忽略属性id
        System.out.println(employee); // Employee(id=null, employeeName=null, gender=1, birth=1997-12-08 00:00:00, salary=8000, dog=Dog(name=旺财))
        //解释：
        //id为空，是因为克隆时，指定忽略的属性，克隆后肯定没值。
        //employeeName为空，是因为User对象中属性名叫userName，Employee对象属性名叫employeeName，属性名不一致。
        //salary却有值，这是因为只要属性名称相同，会强制转换。如果把Employee中的salary换成Boolean类型，还会强制转成true呢。
        //Employee中的静态变量a没显示，看来也是针对实例变量才会复制值。
    }

    //功能：判断指定对象是否含有null值的属性，也可忽略某些属性名。
    //bean待判断的对象，ignoreFiledNames忽略的属性名。
    //返回值：布尔值。
    @Test
    public void m3() {
        User user = new User(1001,"张三",1,null, 8000.0,new Dog("旺财"));

        System.out.println(BeanUtil.hasNullField(user));  // true
        System.out.println(BeanUtil.hasNullField(user, "birth"));  // false
    }

    //功能：判断对象是否为空，为空表示对象本身为null，或者属性都是null。
    //bean待判断的对象，ignoreFiledNames忽略的属性名。
    //返回值：布尔值。
    //结论：BeanUtil的这个方法只适合判断pojo对象，不要用BeanUtil.isisEmpty()或者isNotEmpty()判断字符串是否为空。
    //     判断字符串是否为空，请用StrUtil。
    @Test
    public void m4() {
        User user1 = new User(1001, "张三", 0, null, 8000.0, new Dog("旺财"));
        User user2 = new User();
        User user3 = null;

        String str1 = "abc";
        String str2 = "";

        System.out.println(BeanUtil.isEmpty(user1));    // false
        System.out.println(BeanUtil.isEmpty(user2));    // true
        System.out.println(BeanUtil.isEmpty(user3));    // true
        System.out.println(BeanUtil.isNotEmpty(str1));  // true
        System.out.println(BeanUtil.isNotEmpty(str2));  // true，str2的值为"", 不是null
        System.out.println(StrUtil.isEmpty(str2));      // true
    }

    //功能：把Bean里面的String属性做trim操作(去掉首尾空格)，此方法直接对传入的Bean做修改，会影响原对象。静态字段不处理，也可指定忽略属性。
    //bean待判断的对象，ignoreFiledNames忽略的属性名。
    //返回值：返回处理后的对象。
    @Test
    public void m5() {
        User user = new User(1001,"  张三   ",0,null,8000.0,new Dog("  旺财    "));
        User newUser = BeanUtil.trimStrFields(user);

        System.out.println(user);    // User(id=1001, userName=张三, gender=0, birth=null, salary=8000.0, dog=Dog(name=  旺财    ))
        System.out.println(newUser); // User(id=1001, userName=张三, gender=0, birth=null, salary=8000.0, dog=Dog(name=  旺财    ))
        // User中的Dog不属于String类型，故属性Dog类中的name跟操作无关。
    }


}



@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
class User {
    public static int a = 2020;
    private Integer id;
    private String userName;    // 变量名为 userName
    private Integer gender;     // 0女，1男
    private Date birth;
    private Double salary;      // 设置为 Double 类型
    private Dog dog;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
class Employee {
    public static Integer a;
    private Integer id;
    private String employeeName;    // 变量名为 employeeName
    private Integer gender;
    private Date birth;
    private Integer salary;         // 设置为 Integer 类型
    private Dog dog;
}


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
class Dog {
    private String name;
}