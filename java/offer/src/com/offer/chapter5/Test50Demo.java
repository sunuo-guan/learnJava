package com.offer.chapter5;

import java.util.HashMap;

public class Test50Demo {
	public static void main(String[] args) {
		String s="aaffb";
		System.out.println(firstUniqChar(s));
	}
	
	/**
	 * 有点麻烦了，可以改进
	 * @param s
	 * @return
	 */
	public static char firstUniqChar(String s) {
		if(s==null||s.length()==0) {
			return ' ';
		}
		
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		int sLen=s.length();
		int num[]=new int[sLen];  //出现次数数组，下标为第一次出现的位置，值为出现的次数
		
		for (int i = 0; i < sLen; i++) {
			if(map.containsKey(s.charAt(i))) {
				//若字符串之前含有该字符，则获取第一次出现的下标，并将出现次数加1
				int index=map.get(s.charAt(i));
				num[index]++;
			}else {
				//若字符串之前不含有该字符，则将当前字符和下标放进哈希表中，并将出现次数置1
				map.put(s.charAt(i), i);
				num[i]=1;
			}
		}
		
		int index=0;
		boolean onlyOne=false;
		for (int i = 0; i < sLen; i++) {
			if(num[i]==1) {
				index=i;
				onlyOne=true;
				break;
			}
		}
		
		if(onlyOne) {
			return s.charAt(index);
		}else {
			return ' ';
		}
		
    }
}
