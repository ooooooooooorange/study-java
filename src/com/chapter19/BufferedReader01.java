package com.chapter19;

import java.io.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/6 22:06
 */
public class BufferedReader01 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("src//com//chapter19//FireReader01.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src//com//chapter19//BufferedWriter01.txt", false))){
            String line = null;
            while((line = reader.readLine()) != null){//按行读取
                System.out.println(line);
                writer.write(line);//按行写入
                writer.newLine();//换行
                writer.flush();//刷新
            }
        }
    }
}
