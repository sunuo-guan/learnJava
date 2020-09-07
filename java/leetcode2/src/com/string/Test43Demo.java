package com.string;

import java.util.*;

public class Test43Demo {
	public static void main(String[] args) {
		
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
	}
	
	public List<List<String>> groupAnagramsError(String[] strs) {
        List<List<String>> res=new ArrayList<List<String>>();
        if(strs==null||strs.length==0){
            return res;
        }

        int len=strs.length;
        boolean isVisited[]=new boolean[len];
        ArrayList<String> temp=new ArrayList<String>();

        for(int i=0;i<len;i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                HashSet<Character> set=new HashSet<Character>();
                temp.add(strs[i]);
                for(int j=0;j<strs[i].length();j++){
                    set.add(strs[i].charAt(j));
                }
                for(int j=i+1;j<len;j++){
                    if(strs[j].length()==strs[i].length()||!isVisited[j]){
                        boolean isYiwei=true;
                        for(int k=0;k<strs[i].length();k++){
                            if(!set.contains(strs[j].charAt(k))){
                                isYiwei=false;
                                break;
                            }
                        }
                        if(isYiwei){
                            temp.add(strs[j]);
                            isVisited[j]=true;
                        }
                    }
                }
                res.add(new ArrayList<String>(temp));
                temp.clear();
            }
        }

        return res;
    }
}
