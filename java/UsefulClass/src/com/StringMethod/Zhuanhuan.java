package com.StringMethod;

import java.util.Arrays;

public class Zhuanhuan {
	public static void main(String[] args) {
		//�ַ���ת�����������ͣ���װ�ྲ̬����
		String str="123";
		int num=Integer.parseInt(str)+1;
		
		//������������ת�ַ�����valueOf��+����
		str=String.valueOf(num);
		System.out.println(str);
		
		//�ַ���תchar����
		char charArr[]=str.toCharArray();
		
		//char����ת�ַ���
		String str1=new String(charArr);
		
		//�ַ���ת�ӽ�����byte[]
		str1="abc�й�";
		byte byteArr[]=str1.getBytes();
		System.out.println(Arrays.toString(byteArr));
		
		//�ӽ�����byte[]ת�ַ���
		String str2=new String(byteArr);
		System.out.println(str2);
		
	}
}
