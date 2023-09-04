package com.chapter19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/4 11:08
 */
public class FileInputStream01 {
    public static void main(String[] args) throws IOException{
// 创建一个FileInputStream对象:
        InputStream input = null;
        try {
            input = new FileInputStream("E:\\workspace\\studyJava\\src\\com\\chapter19\\FileInputStream01.txt");
            int n;
            while ((n = input.read()) != -1) { //反复调用read()方法，直到返回-1
                System.out.print((char)n);// 打印byte的值
            }
        } finally {
            if (input != null) { input.close(); }// 关闭流
        }
    }

    public static void readFile() throws IOException {
        // 创建一个FileInputStream对象:
        InputStream input = null;
        try {
            input = new FileInputStream("E:\\workspace\\studyJava\\src\\com\\chapter19\\FileInputStream01.text");
            int n;
            while ((n = input.read()) != -1) { //反复调用read()方法，直到返回-1
                System.out.println(n);// 打印byte的值
            }
        } finally {
            if (input != null) { input.close(); }// 关闭流
        }
    }

    public static void readFile1() throws IOException {
        try (InputStream input = new FileInputStream("E:\\workspace\\studyJava\\src\\com\\chapter19\\FileInputStream01.text")){
            int n;
            while ((n = input.read()) != -1) { //反复调用read()方法，直到返回-1
                System.out.print((char)n);// 打印byte的值
            }
        }
    }
}
