package com.thread;

import javax.sql.rowset.Joinable;

public class ThreadMethodTest {
	public static void main(String[] args) {
		// 构造器命名
		HelloThread thread1 = new HelloThread("一");

		// 设置线程名字
		thread1.setName("线程一");

		thread1.start();

		// 给主线程命名
		Thread.currentThread().setName("主线程");
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		for (int i = 0; i < 100; i++) {
			if (i % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
			
			if(i==20) {
				//当某个程序执行流中调用其他线程的 join() 方法时， 调用线程将被阻塞，
				//直到 join() 方法加入的 join 线程完全执行完为止
				//低优先级的线程也可以获得执行
//				try {
//					thread1.join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
		
		System.out.println(thread1.isAlive());
		
		/**线程的优先级:一般为5
		 * getPriority() ： 返回线程优先值
		 * setPriority(int newPriority) ： 改变线程的优先级
		 *   线程创建时继承父线程的优先级
		 * 低优先级只是获得调度的概率低，并非一定是在高优先级线程之后才被调用
		 */
	}
}

class HelloThread extends Thread {
	public HelloThread(String name) {
		super(name);
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				
				//令当前活动线程在指定时间段内放弃对CPU控制,使其他线程有机会被执行,时间到后重排队(单位毫秒)。
				//抛出InterruptedException异常
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
			
		}
	}
}