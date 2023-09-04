package com.chapter13.homework;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/1 1:06
 */
public class Homework01 {
    public static void main(String[] args) {
        try {
            System.out.println(reverse("abcdef", 1, 100 ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String reverse(String str, int start, int end) {
        if (str == null || start < 0 || start > end || end > str.length() - 1  ) {
            throw new RuntimeException("参数不正确");
        }
//        StringBuilder sb = new StringBuilder(str);
//        for(int i = start, j = end;  i < j; i++, j--) {
//            sb.setCharAt(i, str.charAt(j));
//            sb.setCharAt(j, str.charAt(i));
//        }
//        return sb.toString();

        char[] chars = str.toCharArray();
        char temp;
        for(int i = start, j = end;  i < j; i++, j--) {
            temp = str.charAt(i);
            chars[i] = str.charAt(j);
            chars[j] = temp;
        }
        return new String(chars);
    }
}
