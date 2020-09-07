package com.offer.chapter4;

import java.util.Arrays;

public class Test29Demo {
	public static void main(String[] args) {
		Solution29 solution29 = new Solution29();
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int res[]=solution29.spiralOrder(matrix);
		System.out.println(Arrays.toString(res));
	}
}

class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
    	//错误输入
    	if(matrix==null||matrix.length==0||matrix[0].length==0) {
    		return null;
    	}
    	int rows=matrix.length;
    	int columns=matrix[0].length;
    	int[] res=new int[rows*columns];
    	boolean[][] isVisited=new boolean[rows][columns];
    	
    	int row=0,column=0;
    	isVisited[row][column]=true;
    	res[0]=matrix[row][column];
    	int count=1;
    	
    	//策略：左下右上
    	while(count<rows*columns) {
    		//向右移动
    		while(column+1<columns&&isVisited[row][column+1]==false) {
    			column++;
    			res[count]=matrix[row][column];
    			isVisited[row][column]=true;
    			count++;
    		}
    		//向下移动
    		while(row+1<rows&&isVisited[row+1][column]==false) {
    			row++;
    			res[count]=matrix[row][column];
    			isVisited[row][column]=true;
    			count++;
    		}
    		
    		//向左移动
    		while(column-1>=0&&isVisited[row][column-1]==false) {
    			column--;
    			res[count]=matrix[row][column];
    			isVisited[row][column]=true;
    			count++;
    		}
    		
    		//向上移动
    		while(row-1>=0&&isVisited[row-1][column]==false) {
    			row--;
    			res[count]=matrix[row][column];
    			isVisited[row][column]=true;
    			count++;
    		}
    	}
    	
    	return res;
    }
}