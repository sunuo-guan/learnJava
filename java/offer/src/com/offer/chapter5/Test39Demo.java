package com.offer.chapter5;


public class Test39Demo {
	public static void main(String[] args) {
		int[] test= {1,2,2,1};
		System.out.println(majorityElement(test));
	}
	
	public static int majorityElement(int[] nums) {
		if(nums==null||nums.length==0) {
			return -1;
		}
		
		int len=nums.length;
		int times=1;
		int indexVal=nums[0];
		//����һ�����������
		//������һ�������뱣���һ��ʱ��������һ����һ��ʱ������һ������Ϊ��ʱ���浱ǰ�����Ҵ���������Ϊһ
		for (int i = 1; i < len; i++) {
			
			if(times==0) {
				times=1;
				indexVal=nums[i];
			}else if(nums[i]!=indexVal) {
				times--;
			}else {
				times++;
			}
		}
		
		//��֤��ǰ�����������û�й���
		times=0;
		for (int i = 0; i < len; i++) {
			if(indexVal==nums[i]) {
				times++;
			}
		}
		if(times>len/2) {
			return indexVal;
		}else {
			return -1;
		}
		
    }
}

