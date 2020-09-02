package bishi.baidu.fifth;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int x=scanner.nextInt();
		int y=scanner.nextInt();
		int[] coin=new int[N];
		for (int i = 0; i < N; i++) {
			coin[i]=scanner.nextInt();
		}
		
		System.out.println(fancoin(N, x, y, coin));
	}
	
	public static int fancoin(int N,int x,int y,int[] coin) {		
		int index=0;
		int numOf0=0,numOf1=0;
		while(index<N) {
			if(coin[index]==0) {
				numOf0++;
			}
			while(index<N&&coin[index]==0) {
				index++;
			}
			if(index<N&&coin[index]==1) {
				numOf1++;
			}
			while(index<N&&coin[index]==1) {
				index++;
			}
		}
		
		int costX=numOf0*x;
		int costY=numOf1*x+y;
		
		return Math.min(costX, costY);
	}
}
