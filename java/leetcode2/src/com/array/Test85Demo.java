package com.array;

import java.util.Arrays;

public class Test85Demo {
	public static void main(String[] args) {
		char[][] matrix= {{'0','1'}};
		System.out.println(maximalRectangle(matrix));
	}
	
	public static int maximalRectangle(char[][] matrix) {
		if(matrix==null||matrix[0].length==0) {
			return 0;
		}
		
		int height[]=new int[matrix[0].length];
		int left[]=new int[matrix[0].length];
		int right[]=new int[matrix[0].length];
		
		Arrays.fill(right, matrix[0].length);
		int maxArea=0;
		
		for (int i = 0; i < matrix.length; i++) {
			int curleft=0,curright=matrix[0].length;
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j]=='1') {
					height[j]++;
					left[j]=Math.max(curleft, left[j]);
				}else {
					height[j]=0;
					left[j]=0;
					curleft=j+1;
				}
				
			}
			
			for(int j=matrix[0].length-1;j>=0;j--) {
				if(matrix[i][j]=='1') {
					right[j]=Math.min(curright, right[j]);
				}else {
					right[j]=matrix[0].length;
					curright=j;
				}
			}
			
			for(int j = 0; j < matrix[0].length; j++) {
				maxArea=Math.max(maxArea, height[j]*(right[j]-left[j]));
			}
		}
		
		return maxArea;
    }
}
