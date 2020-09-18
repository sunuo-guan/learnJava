package com.test;

import java.util.*;

public class Test448DisappearedNumbersInArray {
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		findDisappearedNumbersBest(nums);
	}
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
        for (int i = 1; i <= nums.length; i++) {
			if (!set.contains(i)) {
				result.add(i);
			}
		}
        return result;
    }
    
    //原地修改数组：遍历一次数组，将得到的元素的绝对值-1作为下标，将该下标的元素置为负数，结束一次遍历后，元素为正数的下标值+1为不存在数组中的元素值
    public static List<Integer> findDisappearedNumbersBest(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
			nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
		}
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]>0) {
				result.add(i+1);
			}
		}
        return result;
    }
}
