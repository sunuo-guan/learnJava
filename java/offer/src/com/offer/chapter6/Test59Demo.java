package com.offer.chapter6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test59Demo {
	public static void main(String[] args) {
		int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		Solution59 solution59 = new Solution59();
		System.out.println(Arrays.toString(solution59.maxSlidingWindow(arr, k)));
	}

}

class Solution59 {
	private ArrayDeque<Integer> queue = new ArrayDeque<Integer>(); // 双向队列，队头为最大值，存储下标
	private int arr[];

	public int[] maxSlidingWindow(int[] nums, int k) {
		// 用大顶堆可以很快解决
		if (nums == null || nums.length == 0 || k == 0) {
			return new int[0];
		}
		if (k == 1) {
			return nums;
		}
		arr = nums; // 赋值
		int len = nums.length;
		int res[] = new int[len - k + 1];

		// 初始化
		for (int i = 0; i < k; i++) {
			queueAdd(i, k);
		}
		res[0] = nums[queue.getFirst()];

		// 不断添加
		for (int i = k; i < len; i++) {
			queueAdd(i, k);
			res[i - k + 1] = nums[queue.getFirst()];
		}

		return res;

	}

	private void queueAdd(int i, int k) {
		// 若队满了则直接先出队头
		if (!queue.isEmpty() && queue.getFirst() == i - k) {
			queue.removeFirst();
		}

		// 新进入窗口值一直与队尾比较，若比队尾大则队尾出队，继续比较
		while (!queue.isEmpty() && arr[i] > arr[queue.getLast()]) {
			queue.removeLast();
		}

		queue.addLast(i);
	}
}

class MaxQueue {
	private LinkedList<Integer> max; // 双向队列，存放加入队列的最大值
	private Queue<Integer> queue;

	public MaxQueue() {
		max = new LinkedList<Integer>();
		queue = new LinkedList<Integer>();
	}

	public int max_value() {
		if(max.isEmpty()) {
			return -1;
		}else {
			return max.getLast();
		}
	}

	public void push_back(int value) {
		queue.add(value);
		
		if (max.isEmpty()) {
			max.add(value);
		} else {
			if (max.getLast() < value) {
				max.addLast(value);
			} else {
				max.addLast(max.getLast());
			}
		}
	}

	public int pop_front() {
		if(queue.isEmpty()) {
			return -1;
		}else {
			max.removeFirst();
			return queue.remove();
		}
	}
}
