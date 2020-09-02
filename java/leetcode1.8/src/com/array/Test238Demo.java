package com.array;

public class Test238Demo {
	public static void main(String[] args) {
		int[] nums= {1,2,3,4};
		productExceptSelf2(nums);
	}
	
	//����һ���������飬������ұ߳˻�
	public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int left[]=new int[len];
        int right[]=new int[len];
        int ans[]=new int[len];
        
        left[0]=1;
        for (int i = 1; i < len; i++) {
			left[i]=left[i-1]*nums[i-1];
		}
        
        right[len-1]=1;
        for (int i = len-2; i >=0; i--) {
			right[i]=right[i+1]*nums[i+1];
		}
        
        for (int i = 0; i < len; i++) {
			ans[i]=left[i]*right[i];
		}
        
        return ans;
        
    }
	
	//���������Ż����ı�������
	public static int[] productExceptSelf2(int[] nums) {
        int len=nums.length;
        int ans[]=new int[len];
        
        
        //�ȴ�λ�����Ԫ��֮��
        ans[0]=1;
        for (int i = 1; i < len; i++) {
			ans[i]=ans[i-1]*nums[i-1];
		}
        
        int right=nums[len-1];
        for (int i = len-2; i >=0; i--) {
			ans[i]=ans[i]*right;
			right*=nums[i];
		}
        
        return ans;
        
    }
}
