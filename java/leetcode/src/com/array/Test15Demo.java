package com.array;

import java.util.*;

public class Test15Demo {
	public static void main(String[] args) {
		int nums[]= {-1, 0, 1, 2, -1, -4};
		threeSum(nums);
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList();
		if(nums==null||nums.length<3){
            return res;
        }
		int len=nums.length;
		Arrays.sort(nums);
		
		for (int i = 0; i < len; i++) {
			if(nums[i]>0) {
				break;
			}
			if(i>0&&nums[i]==nums[i-1]) {
				//È¥³ıÖØ¸´
				continue;
			}
			int left=i+1,right=len-1;
			while(left<right) {
				int sum=nums[i]+nums[left]+nums[right];
				if(sum>0) {
					right--;
				}else if(sum<0) {
					left++;
				}else {
					res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[left],nums[right])));
					while(left<right&&nums[left]==nums[left+1]) {
						left++;
					}
					while(left<right&&nums[right]==nums[right-1]) {
						right--;
					}
					left++;
					right--;
				}
			}			
		}
		
		return res;


    }
}
