package com.thread;

public class ProductTest {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();

		Thread p1 = new Thread(new Productor(clerk));
		Thread c1 = new Thread(new Consumer(clerk));

		p1.setName("������1");
		c1.setName("������1");

		c1.start();
		p1.start();
	}
}

class Clerk {
	private int product = 0;

	public synchronized void product() {
		// TODO Auto-generated method stub
		if (product >= 20) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			product++;
			System.out.println("�����������˵�" + product + "����Ʒ");
			notifyAll();
		}
	}

	public synchronized void consume() {
		if (this.product <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("������ȡ���˵�" + product + "����Ʒ");
			product--;
			notifyAll();
		}
	}

}

class Productor implements Runnable {
	private Clerk clerk;

	public Productor(Clerk clerk) {
		// TODO Auto-generated constructor stub
		this.clerk = clerk;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�����߿�ʼ������Ʒ");
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.product();
		}
	}

}

class Consumer implements Runnable {
	private Clerk clerk;

	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�����߿�ʼ������Ʒ");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clerk.consume();
	}
}