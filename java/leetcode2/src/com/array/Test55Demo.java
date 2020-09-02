package com.array;

public class Test55Demo {
	public static void main(String[] args) {
		
	}
	
	public static boolean canJump(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }

        int end=nums.length-1;
        int temp=end-1;
        
        //从后向前一个个判断，前一个是否能跳到后一个，若能则将前一个置为新的终点，继续向前判断
        while(end>=0&&temp>=0){
            if(nums[temp]>=end-temp){
                end=temp;
                temp--;
            }else{
                temp--;
            }
        }

        return end==0?true:false;
    }
}
