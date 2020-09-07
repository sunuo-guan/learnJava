package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池
 * @author Administrator
 *
 */
public class ThreadPool {
	public static void main(String[] args) {
		//1.提供指定数量的线程池
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		//2.执行指定的线程的操作，需要提供runnable和callable接口的实现类的对象
//		pool.submit(task);      //适合callable
		pool.execute(new ThreadTest1());  //适合Runnable
		pool.execute(new ThreadTest2());
		
		//3.关闭线程池
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
