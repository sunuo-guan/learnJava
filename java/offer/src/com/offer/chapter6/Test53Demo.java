package com.offer.chapter6;

public class Test53Demo {
	public static void main(String[] args) {
		int nums[] = { 0 };
		int target = 1;
		System.out.println(search(nums, target));
		System.out.println(missingNumber(nums));
	}

	/**
	 * 时间复杂度为n，与线性查找一致，可改进
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int left = 0, right = nums.length - 1;
		int index = -1, count = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (target < nums[mid]) {
				right = mid - 1;
			} else if (target > nums[mid]) {
				left = mid + 1;
			} else {
				index = mid;
				count++;
				break;
			}
		}

		if (index == -1) {
			return 0;
		} else {
			int temp = index - 1;
			while (temp >= 0 && nums[temp] == target) {
				count++;
				temp--;
			}
			temp = index + 1;
			while (temp < nums.length && nums[temp] == target) {
				count++;
				temp++;
			}
			return count;
		}
	}

	public static int missingNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0, right = nums.length-1;
		int mid;

		while (right >= left) {
			mid = (left + right) / 2;
			if(nums[mid]!=mid) {
				if(mid==0||nums[mid-1]==mid-1) {
					return mid;
				}else {
					right=mid-1;
				}
			}else {
				left=mid+1;
			}
		}

		if(left==nums.length) {
			return nums.length;
		}
		
		return -1;
	}
}
