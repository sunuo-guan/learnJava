package com.array;

public class Test169Demo {
	public static void main(String[] args) {
		
	}
	
	
	//������������֮��ȡn/2����
	
	//����һ��
	public int majorityElement(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }

        int res=nums[0];
        int times=1;
        for(int i=1;i<nums.length;i++){
            if(res==nums[i]){
                times++;
            }else{
                times--;
            }

            if(times==0){
                res=nums[i];
                times=1;
            }
        }

        return res;
    }
}
