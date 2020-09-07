package com.offer.chapter5;

public class Test51Demo {
	public static void main(String[] args) {
		Solution51 solution51 = new Solution51();
		int nums[] = { 4,5,6,7};
		System.out.println(solution51.reversePairs(nums));
	}

}

class Solution51 {
	private long count = 0;
	private int[] temp;

	public int reversePairs(int[] nums) {
		temp = new int[nums.length];
		mergeSort(0, nums.length - 1, nums);
		return (int) count;
	}

	private void mergeSort(int left, int right, int nums[]) {
		if (right <= left) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(left, mid, nums);
		mergeSort(mid + 1, right, nums);
		merge(left, right, mid, nums);
	}

	private void merge(int left, int right, int mid, int nums[]) {
		int l = mid; // 指向最后
		int r = right;
		int t = right; // 辅助数组指针

		while (l >= left && r >= mid + 1) {
			if (nums[l] > nums[r]) {
				temp[t] = nums[l];
				//统计逆序对数，若左边数组的当前数大于右边数组当前数，
				//那么从右边数组当前数一直到右边数组的左边界都是逆序对
				count = count + r - mid;   
				l--;
				t--;
			} else {
				temp[t] = nums[r];
				r--;
				t--;
			}
		}

		// 将其中一个数组剩余的数全都拷贝进辅助数组中
		while (l >= left) {
			temp[t] = nums[l];
			l--;
			t--;
		}

		while (r >= mid + 1) {
			temp[t] = nums[r];
			r--;
			t--;
		}

		//将辅助数组的数拷贝进原数组中，从后到前
		int tempStart = right; // 辅助数组对应在原数组的位置
		t = right;
		while (tempStart >= left) {
			// 拷贝进相对应的位置
			nums[tempStart] = temp[t];
			tempStart--;
			t--;
		}

	}
}
