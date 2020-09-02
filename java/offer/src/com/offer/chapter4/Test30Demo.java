package com.offer.chapter4;

import java.util.Arrays;
import java.util.Stack;

public class Test30Demo {
	public static void main(String[] args) {
		int[] i=new int[2];
		System.out.println(Arrays.toString(i));
	}
}

class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
    /** initialize your data structure here. */
    public MinStack() {
    	stack=new Stack<Integer>();
    	minStack=new Stack<Integer>();  	
    }
    
    public void push(int x) {
    	stack.push(x);
    	if(minStack.isEmpty()) {
    		minStack.push(x);
    	}else {
    		//最小值栈每次都把当前数目的元素的最小值入栈！！！
    		int temp=minStack.peek();
    		if(temp>x) {
    			minStack.push(x);
    		}else {
    			minStack.push(temp);
    		}
    	}
    }
    
    public void pop() {
    	stack.pop();
    	minStack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int min() {
    	return minStack.peek();
    }
}
