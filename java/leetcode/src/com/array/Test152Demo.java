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
        //imax表示以当前节点为终结节点的最大连续子序列乘积 imin表示以当前节点为终结节点的最小连续子序列乘积
        //由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin
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
