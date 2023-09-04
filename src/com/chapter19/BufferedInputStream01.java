package com.chapter19;

import java.io.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/6 23:05
 */
public class BufferedInputStream01 {
    public static void main(String[] args) throws IOException {
        try(BufferedInputStream input = new BufferedInputStream(new FileInputStream("src//com//chapter19//img.jpg"));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("src//com//chapter19//BufferedOutputStream01.jpg", false))){
            int len = 0;
            byte[] buffer = new byte[1024];
            while((len = input.read(buffer)) != -1){//一次读1KB
                output.write(buffer, 0, len);//将缓存写入
            }
        }
    }
}
