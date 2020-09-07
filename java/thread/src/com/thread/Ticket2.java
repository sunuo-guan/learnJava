package com.thread;

public class Ticket2 {
	public static void main(String[] args) {
		Window3 w1 = new Window3();
		Window3 w2 = new Window3();
		Window3 w3 = new Window3();

		w1.start();
		w2.start();
		w3.start();
	}
}

class Window2 extends Thread {
	private static int ticket = 100;
	//private static Object obj = new Object();

	public void run() {
		while (true) {
//			synchronized (obj) {
			// synchronized (this) { //此时this：不唯一，错误
			synchronized (Window2.class) {    //类也是对象，且唯一；Window2.class只会加载一次

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

//同步方法处理继承类
class Window3 extends Thread {
	private static int ticket = 100;

	public void run() {
		while (true) {
			show();
			if(ticket<=0) {
				break;
			}
		}
	}
	
	//方法必须写成静态的;同步监视器：Window3.class
	private static synchronized void show() {
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
