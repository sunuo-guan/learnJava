package com.baidu.two;

import java.util.*;

public class Main {	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] r = new int[n][n];
		String str[] = new String[n];
		scanner.nextLine();
		for (int i = 0; i < str.length; i++) {
			str[i] = scanner.nextLine();
		}
		for (int i = 0; i < n; i++) {
			char temp[] = str[i].toCharArray();
			for (int j = 0; j < r.length; j++) {
				r[i][j] = temp[j] - '0';
			}
		}
		int[][] res = solution(r, n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < r.length; j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[][] solution(int[][] arr, int n){
		for (int i = 0; i < n; i++) {
			dfs(arr, i, 0, n);
			dfs(arr, i, n-1, n);
		}
		for (int i = 1; i < n - 1; i++) {
			dfs(arr, 0, i, n);
			dfs(arr, n-1, i, n);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == 2) {
					arr[i][j] = 0;
				} else if(arr[i][j] == 0) {
					arr[i][j] = 1;
				}
			}
		}
		return arr;
	}
	
	public static void dfs(int arr[][], int x, int y, int n) {
		if(x < 0 || x >= n || y < 0 || y >= n || arr[x][y] != 0) {
			return;
		}
		arr[x][y] = 2;
		dfs(arr, x+1, y, n);
		dfs(arr, x-1, y, n);
		dfs(arr, x, y-1, n);
		dfs(arr, x, y+1, n);
	}
}
