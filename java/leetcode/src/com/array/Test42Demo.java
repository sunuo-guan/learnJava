package com.array;

public class Test42Demo {
	public static void main(String[] args) {
		int height[]= {4,2,3};
		System.out.println(trap2(height));
	}
	
	/**
	 * ˫ָ�뷨
	 * @param height
	 * @return
	 */
	public static int trap(int[] height) {
		if(height==null||height.length==0){
            return 0;
        }

        int res=0;
        int left=0,len=height.length,right=len-1;
        int leftMax=height[0],rightMax=height[len-1];

        while(left<right){
            if(height[left]<height[right]){
                leftMax=Math.max(leftMax,height[left]);
                res=res+leftMax-height[left];
                left++;
            }else{
                rightMax=Math.max(rightMax,height[right]);
                res=res+rightMax-height[right];
                right--;
            }
        }

        return res;
    }
	
	/**
	 * ��̬�滮��
	 * @param height
	 * @return
	 */
	public static int trap2(int[] height) {
		if(height==null||height.length==0){
            return 0;
        }
		int res=0;
		
		//��������ֱ��¼����ɨ���ĵ�ǰ��������߶�
		int leftmax[]=new int[height.length];
		int rightmax[]=new int[height.length];
		int max=0;
		
		for (int i = 0; i < height.length; i++) {
			max=Math.max(max, height[i]);
			leftmax[i]=max;
		}
		
		max=0;
		for(int i=height.length-1;i>=0;i--) {
			max=Math.max(max, height[i]);
			rightmax[i]=max;
		}
		
		
		for (int i = 0; i < height.length; i++) {
			res=res+Math.min(leftmax[i], rightmax[i])-height[i];
		}
		
		return res;
	}
}
