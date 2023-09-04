package com.chapter19;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/6 16:18
 */
public class FireReader01 {
    public static void main(String[] args) throws IOException {
        //单个字符读取
        try(Reader reader = new FileReader("src\\com\\chapter19\\FireReader01.txt")){
            Long t = System.currentTimeMillis();
            int data = ' ';
            while ((data = reader.read()) != -1){
                //System.out.print((char)data);
            }
            System.out.println(System.currentTimeMillis() - t);
        }

        //字符数组读取
        try(Reader reader = new FileReader("src\\com\\chapter19\\FireReader01.txt")) {
            Long t = System.currentTimeMillis();
            char[] charsData = new char[1024];
            int len = 0;
            while ((len = reader.read(charsData)) != -1) {
                //System.out.print(new String(charsData, 0, len));
            }
            System.out.println(System.currentTimeMillis() - t);
        }
    }
}
