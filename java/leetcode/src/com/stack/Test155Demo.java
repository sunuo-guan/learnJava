package com.stack;

import java.util.Stack;

public class Test155Demo {


}

class MinStack {
	Stack<Integer> stack=new Stack<Integer>();
	Stack<Integer> minStack=new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {
    	stack=new Stack<Integer>();
    	minStack=new Stack<Integer>();
    } 
    
    public void push(int x) {
    	stack.push(x);
    	if(!minStack.isEmpty()&&minStack.peek()<x) {
    		int min=minStack.peek();
    		minStack.push(min);
    	}else {
    		minStack.push(x);
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