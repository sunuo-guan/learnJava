package com.array;

public class Test152Demo {
	public static void main(String[] args) {
		int[] nums= {-4,0,-3,-2};
		System.out.println(maxProduct(nums));
	}
	
	public static int maxProduct(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }

        int max=Integer.MIN_VALUE,imax=1,imin=1;
        //imax��ʾ�Ե�ǰ�ڵ�Ϊ�ս�ڵ��������������г˻� imin��ʾ�Ե�ǰ�ڵ�Ϊ�ս�ڵ����С���������г˻�
        //���ڴ��ڸ�������ô�ᵼ�����ı���С�ģ���С�ı����ġ���˻���Ҫά����ǰ��Сֵimin
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]<0) {
				int temp=imax;
				imax=imin;
				imin=temp;
			}
			imax=Math.max(nums[i], imax*nums[i]);
			imin=Math.min(nums[i], imin*nums[i]);
			
			max=Math.max(max, imax);
		}

        return max;
    }
}
