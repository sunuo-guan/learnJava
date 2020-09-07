package com.huaweiyan.three;

import java.util.*;

public class Main {
	public static int index[];
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int m=scanner.nextInt();
		int k=scanner.nextInt();
		int arr[]=new int[m];
		index=new int[k+1];
		int min=Integer.MAX_VALUE;
		int sum=0;
		for (int i = 0; i < m; i++) {
			arr[i]=scanner.nextInt();
			min=Math.min(min, arr[i]);
			sum+=arr[i];
		}
		System.out.println(val(arr, m, k, min, sum));
		int location=0;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
			if(index[location]==i) {
				System.out.print("/ ");
				location++;
			}
		}
	}
	
	public static int val(int arr[],int m,int k,int l,int r) {
		while(l<r) {
			if(!judge(l,k,arr)) {
				l++;
			}else {
				break;
			}
		}
		return l;
	}
	
	public static boolean judge(int mid,int k,int arr[]) {
		int temp=0,sum=0,location=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			if(sum>=mid) {
				sum=0;
				index[temp]=i;
				temp++;    //此时s(j)已经大于了x，要想x符合条件，则计算下一个s(j)				
			}
	        if(temp>k-1){
	            return false;     //此时已经分成了m堆，却还有剩余的a[i]，x不符合条件
	        }	        
		}
		return true;
	}
}
