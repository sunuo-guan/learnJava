package com.wangyihuyu.one;

import java.util.*;

public class Main{
	public static void main(String[] args) {
		solution1 solution = new solution1();
		System.out.println(solution.add("1", "1.71"));
	}
}

class solution1 {
	
	public static int jinwei=0;
	
	public String add (String num1, String num2) {
        // write code here
		
		char str1[]=num1.toCharArray();
		char str2[]=num2.toCharArray();
		
		int str1Isfu=isFu(str1);
		int str2Isfu=isFu(str2);
		
		int str1Point=isPoint(str1);
		int str2Point=isPoint(str2);
		
		Stack<Character> stack1=new Stack<Character>();
		Stack<Character> stack2=new Stack<Character>();
		
		Stack<Character> stack1point=new Stack<Character>();
		Stack<Character> stack2point=new Stack<Character>();
		
		
		Stack<Character> result=new Stack<Character>();
		Stack<Character> resultPoint=new Stack<Character>();
		
		if(str1Isfu==str2Isfu) {
			if(str2Point==str2.length&&str1Point==str1.length) {
				for(int i=str1Isfu;i<str1.length;i++) {
					stack1.push(str1[i]);
				}
				for(int i=str2Isfu;i<str2.length;i++) {
					stack2.push(str2[i]);
				}
				
				while(!stack1.isEmpty()||!stack2.isEmpty()) {
					char a=!stack1.isEmpty()?stack1.pop():'0';
					char b=!stack2.isEmpty()?stack2.pop():'0';
					result.push((char)('0'+addSingle(a, b)));
					
				}
				
			}else {
				for(int i=str1Isfu;i<str1Point;i++) {
					stack1.push(str1[i]);
				}
				for(int i=str2Isfu;i<str2Point;i++) {
					stack2.push(str2[i]);
				}
				
				for(int i=str1Point+1;i<str1.length;i++) {
					stack1point.push(str1[i]);
				}
				for(int i=str2Point+1;i<str2.length;i++) {
					stack2point.push(str2[i]);
				}
				
				while(!stack1point.isEmpty()||!stack2point.isEmpty()) {
					while(stack1point.size()!=stack2point.size()) {
						char a=stack1point.size()>stack2point.size()?stack1point.pop():stack2point.pop();
						char b='0';
						resultPoint.push((char)('0'+addSingle(a, b)));
						
					}
					
					char a=stack1point.pop();
					char b=stack2point.pop();;
					resultPoint.push((char)('0'+addSingle(a, b)));
					
				}
				
				while(!stack1.isEmpty()||!stack2.isEmpty()) {
					char a=!stack1.isEmpty()?stack1.pop():'0';
					char b=!stack2.isEmpty()?stack2.pop():'0';
					result.push((char)('0'+addSingle(a, b)));
					
				}
				
			}
			
			
		}
		
		StringBuilder sb=new StringBuilder();
		if(str1Isfu==1&&str1Isfu==1) {
			sb.append('-');
		}
		
		if(jinwei==1) {
			sb.append('1');
		}
		
		while(!result.isEmpty()) {
			sb.append(result.pop());
		}
		
		if(str1Point<str1.length||str2Point<str2.length) {
			sb.append('.');
			while(!resultPoint.isEmpty()) {
				sb.append(resultPoint.pop());
			}
		}
		
		
		return sb.toString();
		
    }
	
	public int isFu(char str[]) {
		if(str[0]=='-') {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int isPoint(char str[]) {
		for (int i = 0; i < str.length; i++) {
			if(str[i]=='.') {
				return i;
			}
		}		
		return str.length;
	}
	
	public int addSingle(char a,char b) {
		int res=(a-'0')+(b-'0')+jinwei;
		if(res>=9) {
			res=res%9;
			jinwei=1;
		}else {
			jinwei=0;
		}
		
		return res;
		
	}
}


