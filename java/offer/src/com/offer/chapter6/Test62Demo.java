package com.offer.chapter6;

public class Test62Demo {
	public static void main(String[] args) {
		int n=5,m=2;
		System.out.println(lastRemaining(n, m));
	}
	
	public static int lastRemaining(int n, int m) {
		if(n<1||m<1) {
			return -1;
		}
		
		int last=0;
		for(int i=2;i<=n;i++) {
			last=(last+m)%i;
		}
		
		return last;
    }
}
