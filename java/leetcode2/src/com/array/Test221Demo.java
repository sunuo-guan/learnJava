package com.array;

public class Test221Demo {
	public int maximalSquare(char[][] matrix) {
		if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int rows=matrix.length;
		int columns=matrix[0].length;
		
		int dp[][]=new int[rows][columns];
		int res=0;
		for (int i = 0; i < columns; i++) {
			if(matrix[0][i]=='1') {
				dp[0][i]=1;
				res=Math.max(res, dp[0][i]*dp[0][i]);
			}
		}
		
		for (int i = 1; i < rows; i++) {
			if(matrix[i][0]=='1') {
				dp[i][0]=1;
				res=Math.max(res, dp[i][0]*dp[i][0]);
			}
			for (int j = 1; j < columns; j++) {
				if(matrix[i][j]=='1') {
					dp[i][j]=Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
					res=Math.max(res, dp[i][j]*dp[i][j]);
				}
			}
		}
		
		return res;
    }
}
