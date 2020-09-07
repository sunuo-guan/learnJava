package com.offer.chapter6;

import java.util.Arrays;

public class Test56Demo {
	public static void main(String[] args) {
		int[] nums= {2,3,3,2,2,3,4};
		System.out.println(Arrays.toString(singleNumbers(nums)));
		System.out.println(singleNumberInThree(nums));
	}
	
	public static int[] singleNumbers(int[] nums) {
		if(nums==null||nums.length<2) {
			return null;
		}		
		
		int diff=0;         //数组全部异或一遍后得到的结果
		for (int i = 0; i < nums.length; i++) {
			diff=diff^nums[i];
		}
		
		//找到结果二进制右边的第一个1，原理是补码表示二进制数负数与正数，得到的值是二进制的1000...
		diff=-diff&diff;
		
		//将diff的最高位是0还是1对数组进行分组，分组后两个出现一次的数比被分在不同组		
		//再对两个分组进行异或则可得到两个数
		int res1=0,res2=0;
		for(int num:nums) {
			if((num&diff)==0) {
				res1=res1^num;
			}else {
				res2=res2^num;
			}
		}
		
		int[] res= {res1,res2};
		
		return res;
    }
	
	public static int singleNumberInThree(int[] nums) {
		if(nums==null||nums.length<3) {
			return -1;
		}
		
		int bitSum[]=new int[32];
		for (int i = 0; i < nums.length; i++) {
			int bitMask=1;
			for (int j = 31; j >= 0; j--) {
				int bit=nums[i]&bitMask;
				if(bit!=0) {
					bitSum[j]++;
				}
				bitMask=bitMask<<1;
			}
		}
		
		int res=0;
		for (int i = 0; i < 32; i++) {
			res=res<<1;
			res+=bitSum[i]%3;
		}
		
		return res;
    }
}
