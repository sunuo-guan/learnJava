package com.bilibli.three;

import java.util.*;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] r = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				r[i][j] = scanner.nextInt();
			}
		}
		System.out.println(minPathSum(r));
	}
	
	public static int minPathSum (int[][] grid) {
        // write code here
		int len = grid[0].length;
		int[] dp = new int[len];
		dp[0] = grid[0][0];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i-1] +  grid[0][i];
		}
		for (int i = 1; i < grid.length; i++) {
			dp[0] = dp[0] + grid[i][0];
			for (int j = 1; j < len; j++) {
				dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
			}
		}
		return dp[len-1];
    }
}
