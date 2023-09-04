package com.chapter19;

import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/1 21:13
 */
public class File02 {
    public static void main(String[] args) throws IOException {
        File file = new File("e:\\a\\b\\c");
        System.out.println(file.mkdirs());
//        File file1 = new File("e:\\a\\a.txt");
//        file1.createNewFile();
    }
}
