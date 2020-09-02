package com.wangyi.two;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int n=scanner.nextInt();
		int defend=scanner.nextInt();
		int gongji[]=new int[n];
		int fangshou[]=new int[n];
		for (int i = 0; i < n; i++) {
			gongji[i]=scanner.nextInt();
		}
		for (int i = 0; i <n; i++) {
			fangshou[i]=scanner.nextInt();
		}
		
		System.out.println(least(n, defend, gongji, fangshou));
	}
	
	public static int least(int n,int defend,int gongji[],int fangshou[]) {
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(gongji[i],fangshou[i]);
		}

		
		Arrays.sort(gongji);
		int index=0;
		int res=0;
		while(gongji[index]<defend) {
			defend++;
			index++;
		}
		
		for (int i = n-1; i > index; i--) {
			if(gongji[i]>defend) {
				res=res+map.get(gongji[i]);
			}			
			defend++;
		}
		
		return res;
		
	}
}


