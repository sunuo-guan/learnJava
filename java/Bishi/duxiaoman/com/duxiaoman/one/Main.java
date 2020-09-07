package com.duxiaoman.one;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextInt();
		long m = scanner.nextInt();
		System.out.println(least(n, m));
	}

	public static long least(long n, long m) {
		if (n == 1) {
			if (m <= 2) {
				return m;
			} else {
				return (m - 1) * 2;
			}
		} else if (m == 1) {
			if (n <= 2) {
				return n;
			} else {
				return (n - 1) * 2;
			}
		} else if (n % 2 == 0 || m % 2 == 0) {
			return n*m;
		} else {
			return n * m + 1;
		}
	}
}
