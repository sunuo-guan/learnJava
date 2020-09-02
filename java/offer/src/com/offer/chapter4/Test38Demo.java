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
    	
    	//将字符串转换为char数组
    	char[] chars=s.toCharArray();
    	//Arrays.sort(chars);           //排序，是防止重复必须
    	
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
    	if(sb.length()==chars.length) {    //目标字符串长度与构造出的字符串长度一致，则构造结束，添加进结果中
    		String temp=sb.toString();
    		if(!str.contains(temp)) {
    			str.add(sb.toString());
    		}    		
    		//记得返回！
    		return;        
    	}
    	
    	for (int i = 0; i < chars.length; i++) {
			if(isVisited[i]) {
				//若当前i已被添加进sb中，则访问下一个chars中的i
				continue;
			}
//			if(i!=0&&chars[i]==chars[i-1]&&isVisited[i]==false) {
//				//防止出现字符重复，若重复，则访问下一个chars中的i
//				continue;
//			}
			
			//若当前i未被添加进sb中且与前面的字符不重复，则加进sb中
			isVisited[i]=true;
			sb.append(chars[i]);
			//然后再加下一个字符
			recur(chars, isVisited, sb);
			
			//回溯过程，找下一个满足条件的字符串
			isVisited[i]=false;
			sb.deleteCharAt(sb.length()-1);
			
					
		}
    	
    }
    
}