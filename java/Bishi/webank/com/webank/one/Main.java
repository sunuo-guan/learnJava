package com.webank.one;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		
		System.out.println(leastCost(n, m, a, b));
	}
	
	public static int leastCost(int n,int m,int a,int b) {
		if(m%n==0) {
			return 0;
		}
		
		if(n>m) {
			int buy=(n-m)*b;
			int give=(n-m)*a;
			return Math.min(buy, give);
		}
		
		int ifBuyCount=n-(m%n);
		int ifBuyCost=ifBuyCount*b;
		
		int ifGiveCount=0;
		for(int index=n;m%index!=0;index--) {
			ifGiveCount++;
		}
		
		int ifGiveCost=ifGiveCount*a;
		
		return Math.min(ifBuyCost, ifGiveCost);
		
//		int cost=0;
//		for(int i=n;m%i!=0;i--) {
//			int ifBuyCount=i-(m%i);
//			if(i==n) {
//				cost=ifBuyCount*b;
//			}
//			cost=Math.min(cost, ifBuyCount*b+(n-i)*a);
//		}
//		
//		return cost;
		
	}
}
