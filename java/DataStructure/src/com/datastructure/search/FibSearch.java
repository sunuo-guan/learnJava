package com.datastructure.search;

public class FibSearch {

	static int maxSize = 20;

	public static void main(String[] args) {
		int array[] =new int[100];
		for(int i=0;i<array.length;i++) {
			array[i]=i;
		}
		int index = fibSearch(array, 99);
		if (index != -1) {
			System.out.println("待查值索引为" + index);
		} else {
			System.out.println("没有找到");
		}
	}

	// 生成并返回斐波那契数列
	public static int[] fib(int Size) {
		int[] f = new int[Size];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

	public static int fibSearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		int[] f = fib(maxSize); // 构造一个斐波那契数列
		int k = 0; // 斐波那契数列下标
		int mid = 0;
		int temp = 0;

		// 找到最接近的斐波那契数列中的数作为数组扩容后长度
		while (arr.length > f[k]) {
			k++;
		}

		// 创建新数组 扩容 用最后一个数填充新的数组
		int[] arrCopy = new int[f[k]];
		for (int i = 0; i < arrCopy.length; i++) {
			if (i < arr.length) {
				arrCopy[i] = arr[i];
			} else {
				arrCopy[i] = arr[arr.length - 1];
			}
		}

		while (left <= right) {
			// mid选取黄金分割点
			mid = left + f[k - 1] - 1;
			temp = arrCopy[mid];

			if (key < temp) { // 小于mid 向前查找 即f[k-2]部分
				right = mid - 1;
				k--;
			} else if (key > temp) { // 大于mid 向后查找 即f[k-3]部分
				left = mid + 1;
				k = k - 2;
			} else { // 找到 还要区分是否在扩容后的数组尾部
				if (mid >= arr.length) {
					return arr.length - 1;
				} else {
					return mid;
				}
			}
		}

		// 没有找到
		return -1;

	}

}
