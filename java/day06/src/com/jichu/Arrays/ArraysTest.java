package com.jichu.Arrays;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {
		//boolean equals(int[] a,int[] b) �ж����������Ƿ���ȡ�
		
		int[] arr1= {1,2,3,4};
		int[] arr2= {1,2,5,3};
		boolean isEqual=Arrays.equals(arr1, arr2);
		System.out.println(isEqual);
		
		//String toString(int[] a) ���������Ϣ
		System.out.println(Arrays.toString(arr2));
		
		//void fill(int[] a,int val) ��ָ��ֵ��䵽����֮�С�
		Arrays.fill(arr1, 1);
		System.out.println(Arrays.toString(arr1));
		
		//void sort(int[] a) �������������
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		//int binarySearch(int[] a,int key) ��������������ж��ַ�����ָ����ֵ�����򣬷����±�
		//�����ظ��� ��δ�ҵ�
		int index=Arrays.binarySearch(arr2, 5);
		System.out.println(index);
		
		String string = new String();
	}
}
