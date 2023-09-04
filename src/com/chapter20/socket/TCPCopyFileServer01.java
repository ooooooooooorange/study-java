package com.chapter20.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: 服务端-复制文件
 * @Author: xuzixin9
 * @Date: 2023/7/13 21:45
 */
public class TCPCopyFileServer01 {
    public static void main(String[] args) throws IOException {
        //1.服务端监听8888端口，获取ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.等待连接
        Socket socket = serverSocket.accept();

        //3.新建文件，并构造文件输出流
        File file = new File("src/com/chapter20/socket/image_copy.png");
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file));
        //4.通过Socket对象获取通道输入流
        BufferedInputStream input = new BufferedInputStream(socket.getInputStream());
        byte[] buf = new byte[1024];
        int len = -1;
        //5.从通道中读取数据，拷贝进文件输出流
        while ((len = input.read(buf)) != -1) {
            output.write(buf, 0, len);
        }
        //6.通知客户端已接收图片文件
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.newLine();
        writer.flush();

        //7.关闭流和Socket对象
        writer.close();
        input.close();
        output.close();
        socket.close();
        serverSocket.close();

    }
}
