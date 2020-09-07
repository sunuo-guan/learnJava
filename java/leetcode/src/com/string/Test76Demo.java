package com.string;

import java.util.*;

public class Test76Demo {

}

class Solution76 {
	public String minWindow(String s, String t) {
        if(t.length()==0||s.length()==0){
            return "";
        }

        HashMap<Character,Integer> tMap=new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){
           if(tMap.containsKey(t.charAt(i))) {
        	   tMap.put(t.charAt(i), tMap.get(t.charAt(i))+1);
           }else {
        	   tMap.put(t.charAt(i), 1);
           }
        }

        int start=0,end=0,minLen=s.length()+1;
        int resStart=0,resEnd=0;
        int sContainLen=0;
        String res="";

        HashMap<Character,Integer> sMap=new HashMap<Character,Integer>();
        while(end<s.length()) {
        	
        	if(tMap.containsKey(s.charAt(end))) {
        		if(sMap.containsKey(s.charAt(end))) {
        			sMap.put(s.charAt(end), sMap.get(s.charAt(end))+1);
                }else {
                	sMap.put(s.charAt(end), 1);
                }
        	}
        	
        	if(sMap.containsKey(s.charAt(end))&&sMap.get(s.charAt(end))==tMap.get(s.charAt(end))) {
        		sContainLen++;
        	}
        	
        	//循环，此步是窗口左边向右移动，直到窗口内不包含给定串的所有字母
        	while(start<=end&&sContainLen==tMap.size()) {
        		if(end-start+1<minLen) {
        			minLen=end-start+1;
        			resStart=start;
        			resEnd=end;
        		}
        		
        		if(sMap.containsKey(s.charAt(start))) {
        			sMap.put(s.charAt(start), sMap.get(s.charAt(start))-1);
        		}
        		
        		if(sMap.containsKey(s.charAt(start))&&sMap.get(s.charAt(start))<tMap.get(s.charAt(start))) {
        			sContainLen--;
        		}
        		start++;
        	}
        	
        	end++;
        }

        if(minLen==s.length()+1) {
        	return res;
        }else {
        	return s.substring(resStart, resEnd+1);
        }
        
    }
	
	//O(n2)
    public String minWindow2(String s, String t) {
        if(s==null||s.length()==0){
            return "";
        }

        HashSet<Character> tSet=new HashSet<Character>();
        for(int i=0;i<t.length();i++){
            tSet.add(t.charAt(i));
        }

        int start=0,end=1,minLen=s.length();
        String res="";

        for(int i=0;i<s.length();i++){
            if(tSet.contains(s.charAt(i))){
                start=i;
                HashSet<Character> sSet=new HashSet<Character>();               
                for(int j=start;j<s.length();j++){
                    if(tSet.contains(s.charAt(j))){
                        sSet.add(s.charAt(j));
                    }
                    if(sSet.size()==tSet.size()){
                        end=j+1;
                        if(end-start<=minLen){
                            res=s.substring(start,end);
                            minLen=end-start;
                        }
                    }                   
                }
            }
        }

        return res;
    }
}
