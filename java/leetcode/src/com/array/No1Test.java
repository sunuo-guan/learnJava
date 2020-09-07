package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class No1Test {
	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		Solution solution = new Solution();
		int[] result = solution.twoSum(nums, target);
		System.out.println(Arrays.toString(result));
		String s = "we are happy";
		System.out.println(solution.replaceSpace(s));
		String ss = " ";
		if (ss == " ") {
			System.out.println("hhh");
		}
	}
}

class Solution {
	public int[] twoSum(int[] nums, int target) {

		// 暴力
//        for(int right=nums.length-1;right>0;right--){
//            for(int left=right-1;left>=0;left--){
//                if(nums[left]+nums[right]==target){
//                    int[] correct=new int[2];
//                    correct[0]=left;
//                    correct[1]=right;
//                    return correct;
//                }
//            }
//        }
//        return null;

		// 求差值，若当前hashmap不存在则key=arr【i】，value=i
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = { -1, -1 };
		for (int i = 0; i < nums.length; i++) {
			int error = target - nums[i];
			boolean isExist = map.containsKey(error);
			if (isExist == false) {
				map.put(nums[i], i);
			} else {
				res[0] = map.get(error);
				res[1] = i;
				return res;
			}
		}
		return res;
	}

	public String replaceSpace(String s) {
		int len = s.length();
		ArrayList<String> str = new ArrayList<String>();
//		ArrayList<Integer> index = new ArrayList<Integer>();
//		int k=0;
		for (int i = 0; i < len; i++) {
			String a = s.substring(i, i + 1);
			str.add(a);
		}
		System.out.println(str);

		String tempStr = "%20";
		String temp;
		String result = "";
		for (int i = 0; i < str.size(); i++) {
			temp = str.get(i);
			if (temp.equals(" ")) {
				result = result + tempStr;
			} else {
				result = result + temp;
			}
		}
		return result;

	}
}