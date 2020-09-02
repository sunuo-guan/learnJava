package com.tengxun.three;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <n; i++) {
			int len=scanner.nextInt();
			ArrayList<Integer> temp=new ArrayList<Integer>();
			for (int j = 0; j < len; j++) {				
				temp.add(scanner.nextInt());
			}
			list.add(new ArrayList<Integer>(temp));
			temp.clear();
		}
		
		maxK(k, n, list);
	}
	
	public static void maxK(int k,int n,ArrayList<ArrayList<Integer>> list) {
		while(k>0) {
			int max=Integer.MIN_VALUE;
			int index=0;
			for (int i = 0; i < n; i++) {
				if(list.get(i).size()==0) {
					continue;
				}
				int temp=list.get(i).get(list.get(i).size()-1);
				if(temp>max) {
					max=temp;
					index=i;
				}
			}
			System.out.print(max+" ");
			k--;
			list.get(index).remove(list.get(index).size()-1);
		}		
	}
}
