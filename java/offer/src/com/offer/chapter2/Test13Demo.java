package com.offer.chapter2;

import java.util.Arrays;

public class Test13Demo {
	public static void main(String[] args) {
		Solution13 solution13 = new Solution13();
//		int arr[]=solution13.resolve(1203);
//		System.out.println(Arrays.toString(arr));
		
		int m=1,n=2,k=1;
		int count=solution13.movingCount(m, n, k);
		System.out.println(count);
	}
}

class Solution13 {
	private int count;
	private int rows;
	private int columns;
	
    public int movingCount(int m, int n, int k) {
    	//异常输入判断
    	if(m<=0||n<=0||k<0) {
    		return -1;
    	}
    	boolean[][] visited=new boolean[m][n];
    	rows=m;
    	columns=n;
    	count=0;
    	
    	move(visited, 0, 0, k);
    	
    	return count;
    }
    
    public void move(boolean[][] visited,int row,int column,int k) {
    	//先判断输入的值是否合法（边界，是否访问过，是否满足条件）
    	if(row>=0&&row<rows&&column>=0&&column<columns&&
    			visited[row][column]==false&&sumOfResolve(row, column)<=k) {
    		//若合法，则可达，
    		count++;
    		visited[row][column]=true;
    		
    		//向周围走
    		move(visited, row-1, column, k);
    		move(visited, row+1, column, k);
    		move(visited, row, column-1, k);
    		move(visited, row, column+1, k);
    		
    		//走过或者失败，不用修改数据
    	}
    }
    
    //求两个数按位分解之后的各个位之和
    public int sumOfResolve(int row,int column) {
    	int rowVal[]=resolve(row);
    	int columnVal[]=resolve(column);
    	int sum=0;
    	for (int i = 0; i < rowVal.length; i++) {
			sum=rowVal[i]+sum;
		}
    	for (int i = 0; i < columnVal.length; i++) {
			sum=sum+columnVal[i];
		}
    	return sum;
    }
    
    //将一个数按位数分解
    public int[] resolve(int value) {
    	String s=value+"";
    	int maxLen=s.length();
    	int[] resolveVal=new int[maxLen];
    	
    	int n=1;
    	for (int i = 0; i < maxLen; i++) {
    		resolveVal[i]=value/n%10;
			n=n*10;
		}
    	
    	return resolveVal;
    }
}