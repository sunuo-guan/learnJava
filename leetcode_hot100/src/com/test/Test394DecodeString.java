package com.test;

import java.util.*;

public class Test394DecodeString {
	public static void main(String[] args) {
		String s = "2[abc]3[cd]ef";
		System.out.println(decodeString(s));
	}
	
	//使用栈
    public static String decodeString(String s) {
    	StringBuilder result = new StringBuilder();
    	Stack<Integer> numStack = new Stack<Integer>();
    	Stack<String> stringStack = new Stack<String>();
    	char arr[] = s.toCharArray();
    	int len = s.length();
    	int num = 0;
    	for (int i = 0; i < len; i++) {
			if(arr[i] >= '0' && arr[i] <= '9') {
				num = num*10 + arr[i] - '0';
			} else if(arr[i] == '[') {
				numStack.push(num);
				num = 0;
				stringStack.push(result.toString());
				result = new StringBuilder();
			} else if(arr[i] == ']') {
				int count = numStack.pop();
				StringBuilder tmp = new StringBuilder();
				for(int j=0;j<count;j++) {
					tmp.append(result);
				}
				result = new StringBuilder(stringStack.pop()+tmp);
			} else {
				result.append(arr[i]);
			}
		}
    	return result.toString();
    }
}
