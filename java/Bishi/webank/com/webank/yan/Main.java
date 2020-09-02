package com.webank.yan;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			int temp = i * a;     
			int x = n - i;
			int mm=m;
			while (mm % x != 0) {
				mm++;
				temp += b;
			}
			if (temp < ans)
				ans = temp;
		}
		System.out.print(ans);

	}
}
