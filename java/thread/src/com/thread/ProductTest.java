package com.thread;

public class ProductTest {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();

		Thread p1 = new Thread(new Productor(clerk));
		Thread c1 = new Thread(new Consumer(clerk));

		p1.setName("生产者1");
		c1.setName("消费者1");

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
			System.out.println("生产者生产了第" + product + "个产品");
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
			System.out.println("消费者取走了第" + product + "个产品");
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
		System.out.println("生产者开始生产物品");
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
		System.out.println("消费者开始消费物品");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clerk.consume();
	}
}