package com.tree;

public class Test96Demo {
	public static void main(String[] args) {
		
	}
	
	//��̬�滮
	public static int numTrees(int n) {
		int dp[]=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		
		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j < i+1; j++) {
				dp[i]=dp[i]+dp[j-1]*dp[i-j];
			}
		}
		
		return dp[n];
    }
}