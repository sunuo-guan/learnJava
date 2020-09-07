package com.wangyihuyu.four;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int boxes[][]= {{5,4,3}, {5,4,5}, {6,6,6}};
		Solution solution = new Solution();
		System.out.println(solution.maxBoxes(boxes));
	}
}

class Solution {
    /**
     * 
     * @param boxes int整型二维数组 
     * @return int整型
     */
    public int maxBoxes (int[][] boxes) {
        // write code here
    	Node arr[]=new Node[boxes.length];
    	for (int i = 0; i < boxes.length; i++) {
			arr[i]=new Node(boxes[i][0],boxes[i][1],boxes[i][2]);
		}
    	
    	Arrays.sort(arr);
    	
    	int dp[]=new int[boxes.length];
    	dp[0]=1;
    	
    	int res=1;
    	for(int i=1;i<boxes.length;i++) {
    		int max=1;
    		for (int j = 0; j < i; j++) {
				if(canContain(arr[i],arr[j])) {
					max=Math.max(max, dp[j]+1);
				}
			}
    		dp[i]=max;
    		res=Math.max(res, dp[i]);
    	}
    	
    	return res;
    	
    }
    
    public boolean canContain(Node first,Node second) {
    	if(first.h>second.h&&first.w>second.w&&first.h>second.h) {
    		return true;
    	}else {
    		return false;
    	} 	
    }
    
    public static class Node implements Comparable<Node>{
		int l,w,h;
		public Node(int l,int w,int h) {
			this.l=l;
			this.w=w;
			this.h=h;
		}
		public int compareTo(Node temp) {
			if(this.l > temp.l || (this.l == temp.l && this.w > temp.w) || (this.l == temp.l && this.w == temp.w && this.h > temp.h)) {
				return 1;
			}else {
				return -1;
			}
		}
	}
}
