package com.datastructrue.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSortDemo {
	public static void main(String[] args) {
		int array[] = { 4, -3, 7, 3, -1, 8, -5, 2, 1 };

		System.out.println("排序前：" + Arrays.toString(array));
		shellSortImprove(array);
		System.out.println("排序后：" + Arrays.toString(array));

		// 测试时间
		int length = 100000;
		int arr[] = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = (int) (Math.random() * length);
		}

		Date date1 = new Date();
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDataFormat.format(date1);
		System.out.println("排序前时间" + date1Str);

		shellSortImprove(arr);
		//shellSort(arr);
		Date date2 = new Date();
		String date2Str = simpleDataFormat.format(date2);
		System.out.println("排序后时间" + date2Str);
	}

	// 交换式
	public static void shellSort(int arr[]) {
		int temp = 0;
		int count = 0;
		for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
			// 选定步长 进行一次分组和排序
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j = j - gap) {
					// 所选的元素与它后面的元素比较和交换 因此起始点为i-gap
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}

			//System.out.println((++count) + "次排序结果为" + Arrays.toString(arr));
		}
	}

	// 分组排序时 使用直接插入排序
	public static void shellSortImprove(int[] arr) {
		// 步长
		int count = 0;
		int index = 0;
		int value = 0;
		for (int gap = arr.length / 2; gap > 0; gap = gap / 2) { // 选定步长 进行一次分组和排序

			for (int i = gap; i < arr.length; i++) { // 每个分组都要进行排序 因此需要i++,且要遍历到数组末尾
				index = i - gap; // 带插入的元素的前一个元素
				value = arr[i]; // 待插入的值
				while (index >= 0 && arr[index] > value) {
					arr[index + gap] = arr[index];
					index = index - gap;
				}
				arr[index + gap] = value;
			}
			//System.out.println((++count) + "次排序结果为" + Arrays.toString(arr));
		}
	}
}
