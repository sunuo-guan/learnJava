package com.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	public static void main(String[] args) {
		//给定表达式
		String target="3 4 + 5 * 6 -";
		
		List<String> list=getListString(target);
		System.out.println("taarget="+list);
		int res=cal(list);
		System.out.println("计算结果="+res);
		
		System.out.println("*********");
		String target2="1+1*(2+3*2)-4/2";		
		List<String> list2=stringToArrayList(target2);
		System.out.println(list2);
		
		System.out.println("*********");
		System.out.println("转化后的后缀表达式为：");
		System.out.println(parseSuffixExpressionList(list2));
		
		System.out.println("*********");
		res=cal(parseSuffixExpressionList(list2));
		System.out.println("计算结果为"+res);
	}
	
	//将一个中缀表达式字符串数组转换成后缀表达式字符串数组
	public static List<String> parseSuffixExpressionList(List<String> list){
		Stack<String> stack = new Stack<String>();
		List<String> resultList = new ArrayList<String>();
		
		for(String item:list){
			if(item.matches("\\d+")) {
				//如果是数 直接加入结果
				resultList.add(item);
			}else if(item.equals("(")) {
				//如果是左括号 直接压入符号栈中
				stack.push(item);
			}else if(item.equals(")")){
				//如果是右括号 将栈中的符号都弹出 加入到结果 直到遇到左括号
				while(!stack.peek().equals("(")) {
					resultList.add(stack.pop());
				}
				//记得将遇到的左括号弹出栈 但不加入到结果中
				stack.pop();
			}else {
				//其他情况 判断符号优先级
				//若当前比栈内小或相等 则弹出到结果 循环 直到不满足条件 压当前入栈
				//若当前比栈内大 直接压入栈中
				while(stack.size()!=0&&Operator.getValue(item)<=Operator.getValue(stack.peek())) {
					resultList.add(stack.pop());
				}
				stack.push(item);
			}
		}
		
		while(stack.size()!=0) {
			resultList.add(stack.pop());
		}
		
		return resultList;
	}
	
	//将一个表达式转成字符串数组
	public static List<String> stringToArrayList(String str){
		List<String> strList = new ArrayList<String>();
		int count=0;
		char ch=0;   //接收从str取出来的字符串
		String keepNum="";  //多位数拼接
		while(count<str.length()) {
			ch=str.charAt(count);
			if(ch<48||ch>57) {
				//此时为非数字 ascii表
				strList.add(""+ch);
				count++;
			}else {
				//此时为数字 考虑字符串拼接
				keepNum="";         //必须置为空
				while(ch>=48&&ch<=57&&count<str.length()) {
					keepNum=keepNum+ch;
					count++;
					if(count<str.length()) {
						ch=str.charAt(count);   //出过错！！
					}
				}
				strList.add(keepNum);
			}
				
		}
		
		
		return strList;
	}
	
	//将一个表达式依次放入到ArrayList里 此时的表达式是有空格的
	public static List<String> getListString(String target){
		//分割target
		String[] split = target.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele:split) {
			list.add(ele);
		}
		return list;
	}
	
	public static int cal(List<String> list) {
		//只需要创建一个栈
		Stack<String> stack=new Stack<String>();
		for(String item:list) {
			//正则表达式取出数
			if(item.matches("\\d+")) {  //匹配的是多位数
				//入栈
				stack.push(item);
			}
			else {
				//pop两个数进行计算
				int num1=Integer.parseInt(stack.pop());
				int num2=Integer.parseInt(stack.pop());
				int res =0;
				if(item.equals("+")) {
					res=num1+num2;
				}else if(item.equals("-")) {
					res=num2-num1;
				}else if(item.equals("*")) {
					res=num1*num2;
				}else if(item.equals("/")) {
					res=num2/num1;
				}else {
					throw new RuntimeException("运算符错误");
				}
				stack.push(""+res);
			}
		}
		//最后结果
		return Integer.parseInt(stack.pop());
		
	}
}

class Operator{
	private static int ADD =1;
	private static int SUB =1;
	private static int MUL =2;
	private static int DIV =2;
	
	public static int getValue(String op) {
		int result=0;
		switch (op) {
		case "+":
			result=ADD;
			break;
		case "-":
			result=SUB;
			break;
		case "*":
			result=MUL;
			break;
		case "/":
			result=DIV;
			break;
		default:
			break;
		}
		
		return result;
	}
}
