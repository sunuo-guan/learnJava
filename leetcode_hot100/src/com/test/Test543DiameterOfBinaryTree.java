package com.test;

public class Test543DiameterOfBinaryTree {
	int res;
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null) {
			return 0;
		}
		res = 1;
		depth(root);
		return res - 1;
    }
	
	public int depth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int left = depth(node.left);
		int right = depth(node.right);
		int sum = left + right + 1;
		res = Math.max(res, sum);
		return Math.max(left, right) + 1;
	}
}
