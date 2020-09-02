package com.offer.chapter4;

import java.util.Stack;

public class Test31Demo {
	public static void main(String[] args) {
		Solution31 solution31 = new Solution31();
		int push[] = {1,2,3,4,5};
		int pop[] = {4,5,3,2,1};
		boolean res = solution31.validateStackSequences(push, pop);
		System.out.println(res);
	}
}

class Solution31 {

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		if(pushed==null||popped==null||pushed.length!=popped.length) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		//指向出栈数组的指针
		int popIndex=0;
		
		//入栈数组指针循环
		
		for (int pushIndex = 0; pushIndex < popped.length; pushIndex++) {
			stack.push(pushed[pushIndex]);
			//当栈顶元素与出栈数组当前值相等时，出栈，出栈数组后移，直到栈空或者不等
			while(!stack.isEmpty()&&stack.peek()==popped[popIndex]) {
				stack.pop();
				popIndex++;
			}
			
			
		}
		
		//出栈数组遍历完后，若栈内不为空，即false
		
		return stack.isEmpty();
	}

}