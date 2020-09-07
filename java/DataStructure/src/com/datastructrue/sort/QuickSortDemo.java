package com.datastructrue.sort;

import java.util.Arrays;

public class QuickSortDemo {
	public static void main(String[] args) {
		int array[] = { 4, -3, 7, 3, -1, 8, -5, 2, 1 };

		System.out.println("排序前：" + Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println("排序后：" + Arrays.toString(array));
	}

	// 取中间的值作为参考点
	public static void quickSort(int arr[], int left, int right) {
		int pivot = arr[(left + right) / 2];
		int l = left;
		int r = right;
		int temp = 0;

		while (l < r) {
			// 左右指针分别找满足条件的值 找到则退出
			while (arr[l] < pivot) {
				l++;
			}
			while (arr[r] > pivot) {
				r--;
			}

			// 若l>=r 此时左右两边都满足条件 退出
			if (l >= r) {
				break;
			}

			// 交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			// 交换之后 发现l r 位置的数等于pivot
			// 则都移动一位
			if (arr[l] == pivot) {
				r--;
			}
			if (arr[r] == pivot) {
				l++;
			}

			// 防止栈溢出
			if (l == r) {
				l++;
				r--;
			}

			if (left < r) {
				quickSort(arr, left, r);

			}
			if (right > l) {
				quickSort(arr, l, right);
			}
		}
	}

	/// 每次以数组第一个作为参考点
	public static void quickSort2(int[] arr, int left, int right) {
		if (left > right) { // 退出 ！！保险起见退出判断都放在第一句！！
			return;
		}

		int l = left; // 数组内的左移动指针
		int r = right; // 数组内的右移动指针

		int temp = 0;

		int value = arr[left]; // ！！这句话必须放在退出判断后面！！ 参考值

		while (r > l) {
			// 以数组第一个作为参考点 先右指针移动后左指针移动
			// 同理，若以数组最后一个作为参考点，则先左指针移动后右指针移动
			while (arr[r] >= value && r > l) {
				r--; // 右指针大于参考值，指针左移；！！且当右等于左时不能再移动！！
			}

			while (arr[l] <= value && r > l) {
				l++; // 左指针值小于参考值，指针右移；！！且当右等于左时不能再移动！！
			}

			if (l < r) { // 还未到相遇点，则左右交换
				temp = arr[r];
				arr[r] = arr[l];
				arr[l] = temp;
			}
		}

		// 参考值与停止点交换
		arr[left] = arr[l];
		arr[l] = value;

		quickSort2(arr, left, r - 1); // 左边递归
		quickSort2(arr, r + 1, right); // 右边递归

	}
}
