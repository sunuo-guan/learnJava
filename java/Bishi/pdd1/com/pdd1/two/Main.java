package com.pdd1.two;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		scanner.nextLine();		
		String str=scanner.nextLine();
		char arr[]=str.toCharArray();
		int res[]=new int[n];
		
		System.out.println(nums(n, k, arr,res));
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
	}
	
	public static int nums(int n,int k,char arr[],int res[]) {
		int count=0;
		ArrayList<Integer> list=new ArrayList<Integer>();
		int numbers[]=new int[10];
		
		for (int i = 0; i < n; i++) {
			numbers[arr[i]-'0']++;
		}
		
		int maxNum=0;
		for (int i = 0; i < 10; i++) {
			maxNum=Math.max(maxNum, numbers[i]);
		}
		
		for (int i = 0; i < 10; i++) {
			if(numbers[i]==maxNum) {
				list.add(i);
			}
		}
		
		int sum=0;
		for(int index:list) {
			sum+=index;
		}
		int max=sum/list.size();
		
		if(maxNum>=k) {
			for(int i=0;i<n;i++) {
				res[i]=arr[i]-'0';
			}
			return 0;
		}
		
		int i=1;
		while(k>maxNum) {
			if(max-i>=0) {
				if(k-maxNum>numbers[max-i]) {
					maxNum+=numbers[max-i];
					count+=numbers[max-i]*i;
				}else {					
					count+=(k-maxNum)*i;
					break;
				}
			}
			if(max+i<10) {
				if(k-maxNum>numbers[max+i]) {
					maxNum+=numbers[max+i];
					count+=numbers[max+i]*i;
				}else {
					count+=(k-maxNum)*i;
					break;
				}
			}
			i++;
		}
		
		return count;
	}
	
}
