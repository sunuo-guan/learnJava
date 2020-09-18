package com.test;

import java.util.*;

public class Test581ShortestUnsortedContinuousSubarray {
	public static void main(String[] args) {

	}

	public int findUnsortedSubarray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int len = nums.length;
		int sortArr[] = nums.clone();

		Arrays.sort(sortArr);
		int headIndex = 0;
		while (headIndex < len && sortArr[headIndex] == nums[headIndex]) {
			headIndex++;
		}
		int tailIndex = len - 1;
		while (tailIndex >= 0 && sortArr[tailIndex] == nums[tailIndex]) {
			tailIndex--;
		}
		return tailIndex - headIndex + 1 > 0 ? tailIndex - headIndex + 1 : 0;
	}

	public int findUnsortedSubarrayWithStack(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int l = nums.length, r = 0;
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				l = Math.min(l, stack.pop());
			}
			stack.push(i);
		}
		stack.clear();
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				r = Math.max(r, stack.pop());
			}
			stack.push(i);
		}

		return r - l + 1 > 0 ? r - l + 1 : 0;
	}
}
