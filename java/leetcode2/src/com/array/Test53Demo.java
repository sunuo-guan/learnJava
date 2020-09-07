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

        //��̬�滮��dp[]��ʾ�Ե�ǰԪ��Ϊ�ұ�������������
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
        	//��ǰһ������������Ϊ���������ǰһ�������������Ǹ����棬���ܼ�
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
