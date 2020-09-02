package com.test;

public class Test416TwoSetSumEqual {
	public static void main(String[] args) {
		int[] nums = {1,2,5};
		System.out.println(canPartition(nums));
	}
	
	//0-1背包问题
    public static boolean canPartition(int[] nums) {
    	if(nums == null||nums.length == 0) {
    		return false;
    	}
    	int sum = 0;
    	for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
    	//如果和为奇数直接输出false
    	if((sum & 1)==1) {
    		return false;
    	}
    	
    	int target = sum / 2;
    	//一维数组，从后向前填，空间复杂度为n
    	boolean dp[] = new boolean[target+1];
    	
    	//先填第0行
    	dp[0] = true;
    	//其余都为false
    	if(nums[0]<=target) {
    		dp[nums[0]] = true;
    	}
    	
    	/*
    	 * i表示nums[i]，j表示和
    	 * 状态转移：dp[i][j] =
    	 * 没有选当前的数：dp[i-1][j]
    	 * 选了当前的数：dp[i-1][j-nums[i]]
    	 * 单独的一个nums[i]构成一个和：true
    	 */
    	for (int i = 1; i < nums.length; i++) {
			for (int j = target; j - nums[i] >= 0; j--) {
				if(dp[target]) {
					return true;
				}
				dp[j] = dp[j] || dp[j-nums[i]];
			}
		}
    	return dp[target];
    }
}
