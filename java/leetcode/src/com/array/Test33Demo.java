package com.array;

public class Test33Demo {
	public static void main(String[] args) {
		int nums[]= {1};
		int target=1;
		System.out.println(search(nums, target));
	}
	
	public static int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }

        int left=0,right=nums.length-1;
        int mid,begin=0;
        //先二分找到旋转点的下标
        while(left<right){
            mid=(left+right)/2;
            if(nums[mid]>nums[mid+1]){
                begin=mid+1;
                break;
            }else{
                if(nums[mid]>nums[left]) {
                	left=mid+1;
                }else {
                	right=mid-1;
                }
            }
        }
        
        

        if(target>=nums[0]){
            return search(0,begin-1,target,nums);
        }else if(target<=nums[nums.length-1]){
            return search(begin,nums.length-1,target,nums);
        }

        return -1;
    }

    private static int search(int start,int end, int target,int nums[]){
        int left=start,right=end;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return -1;
    }
}
