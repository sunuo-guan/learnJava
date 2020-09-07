package com.zhaohang.one;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long arr[][] = new long[n][n];
		for (int i = 0; i < n; i++) {
			int len = i + 1;
			for (int j = 0; j < len; j++) {
				arr[i][j] = scanner.nextLong();
			}
		}
		System.out.println(max(arr, n));
	}

	public static long max(long arr[][], int n) {
		long res = 0;
		long dp[][] = new long[n][n];
		dp[0][0] = arr[0][0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j - 1 >= 0) {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i - 1][j]) + arr[i][j];
				}else {
					dp[i][j]=dp[i-1][j]+arr[i][j];
				}
				
			}
		}

		for (int i = 0; i < n; i++) {
			res = Math.max(dp[n - 1][i], res);
		}

		return res;
	}
}