package com.array;

import java.util.*;

public class Test215Demo {
	public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
	
	//建一个小顶堆
	public int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			heap.add(nums[i]);
			if(heap.size()>k) {
				heap.poll();
			}
		}
		
		return heap.peek();
    }
	
	//快速选择算法
	public int findKthLargest3(int[] nums, int k) {
       return quickSelect(0, nums.length-1, nums.length-k, nums);
    }
	
	private void swap(int nums[],int a,int b) {
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}
	
	private int position(int left,int right,int index,int nums[]) {
		int val=nums[index];
		
		swap(nums, right, index);
		int store=left;
		
		for (int i = left; i <= right; i++) {
			if(nums[i]<val) {
				swap(nums, store, i);
				store++;
			}
		}
		
		swap(nums, store, right);
		
		return store;
	}
	
	private int quickSelect(int left,int right,int ksmall,int nums[]) {
		if(left==right) {
			return nums[left];
		}
		
		Random random=new Random();
		int index=left+random.nextInt(right-left);
		
		index=position(left, right, index, nums);
		
		if(ksmall==index) {
			return nums[index];
		}else if(ksmall<index) {
			return quickSelect(left, index-1, ksmall, nums);
		}else {
			return quickSelect(index+1, right, ksmall, nums);
		}
	}
}
