package com.offer.chapter6;

import java.util.Arrays;

public class Test60Demo {
	public static void main(String[] args) {
		int n=11;
		System.out.println(Arrays.toString(twoSum(n)));
	}
	
    public static double[] twoSum(int n) {
    	if(n<=0) {
    		return new double[0];
    	}
    	
    	final int maxPoint=6;
    	
    	//定义两个数组，轮流存储点数之和出现的次数，下标即为点数之和，以减少空间使用
    	int temp[][]=new int[2][maxPoint*n+1];
    	
    	int flag=0;   //数组切换的标志
    	
    	//初始化：当只有一个骰子
    	for(int i=1;i<=maxPoint;i++) {
    		temp[flag][i]=1;
    	}
    	
    	//不断添加新骰子
    	for(int k=2;k<=n;k++) {
    		for(int j=0;j<k;j++) {
    			temp[1-flag][j]=0;     //将即将保存新点数之和的数组清空置零
    		}
    		
    		for(int j=k;j<=maxPoint*k;j++) {
    			temp[1-flag][j]=0;    //将即将保存新点数之和的数组清空置零
    			for (int o = 1; o <=j&&o<=maxPoint; o++) {
    				//新加入一颗骰子后，新的点数之和（下标j）即为前一轮j-1直到j-6的次数之和
    				//（因为本轮骰子可能出现的点数为1-6，因此前一轮j-1到j-6在本轮都有可能成为j
					temp[1-flag][j]+=temp[flag][j-o];             
				}
    		}
    		
    		flag=1-flag;
    	}
    	
    	double total=Math.pow(maxPoint, n);
    	double res[]=new double[maxPoint*n+1-n];
    	
    	for (int i = n; i <= maxPoint*n; i++) {
			res[i-n]=temp[flag][i]/total;
		}
    	
    	return res;
    }
}
