package com.test;

import java.util.Stack;

public class Test739DailyTemperatures {
	public static void main(String[] args) {
		int T[] = {73, 74, 75, 71, 69, 72, 76, 73};
		int res[] = dailyTemperaturesStack(T);
	}
	
	public int[] dailyTemperatures(int[] T) {
		int res[] = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			for (int j = i; j < res.length; j++) {
				if(T[j] > T[i]) {
					res[i] = j - i;
					break;
				}
			}
		}
		return res;
    }
	
	//单调栈:遍历一次数组，当栈不为空
	public static int[] dailyTemperaturesStack(int[] T) {
		int res[] = new int[T.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < T.length; i++) {
			while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int temp = stack.pop();
				res[temp] = i - temp;
			}
			stack.push(i);
		}
		return res;
    }
}
