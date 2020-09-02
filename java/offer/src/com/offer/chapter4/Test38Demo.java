package com.offer.chapter4;

import java.util.ArrayList;
import java.util.Arrays;

public class Test38Demo {
	public static void main(String[] args) {
		String test="dklsuyez";
		Solution38 solution38 = new Solution38();
		String res[]=solution38.permutation(test);
		System.out.println(Arrays.toString(res));
	}
}

class Solution38 {
	private ArrayList<String> str=new ArrayList<String>();	
	private int sLen;
	
    public String[] permutation(String s) {
    	if(s==null) {
    		return null;
    	}
    	
    	//���ַ���ת��Ϊchar����
    	char[] chars=s.toCharArray();
    	//Arrays.sort(chars);           //�����Ƿ�ֹ�ظ�����
    	
    	sLen=s.length();
    	boolean[] isVisited=new boolean[sLen];
    	StringBuffer sb= new StringBuffer();
    	
    	recur(chars, isVisited, sb);
    	
    	int strSize=str.size();
    	String res[]=new String[strSize];
    	for (int i = 0; i < strSize; i++) {
			res[i]=str.get(i);
		}
    	
    	return res;
    	
    }
    
    private void recur(char chars[],boolean isVisited[],StringBuffer sb) {
    	if(sb.length()==chars.length) {    //Ŀ���ַ��������빹������ַ�������һ�£������������ӽ������
    		String temp=sb.toString();
    		if(!str.contains(temp)) {
    			str.add(sb.toString());
    		}    		
    		//�ǵ÷��أ�
    		return;        
    	}
    	
    	for (int i = 0; i < chars.length; i++) {
			if(isVisited[i]) {
				//����ǰi�ѱ���ӽ�sb�У��������һ��chars�е�i
				continue;
			}
//			if(i!=0&&chars[i]==chars[i-1]&&isVisited[i]==false) {
//				//��ֹ�����ַ��ظ������ظ����������һ��chars�е�i
//				continue;
//			}
			
			//����ǰiδ����ӽ�sb������ǰ����ַ����ظ�����ӽ�sb��
			isVisited[i]=true;
			sb.append(chars[i]);
			//Ȼ���ټ���һ���ַ�
			recur(chars, isVisited, sb);
			
			//���ݹ��̣�����һ�������������ַ���
			isVisited[i]=false;
			sb.deleteCharAt(sb.length()-1);
			
					
		}
    	
    }
    
}