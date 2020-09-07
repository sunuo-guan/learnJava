package com.offer.chapter6;

public class Test64Demo {
	public static void main(String[] args) {
		System.out.println(sumNums(100));
	}
	
    public static int sumNums(int n) {
//        if(n<=0) {
//        	return 0;
//        }
//        return n+sumNums(n-1);
        
        int sum=n;
        boolean recur=n>0&&(sum=sum+sumNums(n-1))>0;
        return sum;
    }
}
