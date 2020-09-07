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
     * ���ݹ˿����Լ�����˿��Ŷ�˳��
     * @param a int����һά���� �˿�a����
     * @param b int����һά���� �˿�b����
     * @return int����һά����
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