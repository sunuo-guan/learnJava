package com.array;

import java.util.*;

public class Test78Demo {
	public static void main(String[] args) {
		Solution78 solution78 = new Solution78();
		int nums[]= {1,2,3};
		solution78.subsets(nums);
	}
}

class Solution78 {
	
	private List<List<Integer>> res=new ArrayList();
	
    public List<List<Integer>> subsets(int[] nums) {
        int len=nums.length;
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < len+1; i++) {
			recur(nums, i, list, 0);
			recur(nums, i, 0, list);
		}
        return res;
    }
    
    private void recur(int[] nums,int i,ArrayList<Integer> list,int start) {
    	if(list.size()==i) {
    		res.add(new ArrayList<Integer>(list));
    		return;
    	}
    	
    	for (int j = start; j < nums.length; j++) {
			list.add(nums[j]);
			recur(nums, i, list,j+1);
			list.remove(list.size()-1);
			
		}
    }
    
    private void recur(int[] nums,int i,int start,ArrayList<Integer> list) {
    	if(list.size()==i) {
    		res.add(new ArrayList<Integer>(list));
    		return;
    	}
    	
    	for (int j = start; j < nums.length; j++) {
			list.add(nums[j]);
			recur(nums, i, list,j+1);
			list.remove(list.size()-1);
			
		}
    }
}
