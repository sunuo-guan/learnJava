package com.kuaishou.two;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution solution=new Solution();
		int R=33,N=3;
		int arr[]=solution.GetPowerFactor(R, N);
		System.out.println();
	}
}

class Solution {
    /**
     * 返回无重复幂因子的 N进制完美数之和的所有幂因子
     * @param R int整型 
     * @param N int整型 N进制
     * @return int整型一维数组
     */
    public int[] GetPowerFactor (int R, int N) {
        // write code here    	
    	if(R==1) {
    		int arr[]= {0};
    		return arr;
    	}
    	
    	Stack<Integer> stack=new Stack<Integer>();
    	
    	while(R>0) {
    		int times=0;
    		int mi=0;
    		while(mi<=R) {
    			times++;
    			mi=(int) Math.pow(N, times);
    		}
    		times--;
    		R=R-(int) (Math.pow(N, times));
    		stack.push(times);
    	}
    	
    	int result[]=new int[stack.size()];
    	if(stack.isEmpty()) {
    		return new int[0];
    	}else {
    		result[0]=stack.pop();
    	}
    	for (int i = 1; i < result.length; i++) {
			if(stack.peek()==result[i-1]) {
				return new int[0];
			}else {
				result[i]=stack.pop();
			}
		}
    	
    	return result;
    }
}
