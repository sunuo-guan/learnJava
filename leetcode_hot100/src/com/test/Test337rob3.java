package com.test;

public class Test337rob3 {
	public static void main(String[] args) {
		
	}
	
    public int rob(TreeNode root) {
    	int result[] = robDp(root);
    	return Math.max(result[0], result[1]);
    }
    
    /*
     * 两种情况：
     * 当前节点偷：子节点都不能偷（dp[0]）
     * 当前节点不偷：子节点可以偷可以不偷（dp[1]），根据子节点的偷（dp[0]）或不偷（dp[1]）的最大值进行选择
     */
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
