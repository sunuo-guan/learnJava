package com.offer.chapter2;

import java.util.ArrayList;

public class Test5Demo {
	public static void main(String[] args) {
		Solution solution=new Solution();
		String s = "we are happy";
		System.out.println(solution.replaceSpace(s));
	}	
}

class Solution {

	public String replaceSpace(String s) {
		int len = s.length();
		ArrayList<String> str = new ArrayList<String>();
//		ArrayList<Integer> index = new ArrayList<Integer>();
//		int k=0;
		for (int i = 0; i < len; i++) {
			String a = s.substring(i, i + 1);
			str.add(a);
		}
		System.out.println(str);

		String tempStr = "%20";
		String temp;
		String result = "";
		for (int i = 0; i < str.size(); i++) {
			temp = str.get(i);
			if (temp.equals(" ")) {
				result = result + tempStr;
			} else {
				result = result + temp;
			}
		}
		return result;

	}
}
