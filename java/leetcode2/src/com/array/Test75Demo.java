package com.array;

public class Test75Demo {
	public static void main(String[] args) {
		
	}
	
	public static void sortColors(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }

        //0�߽��ұߣ�2�߽���ߣ���ǰ������ָ��
        int curr=0,p0=0,p2=nums.length-1;
        int temp=0;
        
        //�˳���������ǰԽ��2�߽磬��Ϊ��ʱ��ǰ�Լ���ǰ֮��ֻ��2���Ѿ��ź���
        while(curr<=p2){
        	//��ǰ=0����ǰ��0�߽罻������ǰ��0�߽�++
            if(nums[curr]==0){
                temp=nums[curr];
                nums[curr]=nums[p0];
                nums[p0]=temp;
                curr++;
                p0++;
            }else if(nums[curr]==2){
            	//��ǰ=2����ǰ��2�߽罻����2�߽�--����ǰ��������
                temp=nums[curr];
                nums[curr]=nums[p2];
                nums[p2]=temp;
                p2--;
            }else{
            	//��ǰ=1����ǰ++
                curr++;
            }
        }
    }
}
