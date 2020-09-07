package com.array;

public class Test53Demo {
	public static void main(String[] args) {
		int nums[]= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	
	public static int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }

        //动态规划：dp[]表示以当前元素为右标的子数组的最大和
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
        	//若前一个子数组最大和为负，则加上前一个子数组最大和是负增益，不能加
            if(dp[i-1]<=0){
                dp[i]=nums[i];
            }else{
                dp[i]=dp[i-1]+nums[i];
            }
            maxSum=Math.max(maxSum,dp[i]);
        }
        return maxSum;

    }
}
