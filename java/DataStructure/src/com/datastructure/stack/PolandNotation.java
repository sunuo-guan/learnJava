package com.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	public static void main(String[] args) {
		//�������ʽ
		String target="3 4 + 5 * 6 -";
		
		List<String> list=getListString(target);
		System.out.println("taarget="+list);
		int res=cal(list);
		System.out.println("������="+res);
		
		System.out.println("*********");
		String target2="1+1*(2+3*2)-4/2";		
		List<String> list2=stringToArrayList(target2);
		System.out.println(list2);
		
		System.out.println("*********");
		System.out.println("ת����ĺ�׺���ʽΪ��");
		System.out.println(parseSuffixExpressionList(list2));
		
		System.out.println("*********");
		res=cal(parseSuffixExpressionList(list2));
		System.out.println("������Ϊ"+res);
	}
	
	//��һ����׺���ʽ�ַ�������ת���ɺ�׺���ʽ�ַ�������
	public static List<String> parseSuffixExpressionList(List<String> list){
		Stack<String> stack = new Stack<String>();
		List<String> resultList = new ArrayList<String>();
		
		for(String item:list){
			if(item.matches("\\d+")) {
				//������� ֱ�Ӽ�����
				resultList.add(item);
			}else if(item.equals("(")) {
				//����������� ֱ��ѹ�����ջ��
				stack.push(item);
			}else if(item.equals(")")){
				//����������� ��ջ�еķ��Ŷ����� ���뵽��� ֱ������������
				while(!stack.peek().equals("(")) {
					resultList.add(stack.pop());
				}
				//�ǵý������������ŵ���ջ �������뵽�����
				stack.pop();
			}else {
				//������� �жϷ������ȼ�
				//����ǰ��ջ��С����� �򵯳������ ѭ�� ֱ������������ ѹ��ǰ��ջ
				//����ǰ��ջ�ڴ� ֱ��ѹ��ջ��
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
	
	//��һ�����ʽת���ַ�������
	public static List<String> stringToArrayList(String str){
		List<String> strList = new ArrayList<String>();
		int count=0;
		char ch=0;   //���մ�strȡ�������ַ���
		String keepNum="";  //��λ��ƴ��
		while(count<str.length()) {
			ch=str.charAt(count);
			if(ch<48||ch>57) {
				//��ʱΪ������ ascii��
				strList.add(""+ch);
				count++;
			}else {
				//��ʱΪ���� �����ַ���ƴ��
				keepNum="";         //������Ϊ��
				while(ch>=48&&ch<=57&&count<str.length()) {
					keepNum=keepNum+ch;
					count++;
					if(count<str.length()) {
						ch=str.charAt(count);   //��������
					}
				}
				strList.add(keepNum);
			}
				
		}
		
		
		return strList;
	}
	
	//��һ�����ʽ���η��뵽ArrayList�� ��ʱ�ı��ʽ���пո��
	public static List<String> getListString(String target){
		//�ָ�target
		String[] split = target.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele:split) {
			list.add(ele);
		}
		return list;
	}
	
	public static int cal(List<String> list) {
		//ֻ��Ҫ����һ��ջ
		Stack<String> stack=new Stack<String>();
		for(String item:list) {
			//������ʽȡ����
			if(item.matches("\\d+")) {  //ƥ����Ƕ�λ��
				//��ջ
				stack.push(item);
			}
			else {
				//pop���������м���
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
					throw new RuntimeException("���������");
				}
				stack.push(""+res);
			}
		}
		//�����
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
