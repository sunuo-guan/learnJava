package com.tree;

public class Test124Demo {
	int max=Integer.MIN_VALUE;
	
	public int gain(TreeNode node) {
		if(node==null) {
			return 0;
		}
		
		int leftSum=Math.max(gain(node.left), 0);
		int rightSum=Math.max(gain(node.right), 0);
		
		int newPathSum=node.val+leftSum+rightSum;
		max=Math.max(max, newPathSum);
		
		return node.val+Math.max(leftSum, rightSum);
	}
	
	public int maxPathSum(TreeNode root) {
		gain(root);
		return max;
    }
}
