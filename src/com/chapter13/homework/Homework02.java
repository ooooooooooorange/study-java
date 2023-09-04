package com.chapter13.homework;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/1 1:26
 */
public class Homework02 {
    public static void main(String[] args) {
        try {
            System.out.println(userRegister(null, "123456", "123@d.com"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Boolean userRegister(String userName, String pwd, String email){
        if(!(userName != null && userName.length() >= 2 && userName.length() <= 4)){
            throw new RuntimeException("用户名长度错误");
        }
        if(!(pwd != null && pwd.length() == 6 && isDigital(pwd))){
            throw new RuntimeException("密码格式错误");
        }
        int index1 = email.indexOf('@');
        int index2 = email.indexOf('.');
        if(!(email != null && index1 >= 0 && index1 < index2)) {
            throw new RuntimeException("邮箱格式错误");
        }
        return true;
    }

    public static Boolean isDigital(String str){
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
