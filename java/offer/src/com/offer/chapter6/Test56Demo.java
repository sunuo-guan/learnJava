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
		
		int diff=0;         //����ȫ�����һ���õ��Ľ��
		for (int i = 0; i < nums.length; i++) {
			diff=diff^nums[i];
		}
		
		//�ҵ�����������ұߵĵ�һ��1��ԭ���ǲ����ʾ���������������������õ���ֵ�Ƕ����Ƶ�1000...
		diff=-diff&diff;
		
		//��diff�����λ��0����1��������з��飬�������������һ�ε����ȱ����ڲ�ͬ��		
		//�ٶ�����������������ɵõ�������
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
