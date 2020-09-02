package com.test;

public class Test0303 {
	private static boolean isFind;
	
	public static void main(String[] args) {
		int[] array= {1,3,5,6};
		int key=0;
		if(isFind) {
			System.out.println("找到，下标为："+search(array, key));
		}else {
			int mid=search(array, key);
			if(array[mid]<key) {
				System.out.println("没找到，插入位置为："+(mid+1));
			}else if(array[mid]>key) {
				System.out.println("没找到，插入位置为："+mid);
			}
		}
		
	}
	
	public static int search(int arr[],int key) {
		int left=0;
		int right=arr.length-1;
		isFind=false;
		int mid=0;
		while(left<=right) {
			mid=(left+right)/2;
			if(arr[mid]>key) {
				right=mid-1;
			}else if(arr[mid]<key) {
				left=mid+1;
			}else {
				isFind=true;
				return mid;
			}
		}
		return mid;
	}
}

