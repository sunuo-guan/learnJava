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
			// synchronized (this) { //��ʱthis����Ψһ������
			synchronized (Window2.class) {    //��Ҳ�Ƕ�����Ψһ��Window2.classֻ�����һ��

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

//ͬ����������̳���
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
	
	//��������д�ɾ�̬��;ͬ����������Window3.class
	private static synchronized void show() {
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
