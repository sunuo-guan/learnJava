package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ʹ���̳߳�
 * @author Administrator
 *
 */
public class ThreadPool {
	public static void main(String[] args) {
		//1.�ṩָ���������̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		//2.ִ��ָ�����̵߳Ĳ�������Ҫ�ṩrunnable��callable�ӿڵ�ʵ����Ķ���
//		pool.submit(task);      //�ʺ�callable
		pool.execute(new ThreadTest1());  //�ʺ�Runnable
		pool.execute(new ThreadTest2());
		
		//3.�ر��̳߳�
		pool.shutdown();
		
		System.out.println();
	}
}

class ThreadTest1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			if(i%2==0) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
}

class ThreadTest2 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			if(i%2!=0) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
}
