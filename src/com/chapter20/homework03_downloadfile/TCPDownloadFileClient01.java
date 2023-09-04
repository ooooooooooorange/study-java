package com.chapter20.homework03_downloadfile;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description: 客户端-下载文件
 * @Author: xuzixin9
 * @Date: 2023/7/13 21:46
 */
public class TCPDownloadFileClient01 {
    public static void main(String[] args) throws IOException {
        //1.x客户端连接服务器
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //2.从键盘获取文件名
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要下载的文件名(带后缀)：");
        String downLoadFileName = scanner.nextLine();

        //3.通过Socket对象获取输出流，写入文件名到数据通道中
        BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream());
        output.write(downLoadFileName.getBytes());
        output.flush();
        socket.shutdownOutput();
        //4.构造输入流接收通道返回的文件数据，并构造输出流存储文件信息到磁盘
        BufferedInputStream input = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream fileOutput = new BufferedOutputStream(new FileOutputStream("src/com/chapter20/homework03_downloadfile/" + "downLoadFile.png"));
        byte[] buf = new byte[1024];
        int len = -1;
        //5.从通道中读取数据，拷贝进文件输出流
        while ((len = input.read(buf)) != -1) {
            fileOutput.write(buf, 0, len);
        }
        //6.关闭流和Socket对象
        fileOutput.close();
        input.close();
        output.close();
        socket.close();
    }
}
