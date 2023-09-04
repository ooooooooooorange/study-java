package com.chapter19;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/30 22:45
 */
public class File01 {
    public static void main(String[] args) throws IOException {
//        File f = new File("..");
//        System.out.println(f.getPath());
//        System.out.println(f.getAbsolutePath());
//        System.out.println(f.getCanonicalPath());

//        File f = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
//        f.deleteOnExit(); // JVM退出时自动删除
//        System.out.println(f.isFile());// true
//        System.out.println(f.getAbsolutePath());// C:\Users\xuzixin9\AppData\Local\Temp\tmp-8161618175957506943.txt


        File f = new File("C:\\Windows");
        File[] fs1 = f.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
        File[] fs2 = f.listFiles(new FilenameFilter() { // 仅列出.exe文件
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe"); // 返回true表示接受该文件
            }
        });
        printFiles(fs2);
    }

    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }

}
