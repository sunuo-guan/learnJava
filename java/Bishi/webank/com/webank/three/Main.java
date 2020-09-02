package com.webank.three;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		Node arr[]=new Node[n];
		for (int i = 0; i < n; i++) {
			int money=scanner.nextInt();
			int times=scanner.nextInt();
			arr[i]=new Node(money, times);
		}
		
		System.out.println(maxMoney(arr));
	}
	
	
	public static int maxMoney(Node arr[]) {
		Arrays.sort(arr);
		
		int totalTimes=1;
		int totalMoney=0;
		
		for(int i=0;i<arr.length;i++) {
			if(totalTimes==0) {
				break;
			}else {
				totalMoney+=arr[i].money;
				totalTimes+=arr[i].times-1;
			}
		}
		
		return totalMoney;
	}
	
	
	public static class Node implements Comparable<Node>{
		int money,times;
		public Node(int money,int times) {
			this.money=money;
			this.times=times;
		}
		public int compareTo(Node temp) {
			if(this.times>temp.times||(this.times==temp.times&&this.money>temp.money)) {
				return -1;
			}else if(this.times==temp.times&&this.money==temp.money){
				return 0;
			}else {
				return 1;
			}
		}
	}
}
