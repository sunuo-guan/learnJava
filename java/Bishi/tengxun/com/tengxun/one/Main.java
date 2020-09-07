package com.tengxun.one;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int q=scanner.nextInt();
		long x[]=new long[q];
		int k[]=new int[q];
		long res[]=new long[q];
		for (int i = 0; i < q; i++) {
			x[i]=scanner.nextLong();
			k[i]=scanner.nextInt();
			res[i]=numOfparent(x[i], k[i]);
		}
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
	}
	
	public static long numOfparent(long x,int k) {
		int cengshu=0;
		long temp=x;
		while(temp!=0) {
			temp=temp>>1;
			cengshu++;
		}
		long res=x;
		if(cengshu<=k) {
			return -1;
		}
		while(cengshu-k!=0) {
			res=res>>1;
			cengshu--;
		}
		return res;
	}
}
