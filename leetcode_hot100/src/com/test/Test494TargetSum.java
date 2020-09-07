package com.test;

public class Test494TargetSum {
	public static void main(String[] args) {
		int nums[] = {0,0,0,0,0,0,0,0, 1};
		//int nums[] = {1,1,1,1,1};
		int S = 1;
		System.out.println(findTargetSumWays(nums, S));
	}
	
	//背包问题
    public static int findTargetSumWays(int[] nums, int S) {
    	int sum = 0;
    	for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
		}
    	
    	if(Math.abs(sum)<S) {
    		return 0;
    	}
    	
    	//数组偏移量
    	int delta = sum;
    	
    	int dp[][] = new int[nums.length][2*delta+1];
    	dp[0][nums[0]+delta] += 1;
    	dp[0][-nums[0]+delta] += 1;
    	
    	//状态转移方程：dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
    	for (int i = 1; i < nums.length; i++) {
			for (int j = -sum; j <= sum; j++) {
				//边界条件：-sum<=j-nums[i]<=sum, -sum<=j+nums[i]<=sum
				//不能合在一起写边界条件，因为某种时候可能只有一种情况满足要求
//				if(j+nums[i]>=-sum&&j+nums[i]<=sum&&j-nums[i]>=-sum&&j-nums[i]<=sum) {
//					dp[i][j+delta] = dp[i-1][j-nums[i]+delta]+dp[i-1][j+nums[i]+delta];
//				}
				if(j+nums[i]>=-sum&&j+nums[i]<=sum) {
					dp[i][j+delta] += dp[i-1][j+nums[i]+delta];
				}
				if(j-nums[i]>=-sum&&j-nums[i]<=sum) {
					dp[i][j+delta] += dp[i-1][j-nums[i]+delta];
				}
			}
		}
    	return dp[nums.length-1][S+delta];
    }
}
