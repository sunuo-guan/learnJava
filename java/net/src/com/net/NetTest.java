package com.net;

import java.net.*;

public class NetTest {
	public static void main(String[] args) {
		
		try {
			//ip地址
			InetAddress address1 = InetAddress.getByName("192.168.1.1");
			System.out.println(address1);
			
			
			//域名
			InetAddress address2 = InetAddress.getByName("www.baidu.com");
			System.out.println(address2);
			
			//本机
			//InetAddress address3=InetAddress.getByName("127.0.0.1");
			InetAddress address3=InetAddress.getLocalHost();
			System.out.println(address3);
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
