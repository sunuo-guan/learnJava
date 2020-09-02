package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1.call�����з���ֵ
 * 2.call���������׳��쳣��������Ĳ�������
 * 3.֧�ַ���
 * @author Administrator
 *
 */
public class ThreadCallable {
	public static void main(String[] args) {
		//3.����callable�ӿ�ʵ����Ķ���
		NumThread numThread = new NumThread();
		//4.����callable�ӿ�ʵ����Ķ�����Ϊ���ݵ�FutureTask�������У�����FutureTask����
		FutureTask futureTask = new FutureTask(numThread);
		
		//5.��FutureTask������Ϊ�������ݵ�Thread��Ĺ������У�����Thread���󣬲�����start
		new Thread(futureTask).start();
		
		try {
			//6.��ȡcallable�����ķ���ֵ
			//get����ֵ��Ϊcall�����ķ���ֵ
			Object sum=futureTask.get();
			System.out.println(sum);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//1.����һ��ʵ��Callable��ʵ����
class NumThread implements Callable{
	@Override
	//2.ʵ��call�����������߳���Ҫִ�еĲ���������call��
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
