package com.offer.chapter5;

public class Test42Demo {
	private static boolean isInvalid=false;
	public static void main(String[] args) {
		int[] test= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(test));
	}
	
	/**
	 * 动态规划：前面i-1个数之和为负，则maxSum=nums[i]，前面i-1个数之和为正，则maxSum=sum[i-1]+nums
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
		if(nums==null||nums.length==0) {
			isInvalid=true;
			return 0;
		}
		
		int maxSum[]=new int[nums.length];
		maxSum[0]=nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			if(maxSum[i-1]<0) {
				maxSum[i]=nums[i];
			}else {
				maxSum[i]=maxSum[i-1]+nums[i];
			}
		}
		
		int max=maxSum[0];
		for (int i = 0; i < maxSum.length; i++) {
			if(max<maxSum[i]) {
				max=maxSum[i];
			}
		}
		
		return max;
    }
}
