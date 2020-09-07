package com.kuaishou.one;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
		kuohao(str);
	}
	
	public static void kuohao(String str) {
		Stack<Character> stack=new Stack<Character>();
		ArrayList<Character> list=new ArrayList<Character>();
		char arr[]=str.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='('||arr[i]==')') {
				list.add(arr[i]);
			}
		}
		
		int match=0;
		for(char key:list) {
			if(key=='(') {
				stack.push(key);
			}else {
				if(stack.isEmpty()) {
					stack.push(key);
				}else {
					if(stack.peek()=='(') {
						match++;
						stack.pop();
					}else {
						stack.push(key);
					}
				}
			}
		}
		
		int left=0,right=0;
		while(!stack.isEmpty()) {
			if(stack.pop()=='(') {
				left++;
			}else {
				right++;
			}
		}
		
		System.out.println(match+" "+left+" "+right);
	}
}
