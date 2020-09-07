package com.offer.chapter6;

import java.util.Arrays;

public class Test61Demo {
	public static void main(String[] args) {
		int nums[]= {1,2,3,4,5};
		System.out.println(isStraight(nums));
	}
	
	public static boolean isStraight(int[] nums) {
		if(nums==null||nums.length!=5) {
			return false;
		}
		
		boolean isStra=false;
		
		//对数组排序
		Arrays.sort(nums);
		
		//记录王的数量
		int numOfKing=0;
		
		//记录空缺数
		int numOfLack=0;
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0) {
				numOfKing++;
				continue;
			}
			
			if(i>0&&nums[i]!=0&&nums[i]==nums[i-1]) {
				return false;
			}
			
			if(i>0&&nums[i-1]!=0) {
				numOfLack+=nums[i]-nums[i-1]-1;
			}
		}
		
		
		if(numOfKing>=numOfLack) {
			isStra=true;
		}
		
		return isStra;
		
    }
}
