package com.chapter20.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Description:客户端-字符流
 * @Author: xuzixin9
 * @Date: 2023/7/13 17:28
 */
//客户端：发起连接的申请（需给出要连接的IP（InetAddress对象）和接口）
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //1.创建Socket对象，指定要连接的服务器（InetAddress对象和接口）
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //2.连接服务器，该方法会阻塞，直到连接建立；连接建立后程序继续
        System.out.println("客户端连接建立，远程主机地址：" + socket.getRemoteSocketAddress());
        //3.通过Socket对象获取输出流，写入数据到数据通道中
        // 最好设置结束标记，避免因为不知道是否结束一直等待而造成死锁
        OutputStream output = socket.getOutputStream();
        output.write("hello server-字节流".getBytes());
        socket.shutdownOutput();
        //4.通过Socket对象获取输入流，从数据通道中读取数据
        System.out.print("获取服务器发送的消息：");
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(input));
        String line = null;
        while((line = reader.readLine()) != null){//需要用`reader.readLine()`才能读取到结束标记
            System.out.println(line);
        }
        //5.关闭流和Socket对象
        output.close();
        reader.close();
        socket.close();
        System.out.println("客户端已退出");
    }
}
