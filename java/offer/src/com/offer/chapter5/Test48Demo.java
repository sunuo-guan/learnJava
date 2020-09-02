package com.offer.chapter5;

import java.util.HashMap;

public class Test48Demo {
	public static void main(String[] args) {
		String s="abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	if(s==null||s.length()==0) {
    		return 0;
    	}
    	
    	//��ȡs���ַ������ڹ�ϣ���У�keyΪ��ĸ��valueΪ���ַ����е�λ��
    	HashMap<Character, Integer> map=new HashMap<Character, Integer>();
    	
    	//��̬�滮��maxLenҪ�棨f(i)���������������Ǹ�
    	//f(i)��ʾ�Ե�i���ַ���β�Ĳ������ظ��ַ������ַ�������󳤶�
    	int maxLen=0;
    	int resLen=0;
    	for (int i = 0; i < s.length(); i++) {
			//֮ǰ���ַ����Ƿ��Ѿ�������ǰ���������ַ�
    		if(map.containsKey(s.charAt(i))) {
    			//����ַ������Ѱ�����ǰ�������ַ��������ֵ���ظ��ַ��ľ���d�뵱ǰ���ֵ�Ƚ�
				if(i-map.get(s.charAt(i))>maxLen) {
					//d>f(i-1) f(i)=f(i-1)+1
					maxLen++;
				}else {
					//d<=f(i-1) f(i)=d
					maxLen=i-map.get(s.charAt(i));
				}
			}else {
				//����������f(i)=f(i-1)+1
				maxLen++;
			}
    		map.put(s.charAt(i), i);
    		resLen=Math.max(maxLen, resLen);
		}
    	
    	return resLen;
    	
    }
}
