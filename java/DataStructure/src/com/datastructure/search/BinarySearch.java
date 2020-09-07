package com.datastructure.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int findValue = 5;
		//int index = binarySearch(array, 0, array.length - 1, findValue);
		int index=binarySearchNoRecursion(array, findValue);
		if (index == -1) {
			System.out.println("所找元素不存在");
		} else {
			System.out.println("所找元素下标为：" + index);
		}

		System.out.println("*********");
		int[] array2 = { 1, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9 };
		findValue = 9;
		List<Integer> indexList = new ArrayList<Integer>();
		indexList = binarySearchImprove(array2, 0, array2.length, findValue);
		System.out.println(indexList);

	}

	// 非递归
	public static int binarySearchNoRecursion(int arr[], int key) {
		int left = 0;
		int right = arr.length-1;      //注意边界值
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	// 必须是有序的数组
	public static int binarySearch(int arr[], int left, int right, int findValue) {
		if (left > right) { // 退出递归条件，即找不到数
			return -1;
		}

		int mid = (left + right) / 2;
		int midValue = arr[mid];

		if (findValue > midValue) {
			return binarySearch(arr, mid + 1, right, findValue);
		} else if (findValue < midValue) {
			return binarySearch(arr, left, mid - 1, findValue);
		} else {
			return mid;
		}
	}

	// 可查找多个相同的元素
	public static List<Integer> binarySearchImprove(int arr[], int left, int right, int findValue) {
		if (left > right) { // 退出递归条件，即找不到数
			return new ArrayList<Integer>();
		}

		int mid = (left + right) / 2;
		int midValue = arr[mid];

		if (findValue > midValue) {
			return binarySearchImprove(arr, mid + 1, right, findValue);
		} else if (findValue < midValue) {
			return binarySearchImprove(arr, left, mid - 1, findValue);
		} else {
			// 找到时，向左向右再找
			List<Integer> resList = new ArrayList<Integer>();
			int midIndex = mid - 1;
			while (true) {
				if (midIndex < 0 || arr[midIndex] != findValue) {
					break;
				}
				resList.add(midIndex);
				midIndex--;
			}
			// 中间的值也要加入
			resList.add(mid);

			// 向右
			midIndex = mid + 1;
			while (true) {
				if (midIndex > arr.length - 1 || arr[midIndex] != findValue) {
					break;
				}
				resList.add(midIndex);
				midIndex++;
			}

			return resList;
		}
	}
}
