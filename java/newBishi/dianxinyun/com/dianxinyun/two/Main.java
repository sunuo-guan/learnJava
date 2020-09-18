package com.dianxinyun.two;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		if(n<=0) {
			return 0;
		}
		int index2 = 0, index3 = 0, index5 = 0;
		int ugly[] = new int[n];
		ugly[0] = 1;
		for (int i = 1; i < ugly.length; i++) {
			int temp = Math.min(ugly[index2]*2, ugly[index3]*3);
			ugly[i] = Math.min(temp, ugly[index5]*5);
			while(ugly[index2]*2 <= ugly[i]) {
				index2++;
			}
			while(ugly[index3]*3 <= ugly[i]) {
				index3++;
			}
			while(ugly[index5]*5 <= ugly[i]) {
				index5++;
			}
		}
		return ugly[n-1];
	}
}
