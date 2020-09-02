package bishi.baidu.first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		int[] a=new int[n];
		int[] b=new int[n];
		for (int i = 0; i < n; i++) {
			a[i]=scanner.nextInt();
		}
		for(int i=0;i<n;i++) {
			b[i]=scanner.nextInt();
		}
		
		System.out.println(grade(n, m, a, b));
	}
	
	public static int grade(int n,int m,int a[],int b[]) {
		HashMap<Integer,Integer> bmap=new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			bmap.put(b[i], a[i]);
		}
		
		Arrays.sort(b);
		Arrays.sort(a);
		
		int res=0;
		int dp[][]=new int[n+1][n+1];
		for(int i=1;i<=n;++i)
		{
			dp[i-1][0]=0;//¸³³õÖµ
			for(int j=1;j<=n;++j)
			{
				dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+bmap.get(b[n-i])-b[n-i]*(j-1));
			}
		}
		res=dp[n][m];
		
		return res;
	}
}
