package com.tengxun.two;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int type[];
	public static int len=0;
	public static int max=0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		type = new int[n];
		for (int i = 0; i < n; i++) {
			type[i] = scanner.nextInt();
		}
		lujing arr[] = new lujing[m];
		for (int i = 0; i < m; i++) {
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			arr[i] = new lujing(a, b);
		}

		System.out.println(least(arr, n, m));

	}

	public static int least(lujing arr[],int n,int m) {
		Arrays.sort(arr);
		for (int i = 0; i < m; i++) {
			if(arr[i].small==1) {
				len++;
				dfs(arr,i,m,n);
				len--;
			}			
		}	
		return max==0?-1:max;
	}
	
	public static void dfs(lujing arr[],int index,int m,int n) {
		if(arr[index].large==n) {
			max=Math.max(max, len);
			return;
		}
		for (int i = index; i < m; i++) {
			if(arr[i].small==arr[index].large&&arr[i].canGo) {
				len++;
				dfs(arr,i,m,n);
				len--;
			}
		}
	}
	
	public static class lujing implements Comparable<lujing>{
		int large,small;
		boolean canGo=false;
		public lujing(int start,int end) {
			this.large=Math.max(start, end);
			this.small=Math.min(start, end);
			if(type[large-1]!=type[small-1]) {
				canGo=true;
			}
		}
		public int compareTo(lujing temp) {
			if(this.small>temp.small) {
				return 1;
			}else if(this.small==temp.small){
				return 0;
			}else {
				return -1;
			}
		}
	}
}
