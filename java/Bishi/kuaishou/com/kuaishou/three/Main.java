package com.kuaishou.three;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int a[]= {8,9,7};
		int b[]= {5,8,3};
		int arr[]=solution.WaitInLine(a, b);
		System.out.println();
	}
}

class Solution {
    /**
     * 根据顾客属性计算出顾客排队顺序
     * @param a int整型一维数组 顾客a属性
     * @param b int整型一维数组 顾客b属性
     * @return int整型一维数组
     */
    public int[] WaitInLine (int[] a, int[] b) {
        // write code here
    	Node arr[]=new Node[a.length];
    	for (int i = 0; i < b.length; i++) {
			arr[i]=new Node(a[i],b[i],i+1);
		}
    	
    	int len=a.length;
    	
    	Arrays.sort(arr);
    	
    	int res[]=new int[len];
    	
    	for (int i = 0; i < res.length; i++) {
			res[i]=arr[i].no;
		}
    	
    	return res;
    	
    }
    
    private class Node implements Comparable<Node>{
		int a,b,no;
		public Node(int a,int b,int no) {
			this.a=a;
			this.b=b;
			this.no=no;
		}
		public int compareTo(Node temp) {
			if(b+temp.a>a+temp.b) {
				return 1;
			}else {
				return -1;
			}
		}
	}
}