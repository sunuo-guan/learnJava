package com.test;

public class Test647PalindromicSubstrings {
	public static void main(String[] args) {
		
	}
	
	//动态规划
	public int countSubstrings1(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		for (int j = 0; j < len; j++) {
			for (int i = 0; i <= j; i++) {
				if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					res++;
				}
			}
		}
		
		return res;
    }
	
	//中心扩展
	public int countSubstrings2(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		//中心点：1个字符和2个字符，总共len*2-1个
		for(int center = 0;center < s.length() * 2 - 1;center++) {
			//确定左右指针的位置,center为奇数时中心为一个字符，为偶数时中心为两个字符
			int left = center / 2;
			int right = left + center % 2;
			while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				res++;
				left--;
				right++;
			}
		}
		
		return res;
    }
}
