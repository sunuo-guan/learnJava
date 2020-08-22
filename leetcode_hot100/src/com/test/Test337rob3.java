package com.test;

public class Test337rob3 {
	public static void main(String[] args) {
		
	}
	
    public int rob(TreeNode root) {
    	int result[] = robDp(root);
    	return Math.max(result[0], result[1]);
    }
    
    public int[] robDp(TreeNode node) {
    	if(node == null) {
    		int[] res = {0,0};
    		return res;
    	}
    	
    	int left[] = robDp(node.left);
    	int right[] = robDp(node.right);
    	
    	int[] dp = new int[2];
    	dp[0] = left[1]+right[1]+node.val;
    	dp[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    	
    	return dp;
    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
