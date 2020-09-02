package com.array;

import java.util.Stack;

public class Test84Demo {
	public static void main(String[] args) {
		int[] heights= {2,1,2};
		System.out.println(largestRectangleArea(heights));
	}
	
	//����
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
	
	//�ڱ�������ǰ�����˷ֱ���Ӹ߶�Ϊ���Ԫ�أ�����Ҫ���жϿ�ջ������Ԫ����ӽ�ȥ������⴦��������ջ
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
			//while������if
			while(shaobingHeights[stack.peek()]>shaobingHeights[i]) {
				int high=shaobingHeights[stack.pop()];
				//i����ǰ������ĳ����ε��ұߣ���������stack.peek()������ߣ�������
				int weight=i-stack.peek()-1;
				int area=high*weight;
				maxArea=Math.max(maxArea, area);
			}
			stack.push(i);			
		}
		return maxArea;
	}
	
	//����
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
