package com.datastructure.search;

public class InsertValueSort {
	public static void main(String[] args) {
		int array[] =new int[100];
		for(int i=0;i<array.length;i++) {
			array[i]=i*2;
		}

		int findValue = 99;
		int index = insertValueSort(array, 0, array.length - 1, findValue);
		if (index == -1) {
			System.out.println("所找元素不存在");
		} else {
			System.out.println("所找元素下标为：" + index);
		}
	}
	
	//适用范围：分布比较均匀 数据量大
	public static int insertValueSort(int arr[],int left,int right, int findValue) {
		//防止计算的mid使数组越界，新增两条必须的限制条件，从源头扼杀，直接退出
		if(left>right||findValue<arr[0]||findValue>arr[arr.length-1]) {
			return -1;
		}
		System.out.println("查找");
		//自适应改变
		int mid=left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
		int midValue=arr[mid];
		if(midValue>findValue) {
			return insertValueSort(arr, left, mid-1, findValue);
		}else if(midValue<findValue) {
			return insertValueSort(arr, mid+1, right, findValue);
		}else {
			return mid;
		}
	}
}
