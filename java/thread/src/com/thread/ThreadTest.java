package com.thread;

public class ThreadTest {
	public static void main(String[] args) {
		//3.����thread�������Ķ���
		myThread myThread = new myThread();
		
		//4.ͨ���˶������start����:������ǰ�̣߳����õ�ǰ�̵߳�run()��
		myThread.start();
		//ע�⣺�����ٵ���ͬһ���̵߳�start����Ҫ���´���һ���̵߳Ķ���
		
		
		for (int i = 100; i < 200; i++) {
			System.out.println(i);
		}
	}
}

//1.����һ���̳�thread������
class myThread extends Thread{
	//2.��дrun����--�˷���ִ�еĲ���
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
}