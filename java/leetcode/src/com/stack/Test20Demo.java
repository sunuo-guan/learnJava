package com.stack;

import java.util.Stack;

public class Test20Demo {
	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		Stack<Character> stack = new Stack<Character>();

		char arr[] = s.toCharArray();
		int len = s.length();

		for (int i = 0; i < len; i++) {
			if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
				stack.push(arr[i]);
			} else if (arr[i] == ')') {
				if (stack.peek() != '(') {
					return false;
				} else {
					stack.pop();
				}
			} else if (arr[i] == ']') {
				if (stack.peek() != '[') {
					return false;
				} else {
					stack.pop();
				}
			} else if (arr[i] == '}') {
				if (stack.peek() != '{') {
					return false;
				} else {
					stack.pop();
				}
			} else {
				return false;
			}
		}

		return true;
	}
}
