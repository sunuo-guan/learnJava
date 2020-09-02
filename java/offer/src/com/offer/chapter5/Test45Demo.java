package com.offer.chapter5;

import java.util.Arrays;

public class Test45Demo {
	public static void main(String[] args) {
		int[] nums= {20,1,10};
		System.out.println(minNum(nums));
	}
	
	/**
	 * �ڱȽ������ַ��� S1 �� S2 �Ĵ�Сʱ��Ӧ�ñȽϵ��� S1+S2 �� S2+S1 �Ĵ�С��
	 * ���S1+S2 < S2+S1����ôӦ�ð� S1 ����ǰ�棬����Ӧ�ð� S2 ����ǰ�档
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
		//�����µıȽϴ�С��������
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
