package com.offer.chapter3;

import java.util.Arrays;

public class Test21Demo {
	public static void main(String[] args) {
		Solution21 solution21 = new Solution21();
		int[] arr= {2,3};
		int[] res=solution21.exchange(arr);
		System.out.println(Arrays.toString(res));
	}
}

class Solution21 {
    public int[] exchange(int[] nums) {
    	if(nums.length==0) {
    		return null;
    	}
    	int left=0;
    	int right=nums.length-1;
    	while(left<=right) {
    		while(left<nums.length&&nums[left]%2==1) {
    			left++;
    		}
    		while(right>=0&&nums[right]%2==0) {
    			right--;
    		}
    		if(left<=right) {
    			int temp=nums[left];
        		nums[left]=nums[right];
        		nums[right]=temp;
    		}   		
    	}
    	return nums;
    }
}
