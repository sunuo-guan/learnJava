package com.huawei.two;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int r[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				r[i][j] = scanner.nextInt();
			}
		}
		System.out.println(solution(n, m, r));
	}
	
	public static int solution(int n, int m, int[][] r) {
		int nums = n * m;
		int[][] matrix = new int[nums][nums];
		for (int i = 0; i < nums; i++) {
			for (int j = 0; j < nums; j++) {
				matrix[i][j] = 1000000;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(j+1<m && r[i][j] > r[i][j+1]) {
					matrix[m*i + j][m*i + j + 1] = 1;
				}
				if(i+1<n && r[i][j] > r[i+1][j]) {
					matrix[m*i + j][m*(i+1) + j] = 1;
				}
				if(j-1>0 && r[i][j] > r[i][j-1]) {
					matrix[m*i + j][m*i + j-1] = 1;
				}
				if(i-1>0 && r[i][j] > r[i-1][j]) {
					matrix[m*i + j][m*(i-1) + j] = 1;
				}
			}
		}
		
		for (int i = 0; i < nums; i++) {
			for (int j = 0; j < nums; j++) {
				for (int k = 0; k < nums; k++) {
					matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
				}
			}
		}
		
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				res = Math.max(res, matrix[i][j]);
			}
		}
		return res;
	}
}
