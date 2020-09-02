package com.string;

import java.util.*;

public class Test22Demo {
	public static void main(String[] args) {
		
	}
}

class Solution22 {
    private List<String> res;
    private int sum;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<String>();
        sum=n;
        if(n<1){
            return res;
        }

        recursion(0,0,"");

        return res;
    }

    /**
     * 
     * @param left�������ŵ�����
     * @param right�������ŵ�����
     * @param str����ǰ���ַ���
     */
    private void recursion(int left,int right,String str){
        if(left+right==sum*2){
            res.add(str);
            return;
        }
        
        //left���ܱ�n��
        if(left<sum){
            recursion(left+1,right,str+'(');
        }
        //right���ܱ�left��
        if(right<left){
            recursion(left,right+1,str+')');
        }

        return;
    }
}