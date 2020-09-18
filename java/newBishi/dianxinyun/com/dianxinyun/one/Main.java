package com.dianxinyun.one;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(solution(str));
	}
	
	public static String solution(String str) {
		int[] strNums = new int[26];
		int len = str.length();
		for (int i = 0; i < len; i++) {
			strNums[str.charAt(i) - 'a']++;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if(strNums[i] > 0)
				min = Math.min(strNums[i], min);
		}
		boolean isMin[] = new boolean[26];
		for (int i = 0; i < 26; i++) {
			isMin[i] = min == strNums[i]?true:false;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			if(!isMin[str.charAt(i) - 'a'])
				sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
