package com.datastructrue.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSortDemo {
	public static void main(String[] args) {
		int array[] = { 4, -3, 7, 3, -1 };

		System.out.println("排序前：" + Arrays.toString(array));
		InsertSort(array);
		System.out.println("排序后：" + Arrays.toString(array));
		
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
		
		InsertSort(arr);
		Date date2=new Date();
		String date2Str=simpleDataFormat.format(date2);
		System.out.println("排序后时间"+date2Str);
	}

	public static void InsertSort(int[] arr) {
		// 同数组内 分为有序无序 从无序的第一个元素插入到有序的里面
		int index = 0;          //待插入的前面下标 从此位置一直向前遍历
		int insertValue = 0;
		for (int i = 1; i < arr.length; i++) {
			index = i-1; // 待插入的前面下标
			insertValue = arr[i]; // 待插入的值
			while(index>=0&&insertValue<arr[index]) {
				arr[index+1]=arr[index];
				index--;
			}
			arr[index+1]=insertValue;
			//System.out.println("第" + i + "趟排序结果为：" + Arrays.toString(arr));

		}
	}
}
