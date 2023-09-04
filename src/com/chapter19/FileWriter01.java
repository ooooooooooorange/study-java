package com.chapter19;

import java.io.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/6 16:46
 */
public class FileWriter01 {
    public static void main(String[] args) throws IOException {
        try (Writer writer = new FileWriter("src\\com\\chapter19\\FileWriter01.txt",true)){
            writer.write("风雨之后");
            writer.write("，");
            writer.write("定见彩虹");
        }
    }
}
