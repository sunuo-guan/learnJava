package com.offer.chapter6;

import java.util.Arrays;

public class Test66Demo {
	public static void main(String[] args) {
		int a[]= {1,2,3,4,5};
		System.out.println(Arrays.toString(constructArr(a)));
	}
	
	/**
	 * 以i为界限，将数组分为两部分，分别从左右进行累乘
	 * @param a
	 * @return
	 */
	public static int[] constructArr(int[] a) {
		if(a==null||a.length<=0) {
			return new int[0];
		}
		
		int len=a.length;
		int b[]=new int[len];
		//先初始化为1
		for (int i = 0; i < b.length; i++) {
			b[i]=1;
		}
		
		//left right分别记录左右累乘a[i]后的结果
		int left=1,right=1;
		
		//左边累乘
		for (int i = 0; i < len; i++) {
			b[i]=b[i]*left;
			left=left*a[i];
		}
		
		//右边累乘
		for (int i = len-1; i >=0; i--) {
			b[i]=b[i]*right;
			right=right*a[i];
		}
		
		return b;
    }
}
