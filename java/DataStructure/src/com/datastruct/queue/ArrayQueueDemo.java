package com.datastruct.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		
		ArrayQueue queue = new ArrayQueue(3);
		
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

class ArrayQueue {
	private int maxSize;   //循环队列少用一个元素空间
	private int front; // 头
	private int rear; // 尾
	private int arr[]; // 数组模拟队列

	// 构造器
	public ArrayQueue(int size) {
		maxSize = size;
		front = -1;
		rear = -1;
		arr = new int[maxSize];
	}

	// 判断是否满
	public boolean isFull() {
		return rear == maxSize - 1;
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
		rear++;
		arr[rear] = n;
	}

	// 获取队列数据，即出列
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列空");
		}
		front++;
		return arr[front];
	}

	// 显示队列所有数据
	public void show() {
		if (isEmpty()) {
			throw new RuntimeException("队列空");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	//显示队头数据
	public int showFront() {
		if(isEmpty()) {
			throw new RuntimeException("队列空");
		}
		return arr[front+1];
	}
}
