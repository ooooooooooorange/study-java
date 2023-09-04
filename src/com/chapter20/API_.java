package com.chapter20;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/7/12 20:09
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//ZB-PF4CZCRT/10.253.5.5

        //根据指定的主机名获取InetAddress对象
        InetAddress host1 = InetAddress.getByName("ZB-PF4CZCRT");
        System.out.println(host1);//ZB-PF4CZCRT/10.253.5.5

        //根据域名获取InetAddress对象
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);//www.baidu.com/220.181.38.149

        //通过InetAddress对象获取主机名和IP地址
        System.out.println(localHost.getHostName());//ZB-PF4CZCRT
        System.out.println(localHost.getHostAddress());//10.253.5.5
    }
}
