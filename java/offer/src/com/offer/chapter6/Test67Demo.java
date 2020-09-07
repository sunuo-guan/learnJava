package com.offer.chapter6;

public class Test67Demo {
	public static void main(String[] args) {
		String str="words and 987";
		System.out.println(strToInt(str));
	}
	
	public static int strToInt(String str) {
		if(str==null||str.length()==0) {
			return 0;
		}
		
		//��ȥ��ǰ�������
		str=str.trim();
		
		char arr[]=str.toCharArray();
		StringBuilder sb=new StringBuilder();		
		
		if(arr.length==0) {
			//��ʱ�ַ���ȫ�ǿո�
			return 0;
		}else if(arr.length==1) {
			//��ʱ�ַ���ֻ��һ���ַ�������������û�кϷ�����
			if(arr[0]<='9'&&arr[0]>='0') {
				return arr[0]-'0';
			}else {
				return 0;
			}
		}else {
			boolean isNegative=false;  //�жϵ�һ���ַ��Ƿ��Ƿ���λ
			boolean firstSymbol=false;
			
			if(arr[0]=='-') {
				isNegative=true;
				firstSymbol=true;
			}else if(arr[0]=='+') {
				firstSymbol=true;
			}
			
			for (int i = 0; i < arr.length; i++) {
				if(firstSymbol&&i==0) {
					continue;
				}
				
				if(arr[i]<='9'&&arr[i]>='0') {
					sb.append(arr[i]);
				}else {
					break;
				}				
			}
			
			String res=sb.toString();
			int result=0;
			
			for (int i = 0; i <res.length(); i++) {
				result=(res.charAt(i)-'0')+result*10;
			}
			
			if(isNegative) {
				result=-result;
			}
			
			if(result>Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			
			if(result<Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			
			return (int)result;
			
		}
    }
}
