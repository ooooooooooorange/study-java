package com.chapter20.udp;

import java.io.IOException;
import java.net.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/13 23:37
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象，准备在9998端口接收数据
        DatagramSocket socket = new DatagramSocket(9998);
        //2.装包：构造要发送的数据(数据包最大64K，即64*1024)，并封装进DatagramPacket对象
        byte[] data = "hello".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        //3.发送数据
        socket.send(packet);

        //4.接收数据,将网络传输的数据包填充到packet对象中
        // 该方法会阻塞，直到接收到数据包
        socket.receive(packet);
        //5.拆包：从packet中取出数据并显示
        int len = packet.getLength();//实际接收到的数据的字节长度
        System.out.println(new String(packet.getData(), 0, len));//获取数据

        //6.关闭资源
        socket.close();
    }
}
