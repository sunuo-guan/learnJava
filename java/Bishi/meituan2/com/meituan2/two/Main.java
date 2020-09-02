package com.meituan2.two;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long m = in.nextLong();
		long[] a = new long[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			sum += a[i];
		}
		
		long ans = (m / sum) * n;
		m = m % sum;
		if (m > 0) {
			for (int i = 0; i < n; i++) {
				if (a[i] <= m) {
					ans++;
					m -= a[i];
				}
			}
		}
		System.out.print(ans);
	}
}