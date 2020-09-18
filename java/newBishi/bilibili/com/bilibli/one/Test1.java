package com.bilibli.one;

import java.util.*;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String arr = scanner.nextLine();
		String[] strArr = arr.split(" ");
		int n = strArr.length;
		int[] r = new int[n];
		for (int i = 0; i < r.length; i++) {
			r[i] = Integer.parseInt(strArr[i]);
		}
		System.out.println(maxWeight(r));
	}
	
	public static int maxWeight(int nums[]) {
		int res = 0;
		int len = nums.length;
		int weight[] = new int[len];
		if (len==1) {
			return 1;
		}
		if (nums[0] > nums[1]) {
			weight[0] = 2;
		} else {
			weight[0] = 1;
		}
		for (int i = 1; i < len - 1; i++) {
			if (nums[i-1]>=nums[i]&&nums[i+1]>=nums[i]) {
				weight[i] = 1;
			} else if(nums[i-1]>nums[i]&&nums[i+1]<nums[i]){
				if (weight[i-1] == 1) {
					for (int j = 0; j < i; j++) {
						weight[j]++;
					}
				}
				weight[i] = weight[i-1] - 1;
			} else {
				weight[i] = weight[i-1] + 1;
			}
		}
		if (nums[len - 1] > nums[len - 2]) {
			weight[len - 1] = weight[len - 2]+1;
		} else {
			weight[len - 1] = 1;
		}
		for (int i = 0; i < weight.length; i++) {
			res += weight[i];
		}
		return res;
	}
}
