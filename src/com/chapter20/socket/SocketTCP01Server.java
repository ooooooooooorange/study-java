package com.chapter20.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: 服务端-字节流
 * @Author: xuzixin9
 * @Date: 2023/7/13 17:23
 */
//服务端:监听，接收连接的请求（需给出监听端口）
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //1.在本机的9999端口监听，获取ServerSocket对象，等待连接（若该端口，已被占用会报错）
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.等待连接，该方法会阻塞，直到有客户端连接，程序继续
        // 每建立一个新连接，获取ServerSocket对象会返回一个新的Socket对象
        Socket socket = serverSocket.accept();
        System.out.println("有客户端连接");
        //3.通过Socket对象获取输入流，从数据通道中读取数据
        System.out.print("接收客户端发送的消息：");
        InputStream input = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = -1;
        while((readLen = input.read(buf))!=-1){
            System.out.println(new String(buf,0,readLen));
        }
        //4.通过Socket对象获取输出流，写入数据到数据通道中
        // 最好设置结束标记，避免因为不知道是否结束一直等待而造成死锁
        OutputStream output = socket.getOutputStream();
        output.write("hello client".getBytes());
        socket.shutdownOutput();
        //5.关闭流和Socket对象
        input.close();
        output.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器已退出");
    }
}
