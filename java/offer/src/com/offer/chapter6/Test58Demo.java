package com.offer.chapter6;

public class Test58Demo {
	public static void main(String[] args) {
		String s="abcdef";
		System.out.println(reverseWords(s));
		System.out.println(reverseLeftWords(s, 2));
	}
	
	/**
	 * �ȷ�ת�����ַ������ٽ��ַ��� ��Ϊ�����֣���length-nΪ��ֱ�ת
	 * @param s
	 * @param n
	 * @return
	 */
	public static String reverseLeftWords(String s, int n) {
		if(s==null||s.length()==0||s.length()<n||n<0) {
			return "";
		}
		
		char[] arr=s.toCharArray();
		reverse(arr, 0, s.length()-1);    //�ȷ�ת��������
		
		//�ٰ����ֱַ�ת
		int start=0,end=s.length()-1-n;
		reverse(arr, start, end);
		
		start=s.length()-n;
		end=s.length()-1;
		reverse(arr, start, end);
		
		return new String(arr);
    }
	
	
	/**
	 * �ȷ�ת�������ӣ��ٷ�תÿ������
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		if(s==null||s.length()==0) {
			return "";
		}
		
		char[] arr=s.toCharArray();
		reverse(arr, 0, s.length()-1);    //�ȷ�ת��������
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
	 * ����str[]���ж���ռ�
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
			if(!str[i].equals("")) {   //	ȥ�������ڵĶ���ո�ע����equals("")������(" ")
				sb.append(str[i]+" ");
			}			
		}
		
		result=sb.toString();
		result=result.trim();
		
		return result;
    }
}
