package com.offer.chapter2;

import java.util.Stack;

public class Test9Demo {

}

class CQueue {
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public CQueue() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void appendTail(int value) {
		stack1.push(value);
	}

	public int deleteHead() {
		if(stack1.isEmpty()) {
			return -1;
		}
		int temp;
		while(!stack1.isEmpty()) {
			temp=stack1.pop();
			stack2.push(temp);
		}
		int res=stack2.pop();
		while(!stack2.isEmpty()) {
			temp=stack2.pop();
			stack1.push(temp);
		}
		return res;
	}
}
