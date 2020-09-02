package com.datastructrue.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSortDemo {
	public static void main(String[] args) {
		int array[] = { 4, -3, -1, 3, 7 };

		System.out.println("排序前：");
		System.out.println(Arrays.toString(array));

		BubbleSortImprove(array);

		System.out.println("排序后：");
		System.out.println(Arrays.toString(array));
		
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
		
		BubbleSortImprove(arr);
		Date date2=new Date();
		String date2Str=simpleDataFormat.format(date2);
		System.out.println("排序前时间"+date2Str);
		

	}

	public static void BubbleSort(int[] array) {

		int temp;

		for (int i = 0; i < array.length - 1; i++) {   //i趟数 j元素数

			// for(int j=0;j<array.length-1;j++) { //一直做 不管到不到上一个排好的数字
			for (int j = 0; j < array.length - 1 - i; j++) { // 当做到上一个排好的数字之后则停止 进行下一次循环
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}

			System.out.println("第" + (i + 1) + "趟排序结果为：");
			System.out.println(Arrays.toString(array));
		}
	}

	public static void BubbleSortImprove(int[] array) {

		int temp;
		boolean flag = false; // 若一趟排序没有交换 则直接退出

		for (int i = 0; i < array.length - 1; i++) {

			// for(int j=0;j<array.length-1;j++) { //一直做 不管到不到上一个排好的数字
			for (int j = 0; j < array.length - 1 - i; j++) { // 当做到上一个排好的数字之后则停止 进行下一次循环
				if (array[j] > array[j + 1]) {
					flag = true;
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			
			//System.out.println("第" + (i + 1) + "趟排序结果为：");
			//System.out.println(Arrays.toString(array));
			
			if (!flag) {
				break;
			} else {
				flag = false;
			}


		}
	}
}
