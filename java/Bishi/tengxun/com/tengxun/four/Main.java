package com.tengxun.four;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int Q = scanner.nextInt();
			long left = 1, right = 1000000000;
			long ans = 0;
			while (right >= left) {
				long mid = (left + right) >> 1;
				if (sum(mid) == Q) {
					ans = mid;
					right = mid - 1;
				} else if (sum(mid) > Q)
					right = mid - 1;
				else
					left = mid + 1;
			}
			if (ans > 0)
				System.out.println(ans);
			else
				System.out.println("No solution");

			T--;
		}
	}

	public static long sum(long n) {
		long ans = 0;
		while (n > 0) {
			ans += n / 5;
			n /= 5;
		}
		return ans;
	}
}
