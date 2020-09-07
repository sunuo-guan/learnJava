package com.offer.chapter6;

import java.util.Arrays;

public class Test66Demo {
	public static void main(String[] args) {
		int a[]= {1,2,3,4,5};
		System.out.println(Arrays.toString(constructArr(a)));
	}
	
	/**
	 * ��iΪ���ޣ��������Ϊ�����֣��ֱ�����ҽ����۳�
	 * @param a
	 * @return
	 */
	public static int[] constructArr(int[] a) {
		if(a==null||a.length<=0) {
			return new int[0];
		}
		
		int len=a.length;
		int b[]=new int[len];
		//�ȳ�ʼ��Ϊ1
		for (int i = 0; i < b.length; i++) {
			b[i]=1;
		}
		
		//left right�ֱ��¼�����۳�a[i]��Ľ��
		int left=1,right=1;
		
		//����۳�
		for (int i = 0; i < len; i++) {
			b[i]=b[i]*left;
			left=left*a[i];
		}
		
		//�ұ��۳�
		for (int i = len-1; i >=0; i--) {
			b[i]=b[i]*right;
			right=right*a[i];
		}
		
		return b;
    }
}
