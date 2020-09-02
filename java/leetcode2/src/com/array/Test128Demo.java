package com.array;

import java.util.HashSet;

public class Test128Demo {
	
	 public int longestConsecutive(int[] nums) {
		 HashSet<Integer> set=new HashSet<Integer>();
		 if(nums==null||nums.length==0) {
			 return 0;
		 }
		 
		 for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		 
		int longest=0;
		for(int num:set) {
			if(!set.contains(num-1)) {
				int length=1;
				int val=num;
				
				while(set.contains(val+1)) {
					val++;
					length++;
				}
				longest=Math.max(length, longest);
			}
		}
		
		return longest;
	 }
}
