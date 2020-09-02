package bishi.meituan.fifth;

import java.util.Scanner;

public class MainFive {
	private static final int constVal=998244353;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = scanner.nextInt();
		}
		int[] sum = new int[N];
		for (int n = 0; n < N; n++) {
			sum[n] = a[n];
		}
		
		for(int k=1;k<=K;k++) {
			for(int n=1;n<N;n++) {
				sum[n]=(sum[n]+sum[n-1])%constVal;
			}
		}
		
		System.out.println(sum[N-1]);
		
	}
}
