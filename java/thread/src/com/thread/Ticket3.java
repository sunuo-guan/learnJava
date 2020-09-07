package com.thread;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket3 {
	public static void main(String[] args) {
		WindowMethod2 window = new WindowMethod2();

		Thread window1 = new Thread(window);
		Thread window2 = new Thread(window);
		Thread window3 = new Thread(window);

		window1.start();
		window2.start();
		window3.start();
	}
}
/**
 * lock:手动加减锁；synchronized：自动加减锁
 * @author Administrator
 *
 */
class WindowMethod2 implements Runnable {
	private int ticket = 100;
	//1.实例化ReentrantLock
	private ReentrantLock lock=new ReentrantLock();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				//2.调用锁定方法lock
				lock.lock();
				
				if (ticket > 0) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "卖出票号：" + ticket);
					ticket--;
				}else{
					break;
				}
			}finally {
				//3.调用解锁方法unlock
				lock.unlock();
			}
			
		}
	}
}
