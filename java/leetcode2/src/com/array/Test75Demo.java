package com.array;

public class Test75Demo {
	public static void main(String[] args) {
		
	}
	
	public static void sortColors(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }

        //0边界右边，2边界左边，当前，三大指针
        int curr=0,p0=0,p2=nums.length-1;
        int temp=0;
        
        //退出条件：当前越过2边界，因为此时当前以及当前之后只有2，已经排好序
        while(curr<=p2){
        	//当前=0，当前与0边界交换，当前与0边界++
            if(nums[curr]==0){
                temp=nums[curr];
                nums[curr]=nums[p0];
                nums[p0]=temp;
                curr++;
                p0++;
            }else if(nums[curr]==2){
            	//当前=2，当前与2边界交换，2边界--，当前不动！！
                temp=nums[curr];
                nums[curr]=nums[p2];
                nums[p2]=temp;
                p2--;
            }else{
            	//当前=1，当前++
                curr++;
            }
        }
    }
}
