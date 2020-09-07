package com.offer.chapter5;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test40DEmo {
	public static void main(String[] args) {
		int[] nums= {3,2,1};
		System.out.println(Arrays.toString(getLeastNumbers(nums, 2)));
		
	}
	
	public static int[] getLeastNumbers(int[] arr, int k) {
		if(arr==null||arr.length==0||k<=0||arr.length<k) {
			return new int[0];
		}
		int[] result=new int[k];
		
		//����ֵ�����������ֵ��ֵ���±�
		//���������ҵ���Сֵ���滻
		//�������鱣�棬��˷������Ӷ�n2��������ֱ������ ����
		//���ô󶥶ѷ��������ȡ��ֵ����ʱ�临�Ӷ�С
		PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>((o1,o2)->o2-o1);
		for(int num:arr) {
			maxHeap.add(num);
			if(maxHeap.size()>k) {
				maxHeap.poll();
			}
		}
		
		for (int i = 0; i < k; i++) {
			result[i]=maxHeap.poll();
		}
		
		//���������k����������С�ķ���ߣ�������ķ��ұ�
		//����k�����Ƶ�����
//		findKthSmallest(arr,k-1);
//		for (int i = 0; i < k; i++) {
//			result[i]=arr[i];
//		}	
		return result;
    }
	
	public static void findKthSmallest(int arr[],int index) {
		int left=0,right=arr.length-1;
		int temp=0;
		while(left<right) {
			temp=partition(arr, left, right);
			if(temp==index) {
				break;
			}else if(temp>index) {
				right=temp-1;
			}else {
				left=temp+1;
			}
		}
	}
	
	public static int partition(int nums[],int left,int right) {
		int temp=nums[left];
		int l=left,r=right+1;
		while(true) {
			while(l!=right&&nums[++l]<temp) ;
			while(r!=left&&nums[--r]>temp) ;
			if(l>=r) {
				break;
			}
			swap(nums,l,r);
		}
		swap(nums,left,r);
		return r;
		
	}
	
	public static void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
