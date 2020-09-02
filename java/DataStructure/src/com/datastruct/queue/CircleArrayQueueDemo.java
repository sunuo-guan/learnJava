package com.datastruct.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		CircleArrayQueue queue = new CircleArrayQueue(4);
		
		String key="";
		Scanner input =new Scanner(System.in);
		
		boolean loop=true;
		
		while(loop) {
			System.out.println("e(exit)");
			System.out.println("s(show)");
			System.out.println("a(add)");
			System.out.println("g(get)");
			key=input.next();
			switch (key) {
			case "e":
				input.close();
				loop=false;
				break;
			case "s":
				try {
					queue.show();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}

				break;
			case "a":
				try {
					System.out.println("请输入一个数：");
					int value=input.nextInt();
					queue.addQueue(value);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "g":
				try {
					int value=queue.getQueue();
					System.out.println("出列："+value);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			default:
				break;
			}
			
		}
		System.out.println("退出");
	}
}

class CircleArrayQueue {
	private int maxSize;
	private int front; // 头
	private int rear; // 尾
	private int arr[]; // 数组模拟队列

	public CircleArrayQueue(int size) {
		maxSize = size;
		front = 0; // 头尾指针初始值不一样
		rear = 0;
		arr = new int[maxSize];
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	// 判断是否空
	public boolean isEmpty() {
		return rear == front;
	}

	// 添加数据
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("队列满");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	// 获取队列数据，即出列
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列空");
		}
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}
	
	// 显示队列所有数据,从front开始遍历
		public void show() {
			if (isEmpty()) {
				throw new RuntimeException("队列空");
			}
			for (int i = front; i < size()+front; i++) {
				System.out.println(arr[i%maxSize]);
			}
		}
		
	//求当前队列的有效数据个数
	public int size() {
		return (rear+maxSize-front)%maxSize;
	}
	
	//显示队头数据
	public int showFront() {
		if(isEmpty()) {
			throw new RuntimeException("队列空");
		}
		return arr[front];
	}

}
