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
		//ָ���ջ�����ָ��
		int popIndex=0;
		
		//��ջ����ָ��ѭ��
		
		for (int pushIndex = 0; pushIndex < popped.length; pushIndex++) {
			stack.push(pushed[pushIndex]);
			//��ջ��Ԫ�����ջ���鵱ǰֵ���ʱ����ջ����ջ������ƣ�ֱ��ջ�ջ��߲���
			while(!stack.isEmpty()&&stack.peek()==popped[popIndex]) {
				stack.pop();
				popIndex++;
			}
			
			
		}
		
		//��ջ������������ջ�ڲ�Ϊ�գ���false
		
		return stack.isEmpty();
	}

}