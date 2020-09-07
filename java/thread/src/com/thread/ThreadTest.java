package com.thread;

public class ThreadTest {
	public static void main(String[] args) {
		//3.创建thread类的子类的对象
		myThread myThread = new myThread();
		
		//4.通过此对象调用start方法:启动当前线程；调用当前线程的run()；
		myThread.start();
		//注意：不能再调用同一个线程的start；需要重新创建一个线程的对象
		
		
		for (int i = 100; i < 200; i++) {
			System.out.println(i);
		}
	}
}

//1.创建一个继承thread的子类
class myThread extends Thread{
	//2.重写run方法--此方法执行的操作
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
}