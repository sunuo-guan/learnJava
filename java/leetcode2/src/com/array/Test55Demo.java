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
        
        //�Ӻ���ǰһ�����жϣ�ǰһ���Ƿ���������һ����������ǰһ����Ϊ�µ��յ㣬������ǰ�ж�
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
