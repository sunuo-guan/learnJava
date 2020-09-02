package com.offer.chapter6;

public class Test58Demo {
	public static void main(String[] args) {
		String s="abcdef";
		System.out.println(reverseWords(s));
		System.out.println(reverseLeftWords(s, 2));
	}
	
	/**
	 * 先反转整个字符串，再将字符串 分为两部分，以length-n为界分别反转
	 * @param s
	 * @param n
	 * @return
	 */
	public static String reverseLeftWords(String s, int n) {
		if(s==null||s.length()==0||s.length()<n||n<0) {
			return "";
		}
		
		char[] arr=s.toCharArray();
		reverse(arr, 0, s.length()-1);    //先反转整个句子
		
		//再按部分分别反转
		int start=0,end=s.length()-1-n;
		reverse(arr, start, end);
		
		start=s.length()-n;
		end=s.length()-1;
		reverse(arr, start, end);
		
		return new String(arr);
    }
	
	
	/**
	 * 先反转整个句子，再翻转每个单词
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		if(s==null||s.length()==0) {
			return "";
		}
		
		char[] arr=s.toCharArray();
		reverse(arr, 0, s.length()-1);    //先反转整个句子
		int start=0,end=0;
		
		while(end<=s.length()) {
			if(end==s.length()||arr[end]==' ') {
				reverse(arr, start, end-1);
				while(end!=s.length()&&arr[end]==' ') {
					end++;
				}
				start=end;
			}
			end++;
		}
		
		return new String(arr);
		
    }
	
	private static void reverse(char arr[],int start,int end) {
		while(start<end) {
			char temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;			
		}
	}
	
	/**
	 * 利用str[]，有额外空间
	 * @param s
	 * @return
	 */
	public static String reverseWords2(String s) {
		if(s==null||s.length()==0) {
			return "";
		}
		String result;
		StringBuffer sb=new StringBuffer();
		
		String str[]=s.split(" ");
		
		for (int i = str.length-1; i >= 0; i--) {
			if(!str[i].equals("")) {   //	去除句子内的多余空格，注意是equals("")而不是(" ")
				sb.append(str[i]+" ");
			}			
		}
		
		result=sb.toString();
		result=result.trim();
		
		return result;
    }
}
