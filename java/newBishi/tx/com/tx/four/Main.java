package com.tx.four;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int r[] = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		System.out.println(solution(n, r, m));
	}
	
	public static int solution(int n,int r[],int m) {
		Arrays.sort(r);
		int res = 0;
		int index = r.length;
		for (int i = 0; i < r.length; i++) {
			res += r[i];
			if(res > m) {
				res -= r[i];
				index = i;
				break;
			}
		}
		if (index == r.length) {
			return res;
		}else {
			res += r[r.length - 1];
		}
		return res;
	}
}
