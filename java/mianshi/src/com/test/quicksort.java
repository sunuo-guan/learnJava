package com.test;

import java.util.Arrays;

public class quicksort {
	public static void main(String[] args) {
		int array[] = { 4, -3, 7, 3, -1, 8, -5, 2, 1 };

		System.out.println("ÅÅÐòÇ°£º" + Arrays.toString(array));
		quick(array, 0, array.length - 1);
		System.out.println("ÅÅÐòºó£º" + Arrays.toString(array));
	}
	
	public static void quick(int arr[],int left,int right) {
		if(left>right) {
			return;
		}
		
		int l=left,r=right;
		
		int val=arr[left];
		
		while(l<r) {
			while(l<r&&arr[r]>=val) {
				r--;
			}
			
			while(l<r&&arr[l]<=val) {
				l++;
			}
			
			if(l<r) {
				int temp=arr[l];
				arr[l]=arr[r];
				arr[r]=temp;
			}
		}
		
		arr[left]=arr[l];
		arr[l]=val;
		
		quick(arr, left, l-1);
		quick(arr, l+1, right);
		
	}
}
