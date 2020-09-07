package com.datastructrue.sort;

import java.util.Arrays;

public class MergeSortDemo {
	public static void main(String[] args) {
		int array[] = { 4, -3, 7, 3, -1, 8, -5, 2, 1 };
		int temp[]=new int[array.length];
		System.out.println("排序前：" + Arrays.toString(array));
		mergeSort(array, 0, array.length - 1,temp);
		System.out.println("排序后：" + Arrays.toString(array));
	}
	
	
	/**
	 * 归并排序：先分成小分后合并成大分
	 */

	public static void mergeSort(int arr[],int left,int right, int temp[]) {
		if(left<right) {       //退出递归的条件 当left>=right时，只剩下一个
			int mid=(left+right)/2;     //分解实际上是将left、right、mid赋予不同的下标值
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid+1, right, temp);
			merge(arr, left, right, mid, temp);
		}
		//倒数第二层递归:left=0 right=1 mid=0 两次调用到倒数第一层mergeSort都直接退出 然后执行merge 
		
	}
	
	public static void merge(int arr[], int left, int right, int mid, int temp[]) {

		int l = left;
		int r = mid + 1;
		int t = 0; // 辅助数组指针

		// 1。比较两个待合并数组的值，小的就先移到一个辅助数组中
		// 直到其中一个待合并数组全部移动结束
		while (l <= mid && r <= right) {
			if (arr[l] <= arr[r]) {
				temp[t] = arr[l];
				l++;
				t++;
			} else {
				temp[t]=arr[r];
				r++;
				t++;
			}
		}
		
		//2.将其中一个数组剩余的数全都拷贝进辅助数组中
		while(l<=mid) {
			temp[t] = arr[l];
			l++;
			t++;
		}
		
		while(r<=right) {
			temp[t]=arr[r];
			r++;
			t++;
		}
		
		//3.将辅助数组的数拷贝进原数组中
		int tempStart=left;   //辅助数组对应在原数组的位置
		t=0;
		while(tempStart<=right) {
			//拷贝进相对应的位置
			arr[tempStart]=temp[t];
			tempStart++;
			t++;
		}
		
	}
}
