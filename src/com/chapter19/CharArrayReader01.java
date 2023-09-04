package com.chapter19;

import java.io.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/6 17:23
 */
public class CharArrayReader01 {
    public static void main(String[] args) throws IOException {
        char[] data = {'h', 'e', 'l', 'l', 'o'};
        Reader reader = new CharArrayReader(data);

        CharArrayWriter writer = new CharArrayWriter();
        writer.write("Hello ");
        data = writer.toCharArray();
        System.out.println(data);
   }
}
