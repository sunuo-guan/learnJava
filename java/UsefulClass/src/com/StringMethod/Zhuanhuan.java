package com.StringMethod;

import java.util.Arrays;

public class Zhuanhuan {
	public static void main(String[] args) {
		//字符串转基本数据类型：包装类静态方法
		String str="123";
		int num=Integer.parseInt(str)+1;
		
		//基本数据类型转字符串类valueOf，+“”
		str=String.valueOf(num);
		System.out.println(str);
		
		//字符串转char数组
		char charArr[]=str.toCharArray();
		
		//char数组转字符串
		String str1=new String(charArr);
		
		//字符串转子节数组byte[]
		str1="abc中国";
		byte byteArr[]=str1.getBytes();
		System.out.println(Arrays.toString(byteArr));
		
		//子节数组byte[]转字符串
		String str2=new String(byteArr);
		System.out.println(str2);
		
	}
}
