package com.array;

import java.util.Stack;

public class Test84Demo {
	public static void main(String[] args) {
		int[] heights= {2,1,2};
		System.out.println(largestRectangleArea(heights));
	}
	
	//暴力
	public static int largestRectangleArea2(int[] heights) {
		if(heights==null||heights.length==0){
            return 0;
        }
		
		int maxArea=0;
		for(int i=0;i<heights.length;i++) {
			int minHeight=Integer.MAX_VALUE;
			for(int j=i;j<heights.length;j++) {
				minHeight=Math.min(minHeight, heights[j]);
				maxArea=Math.max(maxArea, minHeight*(j-i+1));
			}
		}
		
		return maxArea;
	}
	
	//哨兵（数组前后两端分别添加高度为零的元素，不需要再判断空栈和最后的元素添加进去后的特殊处理），单调栈
	public static int largestRectangleArea(int[] heights) {
		if(heights==null||heights.length==0){
            return 0;
        }
		
		int shaobingHeights[]=new int[heights.length+2];
		for(int i=0;i<heights.length;i++) {
			shaobingHeights[i+1]=heights[i];
		}
		
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(0);
		int maxArea=0;
		for (int i = 1; i < shaobingHeights.length; i++) {
			//while而不是if
			while(shaobingHeights[stack.peek()]>shaobingHeights[i]) {
				int high=shaobingHeights[stack.pop()];
				//i代表当前待计算的长方形的右边（不含），stack.peek()代表左边（不含）
				int weight=i-stack.peek()-1;
				int area=high*weight;
				maxArea=Math.max(maxArea, area);
			}
			stack.push(i);			
		}
		return maxArea;
	}
	
	//错误
	public static int largestRectangleAreaWrong(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }

        int tallest=0,tallestIndex=0;;        
        for(int i=0;i<heights.length;i++){
            if(tallest<heights[i]){
                tallest=heights[i];
                tallestIndex=i;
            }
        }

        int left=tallestIndex,right=tallestIndex;
        int maxArea=tallest;
        while(left>=0&&right<=heights.length-1){
            int area=0;
            if(left-1>=0&&right+1<heights.length){
                if(heights[left-1]>heights[right+1]){
                    left=left-1;
                    int min=minOfArray(heights,left,right);
                    area=(right-left+1)*min;
                    maxArea=Math.max(area,maxArea);
                }else{
                    right=right+1;
                    int min=minOfArray(heights,left,right);
                    area=(right-left+1)*min;
                    maxArea=Math.max(area,maxArea);
                }
            }else if(left==0&&right+1<heights.length){
                right=right+1;
                int min=minOfArray(heights,left,right);
                area=(right-left+1)*min;
                maxArea=Math.max(area,maxArea);
            }else if(left-1>=0&&right==heights.length-1){
                left=left-1;
                int min=minOfArray(heights,left,right);
                area=(right-left+1)*min;
                maxArea=Math.max(area,maxArea);
            }else {
            	break;
            }
        }

        return maxArea;
    }

    private static int minOfArray(int heights[],int left,int right){
        int min=heights[left];
        for(int i=left;i<=right;i++){
            min=Math.min(min,heights[i]);
        }
        return min;
    }
}
