package com.thread;

public class CommunicationTest {
	public static void main(String[] args) {
		Communicate communicate = new Communicate();
		Thread t1 = new Thread(communicate);
		Thread t2 = new Thread(communicate);
		
		t1.start();
		t2.start();
		
	}
}

/**
 * 两个进程交替打印1-100，涉及进程通信
 * 三个方法：
 * wait：进入阻塞
 * notify：唤醒一个（优先级高）
 * notifyAll：唤醒多个
 * 只能放在同步代码块或者同步方法里；
 * 三个方法的调用者必须是同步代码块、同步方法的同步监视器，否则会出错；
 * 三个方法都定义在Object中
 * @author Administrator
 *
 */
class Communicate implements Runnable{
	private int num=1;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			synchronized (this) {
				
				notify();
				
				if(num<=100) {
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName()+"打印："+num);
					num++;
					
					try {
						//使得线程进入阻塞状态
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					break;
				}
			}		
			
		}
	}
}
