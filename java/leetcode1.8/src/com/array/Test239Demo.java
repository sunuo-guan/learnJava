package com.array;

import java.util.*;

public class Test239Demo {
	public static void main(String[] args) {
		int nums[]= {1,3,-1,-3,5,3,6,7};
		int k=3;
		int ans[]=maxSlidingWindow(nums, k);
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null||nums.length==0)
			return nums;
		
		int lenOfAns=nums.length-k+1;
		int ans[]=new int[lenOfAns];
		
		
		//队列存放下标，可以解决判断是否队头应当出列的问题
		LinkedList<Integer> queue=new LinkedList<Integer>();
		
		for (int i = 0; i < k-1; i++) {
			queueAdd(queue, i, k,nums);
		}
		
		for (int i = k-1; i < nums.length; i++) {
			queueAdd(queue, i, k,nums);
			ans[i-k+1]=nums[queue.get(0)];
		}
		
		return ans;
    }
	
	public static void queueAdd(LinkedList<Integer> queue,int temp,int k,int nums[]) {
		if(!queue.isEmpty()&&temp-queue.get(0)==k) {
			queue.removeFirst();
		}
		
		if(queue.isEmpty()) {
			queue.addLast(temp);
		}else {
			while(!queue.isEmpty()&&nums[queue.get(queue.size()-1)]<nums[temp]) {
				queue.removeLast();
			}
			queue.addLast(temp);
		}
	}
}
