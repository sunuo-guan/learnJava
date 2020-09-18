package com.four;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n = scanner.nextInt();
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = scanner.nextInt();
		}
		solution(r);
		for (int i = 0; i < n; i++) {
			System.out.print(r[i]+" ");
		}
	}
	public static void solution(int nums[]) {
		
	}
}
