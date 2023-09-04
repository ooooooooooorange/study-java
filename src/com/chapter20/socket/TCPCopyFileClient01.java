package com.chapter20.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Description: 客户端-复制文件
 * @Author: xuzixin9
 * @Date: 2023/7/13 21:46
 */
public class TCPCopyFileClient01 {
    public static void main(String[] args) throws IOException {
        //1.x客户端连接服务器
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //2.创建文件输入流，读取文件
        BufferedInputStream input = new BufferedInputStream(new FileInputStream("src/com/chapter20/socket/image.png"));
        //3.通过Socket对象获取输出流，写入文件到数据通道中
        BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream());
        byte[] buf = new byte[1024];
        int len = -1;
        //4.从文件输入流中读取数据，复制到通道输出流中
        while ((len = input.read(buf)) != -1) {
            output.write(buf, 0, len);
        }
        output.flush();
        socket.shutdownOutput();

        //5.收到服务器的回复，结束
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while(true){
            if("收到图片".equals(reader.readLine())) {
                System.out.println("图片发送成功");
                break;
            }
        }
        //6.关闭流和Socket对象
        reader.close();
        output.close();
        input.close();
        socket.close();
    }
}
