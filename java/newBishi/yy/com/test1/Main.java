package com.test1;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str = scanner.next();
		System.out.println(encode(str));
	}
	
	public static String encode(String str) {
		int len = str.length();
		String dp[][] = new String[len][len];
		for(int x = 0;x<len;x++) {
			for (int i = 0; i < len - x; i++) {
				int j = i + x;
				String sub = str.substring(i, j+1);
				dp[i][j] = sub;
				if (j - i < 4) {
					continue;
				}
				for (int k = i; k < j; k++) {
					if (dp[i][k].length() + dp[k+1][j].length() < dp[i][j].length()) {
						dp[i][j] = dp[i][k] + dp[k+1][j];
					}
				}
				for (int k = 0; k < sub.length(); k++) {
					String repeat = sub.substring(0, k+1);
					if (repeat !=null && sub.length() % repeat.length() == 0 && sub.replaceAll(repeat, "").length() == 0) {
						String res = sub.length() /repeat.length() + "(" + dp[i][i+k] + ")";
						if (res.length() < dp[i][j].length()) {
							dp[i][j] = res;
						}
					}
				}
			}
		}
		String r = dp[0][str.length() - 1];
		String result = "2(aabc)1(d)3(a)1(d)";
		return r;
	}
}
