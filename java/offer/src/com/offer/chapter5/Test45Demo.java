package com.offer.chapter5;

import java.util.Arrays;

public class Test45Demo {
	public static void main(String[] args) {
		int[] nums= {20,1,10};
		System.out.println(minNum(nums));
	}
	
	/**
	 * 在比较两个字符串 S1 和 S2 的大小时，应该比较的是 S1+S2 和 S2+S1 的大小，
	 * 如果S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
	 * @param nums
	 * @return
	 */
	public static String minNum(int nums[]) {
		if(nums==null||nums.length==0) {
			return "";
		}
		
		int len=nums.length;
		String str[]=new String[len];
		for (int i = 0; i < len; i++) {
			str[i]=nums[i]+"";
		}
		//定义新的比较大小规则并排序
		Arrays.sort(str,(x,y)->(x+y).compareTo(y+x));
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < len; i++) {
			builder.append(str[i]);
		}
		return builder.toString();
	}
	
	public static String minNum2(int nums[]) {
		if(nums==null||nums.length==0) {
			return "";
		}
		
		int len=nums.length;
		String str="";
		for (int i = 0; i < len; i++) {
			str=str+nums[i]+"";
		}
		
		char[] chars=str.toCharArray();
		Arrays.sort(chars);
		
		StringBuilder builder = new StringBuilder();
		
		int index=0;
		while(chars[index]=='0') {
			index++;
		}
		builder.append(chars[index]);
		
		for (int i = 0; i < chars.length; i++) {
			if(i==index) {
				continue;
			}else {
				builder.append(chars[i]);
			}
		}
		
		String res=builder.toString();
		return res;
	}
}
