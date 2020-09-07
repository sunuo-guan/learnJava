package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1.call方法有返回值
 * 2.call方法可以抛出异常，被外面的操作捕获
 * 3.支持泛型
 * @author Administrator
 *
 */
public class ThreadCallable {
	public static void main(String[] args) {
		//3.创建callable接口实现类的对象
		NumThread numThread = new NumThread();
		//4.将此callable接口实现类的对象作为传递到FutureTask构造其中，创建FutureTask对象
		FutureTask futureTask = new FutureTask(numThread);
		
		//5.将FutureTask对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start
		new Thread(futureTask).start();
		
		try {
			//6.获取callable方法的返回值
			//get返回值即为call函数的返回值
			Object sum=futureTask.get();
			System.out.println(sum);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//1.创建一个实现Callable的实现类
class NumThread implements Callable{
	@Override
	//2.实现call方法，将此线程需要执行的操作声明在call中
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		int sum=0;
		for (int i = 0; i <= 100; i++) {
			if(i%2==0) {
				System.out.println(i);
				sum+=i;
			}
		}
		
		return sum;
	}
}
