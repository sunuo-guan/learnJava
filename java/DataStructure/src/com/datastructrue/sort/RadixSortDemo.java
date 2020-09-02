package com.datastructrue.sort;

import java.util.Arrays;

public class RadixSortDemo {
	public static void main(String[] args) {
		int array[] = { 409, 323, 37, 3554, 13, 8, 543, 26, 1 };      //负数会失效
		System.out.println("排序前：" + Arrays.toString(array));
		radixSort(array);
		System.out.println("排序后：" + Arrays.toString(array));
	}

	// 桶排序 10个桶（二维数组） 一个一维数组记录每个桶每次存了多少个数
	public static void radixSort(int[] arr) {
		// 先找到最大的位数 则得到需要排序多少次
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		// 最大位数
		int maxLength = (max + "").length();

		// 创建十个桶（二维数组）
		int bucket[][] = new int[10][arr.length];
		// 记录桶内多少个数
		int bucketRecord[] = new int[10];

		// 最大位数的次数的循环
		int n = 1; // 控制每轮排序的取位
		for (int i = 0; i < maxLength; i++) {
			// 分别放进桶里
			// for (int j = 0, n = 1; j < arr.length; j++, n = n * 10) {！！错误 这样每放到桶里一次就增一个位
			for (int j = 0; j < arr.length; j++) {
				int temp = arr[j] / n % 10; // 取对应的位数
				bucket[temp][bucketRecord[temp]] = arr[j]; // 放到桶里面
				bucketRecord[temp]++; // 记录自增
			}

			// 都放入后，按桶的顺序输出
			int index = 0;
			for (int j = 0; j < bucketRecord.length; j++) {
				if (bucketRecord[j] != 0) { // 不等于0 表示桶内有数据
					for (int j2 = 0; j2 < bucketRecord[j]; j2++) {
						arr[index] = bucket[j][j2]; // 按桶的顺序输出到数组中
						index++;
					}
				}
			}

			// 一切结束后，还要清除掉数据
			for (int j = 0; j < bucketRecord.length; j++) {
				bucketRecord[j] = 0;
			}
			n = n * 10; // ！！不能忘记
		}

	}
}
