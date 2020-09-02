package com.string;

import java.util.HashMap;

public class Test3Demo {
	public static void main(String[] args) {
		String s="tmmzuxt";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }

        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        char arr[]=s.toCharArray();
        int max[]=new int[s.length()];

        for(int i=0;i<s.length();i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
                max[i]=i==0?1:max[i-1]+1;
            }else{
                int oldIndex=map.get(arr[i]);
                int diff=i-oldIndex;
                if(diff>max[i-1]){
                    max[i]=max[i-1]+1;
                }else{
                    max[i]=diff;
                }
                map.put(arr[i],i);
            }
        }

        int maxLen=0;
        for(int i:max){
            if(i>maxLen){
                maxLen=i;
            }
        }
        
        return maxLen;
    }
}
