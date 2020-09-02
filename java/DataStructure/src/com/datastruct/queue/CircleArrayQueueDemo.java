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

class CircleArrayQueue {
	private int maxSize;
	private int front; // ͷ
	private int rear; // β
	private int arr[]; // ����ģ�����

	public CircleArrayQueue(int size) {
		maxSize = size;
		front = 0; // ͷβָ���ʼֵ��һ��
		rear = 0;
		arr = new int[maxSize];
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
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
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	// ��ȡ�������ݣ�������
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("���п�");
		}
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}
	
	// ��ʾ������������,��front��ʼ����
		public void show() {
			if (isEmpty()) {
				throw new RuntimeException("���п�");
			}
			for (int i = front; i < size()+front; i++) {
				System.out.println(arr[i%maxSize]);
			}
		}
		
	//��ǰ���е���Ч���ݸ���
	public int size() {
		return (rear+maxSize-front)%maxSize;
	}
	
	//��ʾ��ͷ����
	public int showFront() {
		if(isEmpty()) {
			throw new RuntimeException("���п�");
		}
		return arr[front];
	}

}
