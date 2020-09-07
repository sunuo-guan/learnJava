package com.datastructure.stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入栈的大小");
		int maxSize=scanner.nextInt();
		ArrayStack stack=new ArrayStack(maxSize);
		
		boolean loop=true;
		String key="";
		
		while(loop) {
			System.out.println("show:s");
			System.out.println("push:push");
			System.out.println("pop:pop");
			System.out.println("exit:e");
			System.out.println("执行何种功能");
			key=scanner.next();           //
			switch (key) {
			case "s":
				stack.showStack();
				break;
			case "push":
				System.out.println("输入入栈数字");
				int value=scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					System.out.println("出栈数字为："+stack.pop());
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
		System.out.println("程序退出");
		
	}

}


class ArrayStack{
	private int maxSize;
	private int top;
	private int[] stack;
	
	//构造器
	public ArrayStack(int maxSize) {
		this.maxSize=maxSize;
		stack=new int[this.maxSize];
		top=-1;
	}
	
	//判断栈满
	public boolean isFull() {
		return top==maxSize-1;
	}
	
	
	//判断栈空
	public boolean isEmpty() {
		return top==-1;
	}
	
	
	
	//入栈
	public void push(int value) {
		//检验 先判断
		if(isFull()) {
			System.out.println("栈满，无法入栈");
			return;
		}
		top++;
		stack[top]=value;
	}
	
	
	//出栈
	public int pop() {
		//先检验异常
		if(isEmpty()) {
			throw new RuntimeException("栈已空");
		}
		int value=stack[top];
		top--;
		return value;
	}
	
	//遍历 从栈顶到栈底
	public void showStack() {
		//先检验
		if(isEmpty()) {
			System.out.println("栈已空");
			return;
		}
		
		for (int i = top; i >= 0; i--) {
			System.out.println("stack["+i+"]="+stack[i]);
		}
	}
	
	
	
	
	
	
}


