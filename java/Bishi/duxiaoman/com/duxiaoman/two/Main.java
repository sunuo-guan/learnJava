package com.duxiaoman.two;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println(sum(n, m, a, b));
	}
	
	public static int sum(int n,int m,int a,int b) {
		int arr[][]=new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j]=(i+1)*(j+1)%10;
			}
		}
		
		int sum=0;
		for (int i = 0; i <= n-a; i++) {
			for (int j = 0; j <= m-b; j++) {
				int max=0;
				for (int k = i; k < i+a; k++) {
					for (int k2 = j; k2 < j+b; k2++) {
						max=Math.max(max, arr[k][k2]);
					}
				}
				sum+=max;
			}
			
		}
		
		return sum;
	}
}
