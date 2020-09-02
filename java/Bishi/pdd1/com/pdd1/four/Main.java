package com.pdd1.four;

import java.util.*;

import com.webank.three.Main.Node;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int arr[]=new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=scanner.nextInt();
		}
		
		System.out.println();
		
	}
	
	public static int longest(int n,int k,int arr[]) {
		int i=0;
		ArrayList<Node> list=new ArrayList<Node>();
		while(i<n) {
			int longs=0;
			int end=0;
			while(i+end<n&&arr[i]==arr[i+end]) {
				end++;
				longs++;
			}
			list.add(new Node(arr[i],longs));
			i=i+end;
		}
		
		return 0;
	}
	
	public static class Node{
		int val,longs;
		public Node(int val,int longs) {
			this.val=val;
			this.longs=longs;
		}
//		public int compareTo(Node temp) {
//			if(this.times>temp.times||(this.times==temp.times&&this.money>temp.money)) {
//				return -1;
//			}else if(this.times==temp.times&&this.money==temp.money){
//				return 0;
//			}else {
//				return 1;
//			}
//		}
	}
	
}
