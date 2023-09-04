package com.chapter19;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/4 16:46
 */
public class FileOutputStream01 {
    public static void main(String[] args) {
        try (OutputStream output = new FileOutputStream("E:\\workspace\\studyJava\\src\\com\\chapter19\\FileOutputStream01.txt")){
            output.write("hello world".getBytes());
            output.write("测试追加".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
