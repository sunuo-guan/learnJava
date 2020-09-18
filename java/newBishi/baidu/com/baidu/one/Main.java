package com.baidu.one;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(solution(str));
	}
	
	public static String solution(String str) {
		if(str == null) {
			return str;
		}
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		int slow = 0, fast = slow + 1;
		while(fast < len) {
			sb.append(str.charAt(slow));
			while(fast < len && str.charAt(slow) == str.charAt(fast)) {
				fast++;
			}
			slow = fast;
		}
		return sb.toString();
	}
}
