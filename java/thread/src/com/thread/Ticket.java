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
 * �����ȫ���⣺ ����һ��ͬ������飺 synchronized��ͬ����������{ 
 * ��Ҫ��ͬ���Ĵ���
 *  }
 * ͬ��������:�׳������κ���Ķ��󶼿��Գ䵱��;Ҫ�����̱߳��빲��һ����
 * 
 * ��������ͬ��������
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
			synchronized (this) {   //��ʱthis��Ψһ

				if (ticket > 0) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "����Ʊ�ţ�" + ticket);
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
	
	//ͬ��������ͬ����������this
	private synchronized void show() {
		if (ticket > 0) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "����Ʊ�ţ�" + ticket);
			ticket--;
		} 
	}
}