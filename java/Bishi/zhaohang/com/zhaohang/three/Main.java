package com.zhaohang.three;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int arr[]=new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=scanner.nextInt();
		}
		
		System.out.println();
	}
	
	public static int times(int arr[],int n,int k) {
		Arrays.sort(arr);
		int zhongweishu=arr[n/2];
		int sum=0;
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		for (int num : arr) {
            if(map.containsKey(num)) {
            	map.put(num, map.get(num)+1);
            }else {
            	map.put(num, 1);
            }
        }
		
		int max=0;
		int index=0;
		for (int key : map.keySet()) {
			if(max<map.get(key)) {
				index=key;
				max=map.get(key);
			}
		}
		
		if(max>=k) {
			return 0;
		}
		
		int diff=k-max;

		return 0;
	}
}
