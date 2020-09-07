package com.jingdongyan.two;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    public static int least(People peoples[]) {
    	Arrays.sort(peoples);
    	HashMap<People,Integer> map=new HashMap<Main.People, Integer>();
    	//int dp[]=new int[peoples.length];
    	//int minStart=peoples[0].start,maxEnd=peoples[0].end;
    	//dp[0]=1;
    	int res=1;
    	map.put(peoples[0], res);

    	for (int i = 1; i < peoples.length; i++) {
    		boolean congtu=false;
    		for(People key:map.keySet()) {
    			if(peoples[i].isChongtu(key)) {
    				congtu=true;
    				int val=map.get(key)+1;
    				key.start=Math.min(peoples[i].start, key.start);
    				key.end=Math.max(peoples[i].end, key.end);
    				map.put(key, val);
    				res=Math.max(res, val);
    			}
    		}
    		if(!congtu) {
    			map.put(peoples[i], 1);
    		}
		}
    	return res;
    }
    
    
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num=in.nextInt();
        People peoples[]=new People[num];
        for (int i = 0; i < peoples.length; i++) {
			peoples[i]=new People(in.nextInt(), in.nextInt());
		}
        System.out.println(least(peoples));  
    }
    
    public static class People implements Comparable<People>{
		int start,end,distance;
		public People(int start,int end) {
			this.start=start;
			this.end=end;
			this.distance=end-start;
		}
		public int compareTo(People temp) {
			if(this.distance>temp.distance) {
				return 1;
			}else if(this.distance==temp.distance){
				return 0;
			}else {
				return -1;
			}
		}
		
		public boolean isChongtu(People temp) {
			if(this.start<temp.end&&this.start>temp.start) {
				return true;
			}else if(this.end<temp.end&&this.end>temp.start) {
				return true;
			}else if(this.end>temp.end&&this.start<temp.start){
				return true;
			}
			else {
				return false;
			}
		}
	}
    
    
}
