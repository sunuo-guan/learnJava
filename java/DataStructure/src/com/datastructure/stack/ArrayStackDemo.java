package com.datastructure.stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("������ջ�Ĵ�С");
		int maxSize=scanner.nextInt();
		ArrayStack stack=new ArrayStack(maxSize);
		
		boolean loop=true;
		String key="";
		
		while(loop) {
			System.out.println("show:s");
			System.out.println("push:push");
			System.out.println("pop:pop");
			System.out.println("exit:e");
			System.out.println("ִ�к��ֹ���");
			key=scanner.next();           //
			switch (key) {
			case "s":
				stack.showStack();
				break;
			case "push":
				System.out.println("������ջ����");
				int value=scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					System.out.println("��ջ����Ϊ��"+stack.pop());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "e":
				loop =false;
				scanner.close();
				break;
			default:
				break;
			}
		}
		System.out.println("�����˳�");
		
	}

}


class ArrayStack{
	private int maxSize;
	private int top;
	private int[] stack;
	
	//������
	public ArrayStack(int maxSize) {
		this.maxSize=maxSize;
		stack=new int[this.maxSize];
		top=-1;
	}
	
	//�ж�ջ��
	public boolean isFull() {
		return top==maxSize-1;
	}
	
	
	//�ж�ջ��
	public boolean isEmpty() {
		return top==-1;
	}
	
	
	
	//��ջ
	public void push(int value) {
		//���� ���ж�
		if(isFull()) {
			System.out.println("ջ�����޷���ջ");
			return;
		}
		top++;
		stack[top]=value;
	}
	
	
	//��ջ
	public int pop() {
		//�ȼ����쳣
		if(isEmpty()) {
			throw new RuntimeException("ջ�ѿ�");
		}
		int value=stack[top];
		top--;
		return value;
	}
	
	//���� ��ջ����ջ��
	public void showStack() {
		//�ȼ���
		if(isEmpty()) {
			System.out.println("ջ�ѿ�");
			return;
		}
		
		for (int i = top; i >= 0; i--) {
			System.out.println("stack["+i+"]="+stack[i]);
		}
	}
	
	
	
	
	
	
}


