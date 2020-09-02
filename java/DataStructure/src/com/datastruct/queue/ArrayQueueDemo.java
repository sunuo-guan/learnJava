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
					System.out.println("������һ������");
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
					System.out.println("���У�"+value);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			default:
				break;
			}
			
		}
		System.out.println("�˳�");
	}
}

class ArrayQueue {
	private int maxSize;   //ѭ����������һ��Ԫ�ؿռ�
	private int front; // ͷ
	private int rear; // β
	private int arr[]; // ����ģ�����

	// ������
	public ArrayQueue(int size) {
		maxSize = size;
		front = -1;
		rear = -1;
		arr = new int[maxSize];
	}

	// �ж��Ƿ���
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// �ж��Ƿ��
	public boolean isEmpty() {
		return rear == front;
	}

	// �������
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("������");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	// ��ȡ�������ݣ�������
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("���п�");
		}
		front++;
		return arr[front];
	}

	// ��ʾ������������
	public void show() {
		if (isEmpty()) {
			throw new RuntimeException("���п�");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	//��ʾ��ͷ����
	public int showFront() {
		if(isEmpty()) {
			throw new RuntimeException("���п�");
		}
		return arr[front+1];
	}
}
