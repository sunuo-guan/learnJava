package com.offer.chapter6;

import java.util.*;

public class Test57Demo {
	public static void main(String[] args) {
		int[] nums= {2,7,11,15};
		int target=9;
		System.out.println(Arrays.toString(twoSum(nums,target)));
		findContinuousSequence(target);
	}
	
	/**
	 * 改变窗口大小求和
	 * @param target
	 * @return
	 */
    public static int[][] findContinuousSequence(int target) {
    	if(target<3) {
    		return new int[0][0];
    	}
    	
    	ArrayList<int []> list=new ArrayList<int[]>();
    	
    	int left=1;
    	int right=2;
    	int sum=left+right;
    	
    	while(left<=(target+1)/2) {
    		if(sum<target) {
    			right++;
    			sum+=right;
    		}else if(sum>target) {
    			sum-=left;
    			left++;
    		}else {
    			int[] temp=new int[right-left+1];
    			for (int i = left,j=0; i <= right; i++,j++) {
					temp[j]=i;
				}
    			list.add(temp);
    			sum-=left;
    			left++;    			
    		}
    	}
    	
    	return list.toArray(new int[list.size()][]);
    	
    }
	
	
	/**
	 * 利用有序的特性，前后双指针扩大或缩小窗口
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length==0) {
			return null;
		}
		
		int result[]=new int[2];
		
		int head=0,end=nums.length-1;   //双指针
		
		while(head<end) {
			int sum=nums[head]+nums[end];
			
			if(sum<target) {
				head++;
			}else if(sum>target) {
				end--;
			}else {
				result[0]=nums[head];
				result[1]=nums[end];
				break;
			}
		}
		
		return result;

    }
	
	
	
	/**
	 * 哈希表解法，没有利用到排好序这个性质
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSumWorse(int[] nums, int target) {
		if(nums==null||nums.length==0) {
			return null;
		}
		
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		int result[]=new int[2];
		
		for (int i = 0; i < nums.length; i++) {
			int diff=target-nums[i];
			if(map.containsKey(nums[i])) {
				result[0]=map.get(nums[i]);
				result[1]=nums[i];
				break;
			}else {
				map.put(diff, nums[i]);
			}
		}
		
		return result;
    }
}
