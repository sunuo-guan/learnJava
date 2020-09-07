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
    	
    	//读取s的字符，存于哈希表中，key为字母，value为在字符串中的位置
    	HashMap<Character, Integer> map=new HashMap<Character, Integer>();
    	
    	//动态规划，maxLen要存（f(i)），最后输出最大的那个
    	//f(i)表示以第i个字符结尾的不包含重复字符的子字符串的最大长度
    	int maxLen=0;
    	int resLen=0;
    	for (int i = 0; i < s.length(); i++) {
			//之前的字符串是否已经包含当前遍历到的字符
    		if(map.containsKey(s.charAt(i))) {
    			//如果字符串中已包含当前读到的字符，则最大值看重复字符的距离d与当前最大值比较
				if(i-map.get(s.charAt(i))>maxLen) {
					//d>f(i-1) f(i)=f(i-1)+1
					maxLen++;
				}else {
					//d<=f(i-1) f(i)=d
					maxLen=i-map.get(s.charAt(i));
				}
			}else {
				//不包含，则f(i)=f(i-1)+1
				maxLen++;
			}
    		map.put(s.charAt(i), i);
    		resLen=Math.max(maxLen, resLen);
		}
    	
    	return resLen;
    	
    }
}
