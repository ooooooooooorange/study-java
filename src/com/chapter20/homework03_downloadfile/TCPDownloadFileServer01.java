package com.chapter20.homework03_downloadfile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: 服务端-下载文件
 * @Author: xuzixin9
 * @Date: 2023/7/13 21:45
 */
public class TCPDownloadFileServer01 {
    public static void main(String[] args) throws IOException {
        //1.服务端监听8888端口，获取ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.等待连接
        System.out.println("服务端在9999端口监听，等待下载文件");
        Socket socket = serverSocket.accept();

        //3.通过Socket对象获取通道输入流，接收要下载的文件名
        BufferedInputStream input = new BufferedInputStream(socket.getInputStream());
        byte[] buf = new byte[1024];
        int len = -1;
        String downLoadFileName = "";
        while ((len = input.read(buf)) != -1) {//从通道中读取数据
            downLoadFileName += new String(buf, 0, len);
        }
        System.out.println("服务端接收到客户端发的下载文件名：" + downLoadFileName);

        //4.查找文件是否存在（查询不到则发送默认文件），构造文件输入流读取文件，并将数据输出到通道中
        String filePath = "src/com/chapter20/homework03_downloadfile/";
        if(!new File(filePath + downLoadFileName).exists()){
            downLoadFileName = "无名.png";
        }
        BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(filePath + downLoadFileName));
        System.out.println("服务端下载文件路径：" + filePath + downLoadFileName);

        BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream());
        while ((len = fileInput.read(buf)) != -1) {
            output.write(buf, 0, len);
        }
        output.flush();
        socket.shutdownOutput();
        System.out.println("服务端发送文件完成");

        //5.关闭流和Socket对象
        fileInput.close();
        output.close();
        input.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端关闭");
    }
}
