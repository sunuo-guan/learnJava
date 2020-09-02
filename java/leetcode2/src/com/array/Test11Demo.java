package com.array;

public class Test11Demo {
	public static void main(String[] args) {
		int height[]= {1,2,3,1,3,5,8,7};
		System.out.println(maxArea(height));
	}

	/*
	 * ˫ָ�뷨
	 */
	public static int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}

		int left = 0, right = height.length - 1, max = 0;

		while (left < right) {
			int minSide = height[left] > height[right] ? height[right] : height[left];
			int area = (right - left) * minSide;
			max = area > max ? area : max;
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}

		return max;
	}
}
