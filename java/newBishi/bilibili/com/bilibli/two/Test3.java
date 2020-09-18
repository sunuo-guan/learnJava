package com.bilibli.two;

import java.util.*;

public class Test3 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] r = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				r[i][j] = scanner.nextInt();
			}
		}
	}
	
	public int maxProfit (int[] prices) {
        // write code here
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
			dp[i][0][0] = dp[i-1][0][0];
			dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][0][0]-prices[i]);
			dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1]+prices[i]);
			
			dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][1][0]-prices[i]);
			dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][1][1]+prices[i]);
		}
        return Math.max(Math.max(Math.max(dp[len-1][0][0], dp[len-1][0][1]), Math.max(dp[len-1][1][0], dp[len-1][1][1])), dp[len-1][2][0]);
        
    }
}
