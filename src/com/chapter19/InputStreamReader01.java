package com.chapter19;

import java.io.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/9 22:04
 */
public class InputStreamReader01 {
    public static void main(String[] args) throws Exception {
        try(BufferedInputStream input = new BufferedInputStream(new FileInputStream("src//com//chapter19//InputStreamReader01.txt"))){
            char[] buffer = new char[1024];
            Reader reader = new InputStreamReader(input, "GBK");

            int len = 0;
//            byte[] buffer = new byte[1024];
            while((len = reader.read(buffer)) != -1){
                System.out.println(new String(buffer, 0, len));
            }
        }
    }
}
