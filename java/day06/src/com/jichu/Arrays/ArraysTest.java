package com.jichu.Arrays;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {
		//boolean equals(int[] a,int[] b) 判断两个数组是否相等。
		
		int[] arr1= {1,2,3,4};
		int[] arr2= {1,2,5,3};
		boolean isEqual=Arrays.equals(arr1, arr2);
		System.out.println(isEqual);
		
		//String toString(int[] a) 输出数组信息
		System.out.println(Arrays.toString(arr2));
		
		//void fill(int[] a,int val) 将指定值填充到数组之中。
		Arrays.fill(arr1, 1);
		System.out.println(Arrays.toString(arr1));
		
		//void sort(int[] a) 对数组进行排序。
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		//int binarySearch(int[] a,int key) 对排序后的数组进行二分法检索指定的值。有序，返回下标
		//若返回负数 则未找到
		int index=Arrays.binarySearch(arr2, 5);
		System.out.println(index);
		
		String string = new String();
	}
}
