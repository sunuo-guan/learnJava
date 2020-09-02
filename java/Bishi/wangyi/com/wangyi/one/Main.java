package com.wangyi.one;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int len=scanner.nextInt();
		long arr[]=new long[len];
		for (int i = 0; i < len; i++) {
			arr[i]=scanner.nextInt();
		}
		
		System.out.println(beishu(arr, len));
		
	}
	
	public static long beishu(long[] arr,int len) {
		long diff[]=new long[len-1];
		for (int i = 0; i < len-1; i++) {
			if(arr[i]>=arr[i+1]) {
				return -1;
			}else {
				diff[i]=arr[i+1]-arr[i];
			}
		}
		
		int index=0;
		long temp=gcd(diff[index],diff[index+1]);
		index=2;
		while(index<len-1) {
			gcd(temp,diff[index]);
			index++;
		}
		
//		while(min>1&&count!=diff.length) {
//			for (int i = 0; i < diff.length; i++) {
//				if(diff[i]%min!=0) {
//					min--;
//					count=0;
//					break;
//				}else {
//					count++;
//				}
//			}
//		}
//		
//		long b[]=new long[(int) min];
//		for (int i = (int)min; i >=1; i--) {
//			for (int d = 0; d < diff.length; d++) {
//				if(diff[d]%i!=0) {
//					b[i-1]=0;
//					break;
//				}else {
//					b[i-1]=i;
//				}
//			}
//		}
//		Arrays.sort(b);
//		return b[b.length-1];
		
		return temp;
		
	}
	
	public static long gcd(long a,long b) {
		if(a%b==0) {
			return b;
		}else {
			return gcd(b,a%b);
		}
	}
	
	
}
