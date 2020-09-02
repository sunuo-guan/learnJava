package com.array;

import java.util.Arrays;

public class Test31Demo {
	public static void main(String[] args) {
		Solution31 solution31 = new Solution31();
		int nums[]= {1,5,1};
		solution31.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}

class Solution31 {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<=1){
            return;
        }
        int index=nums.length-1;
        
       while(index>0) {
    	   if(nums[index-1]>nums[index]) {
    		   index--;
    		   continue;
    	   }else {
    		   break;
    	   }    	   
       }
       int k=index-1;
       if(k<0) {
    	   reverse(nums, 0);
       }else {
    	   index=nums.length-1;
    	   while(index>k&&nums[index]<=nums[k]) {
    		   index--;
    	   }
    	   swap(nums, index, k);
    	   reverse(nums, k+1);
       }
       
       
    }

    private void reverse(int nums[],int start){
        int end=nums.length-1;
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    private void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}