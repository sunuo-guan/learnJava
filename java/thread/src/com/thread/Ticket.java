package com.thread;

public class Ticket {
	public static void main(String[] args) {
		WindowMethod window = new WindowMethod();

		Thread window1 = new Thread(window);
		Thread window2 = new Thread(window);
		Thread window3 = new Thread(window);

		window1.start();
		window2.start();
		window3.start();
	}
}

/**
 * 解决安全问题： 方法一：同步代码块： synchronized（同步监视器）{ 
 * 需要被同步的代码
 *  }
 * 同步监视器:俗称锁，任何类的对象都可以充当锁;要求多个线程必须共用一把锁
 * 
 * 方法二：同步方法：
 * 
 * @author Administrator
 *
 */
class Window implements Runnable {
	private int ticket = 100;
	// Object obj = new Object();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			// synchronized (obj) {
			synchronized (this) {   //此时this：唯一

				if (ticket > 0) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "卖出票号：" + ticket);
					ticket--;
				} else {
					break;
				}
			}
		}
	}
}


class WindowMethod implements Runnable {
	private int ticket = 100;
	// Object obj = new Object();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			show();
			if(ticket<=0) {
				break;
			}
		}
	}
	
	//同步方法；同步监视器：this
	private synchronized void show() {
		if (ticket > 0) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "卖出票号：" + ticket);
			ticket--;
		} 
	}
}