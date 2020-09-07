package com.meituan2.first;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int cannot(int arr[], int n, int x) {
		if (n == 1)
			return 0;
		Arrays.sort(arr);
		int maxLength = 1;
		int i = 0, j = 1;

		while (i < n && j < n) {
			if (arr[j] - arr[i] <= x) {
				j++;
			} else {
				maxLength = Math.max(maxLength, j - i);
				while (arr[j] - arr[++i] > x)
					;
			}

		}
		return n - maxLength;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int x = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println(cannot(arr, n, x));
	}

}