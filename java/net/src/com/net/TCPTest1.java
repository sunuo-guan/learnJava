package com.net;

import java.io.*;
import java.net.*;

import org.junit.jupiter.api.Test;

public class TCPTest1 {
	public static void main(String[] args) {
		server();
		client();
	}
	
	//�ͻ���
	@Test
	public static void client() {
		Socket socket=null;
		
		OutputStream os=null;
		try {
			InetAddress inet = InetAddress.getByName("127.0.0.1");
			socket = new Socket(inet, 9989);
			os = socket.getOutputStream();
			os.write("��ã����ǿͻ���".getBytes());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket!=null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	//�����
	@Test
	public static void server() {
		
		ServerSocket ss=null;
		Socket socket=null;
		InputStream is=null;
		ByteArrayOutputStream bos=null;
		
		try {
			//1.�����������˵�ss��ָ���˿ں�
			ss = new ServerSocket(9989);
			
			//2.����accept�������Կͻ��˵�socket
			socket = ss.accept();
			
			//3.��ȡ������
			is = socket.getInputStream();
			
			//4.��ȡ������������
			bos = new ByteArrayOutputStream();
			byte buffer[] = new byte[5];
			int len;
			while ((len = is.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			System.out.println(bos.toString());
			System.out.println("�յ������ԣ�" + socket.getInetAddress().getHostAddress() + "������");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//�ر�
			if(bos!=null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bos!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bos!=null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bos!=null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
