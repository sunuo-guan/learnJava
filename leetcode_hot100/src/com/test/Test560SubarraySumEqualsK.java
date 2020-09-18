package com.test;

import java.util.*;

public class Test560SubarraySumEqualsK {
	public static void main(String[] args) {
		int nums[] = {1,1,1};
		int k = 2;
		System.out.println(subarraySum(nums, k));
	}
	
	//循环枚举
	public static int subarraySum2(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
        	int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if(sum == k) {
					res++;
				}
			}
		}
        return res;
    }
	
	//前缀和+map map记录数组的所有前缀和，当map中存在当前 前缀和pre与k的差时，将对应的value加到结果中
	public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int pre = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);        //前缀和为0也要算是存在
        for (int i = 0; i < nums.length; i++) {
			pre += nums[i];
			if(map.containsKey(pre - k)) {
				res += map.get(pre - k);
			}
			map.put(pre, map.getOrDefault(pre, 0)+1);
		}
        return res;
    }
	
	//滑动窗口有问题，不可解
	public static int subarraySumWindow(int[] nums, int k) {
		int left = 0,right = 0,res = 0,sum = 0;
		int len = nums.length;
		
		//有负数情况，right直接滑动出界，结束循环
		while(right < len) {
			sum += nums[right];
			right++;
			while(sum >= k && left < len && left <= right ) {
				if(sum == k) {
					res++;
				}
				sum -= nums[left];
				left++;
			}
		}
		return res;
    }
}
