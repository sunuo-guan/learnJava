package com.dianxinyun.three;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextLine();
		}
		solution(arr);
	}
	
	public static void solution(String arr[]) {
		MinStack minStack = new MinStack();
		for (int i = 0; i < arr.length; i++) {
			String temp[] = arr[i].split(" ");
			switch(temp[0]) {
			case "push":
				int x = Integer.parseInt(temp[1]);
				minStack.push(x);
				break;
			case "pop":
				minStack.pop();
				break;
			case "top":
				System.out.println(minStack.top());
				break;
			case "getMin":
				System.out.println(minStack.getMin());
				break;
			default:
				break;
			}
		}
	}
}

class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int x) {
		stack.push(x);
		if(minStack.isEmpty()) {
			minStack.push(x);
		}else {
			minStack.push(Math.min(minStack.peek(),x));
		}
	}
	
	public void pop() {
		stack.pop();
		minStack.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}
}
