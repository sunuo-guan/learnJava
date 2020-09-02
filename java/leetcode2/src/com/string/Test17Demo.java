package com.string;

import java.util.*;

public class Test17Demo {
	public static void main(String[] args) {
		String digits="234";
		Solution17 solution17 = new Solution17();
		List<String> res=solution17.letterCombinations(digits);
		for(String i:res) {
			System.out.println(i);
		}
	}
}

class Solution17 {
    HashMap<Character,String> map;
    List<String> res;

    public List<String> letterCombinations(String digits) {
        res=new ArrayList<String>();
        if(digits==null||digits.length()==0){
            return res;
        }

        map=new HashMap<Character,String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        StringBuilder sb=new StringBuilder();
        findAllRes(digits,0,sb);
        
        return res;
    }
    
    public void findAllRes(String digits,int index,StringBuilder builder){
        if(index==digits.length()){
            res.add(builder.toString());
            return;
        }

        String value=map.get(digits.charAt(index));
        for(int i=0;i<value.length();i++){
            findAllRes(digits,index+1,builder.append(value.charAt(i)));
            builder.deleteCharAt(index);
        }
        
        return;
    }
}