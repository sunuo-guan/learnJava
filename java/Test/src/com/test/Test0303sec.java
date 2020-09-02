package com.test;

public class Test0303sec {
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4};
		System.out.println(maxVal(arr));
	}
	
	public static int maxVal(int val[]) {
		int len=val.length;
		int dp[]=new int[len];
		dp[0]=val[0];
		dp[1]=Math.max(val[0], val[1]);
		for(int i=2;i<len;i++) {
			dp[i]=Math.max(dp[i-1],dp[i-2]+val[i]);
		}
		return dp[len-1];
	}
}
