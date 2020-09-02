package com.wangyihuyu.two;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int w[] = new int[n];
		int t[] = new int[n];

		for (int i = 0; i < n; i++) {
			w[i] = scanner.nextInt();
		}

		for (int i = 0; i < n; i++) {
			t[i] = scanner.nextInt();
		}

		int m = scanner.nextInt();

		System.out.println(fenpei(w, t, m, n));

	}

	public static int fenpei(int w[], int t[], int m, int n) {
		Arrays.sort(w);
		Arrays.sort(t);

		int ans = 1;
		int pos = 0;
		for (int i = 0; i < n; i++) {
			if (w[i] < t[i]) {
				ans = 0;
				break;
			}
			while (pos < n && t[pos] <= w[i]) {
				pos++;
			}
			ans = ans * (pos - i) % m;
		}

		return ans;
	}
}
