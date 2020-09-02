package com.datastructrue.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSortDemo {
	public static void main(String[] args) {
		int array[] = { 4, -3, 7, 3, -1 };
		
		System.out.println("排序前："+Arrays.toString(array));
		SelectSort(array);
		System.out.println("排序后："+Arrays.toString(array));
		
		//测试时间
		int length=100000;
		int arr[]=new int[length];
		for(int i=0;i<length;i++) {
			arr[i]=(int)(Math.random()*length);
		}
		
		Date date1=new Date();
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str=simpleDataFormat.format(date1);
		System.out.println("排序前时间"+date1Str);
		
		SelectSort(arr);
		Date date2=new Date();
		String date2Str=simpleDataFormat.format(date2);
		System.out.println("排序后时间"+date2Str);
		
	}

	public static void SelectSort(int[] arr) {
		// 先遍历找最小值 再与头交换
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			int min = arr[minIndex];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}
			}
			arr[minIndex] = arr[i];
			arr[i] = min;
		}
	}
	

}
