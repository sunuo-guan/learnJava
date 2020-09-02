package com.offer.chapter4;

public class Test27Demo {
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Solution27 {
	public TreeNode mirrorTree(TreeNode root) {
		if(root==null) {
			return null;
		}
		
		exchange(root);
		return root;
		
	}
	
	public void exchange(TreeNode root) {
		if(root==null) {
			return;
		}
		
		TreeNode temp;
		//½»»»
		temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		//±éÀú×óÓÒ×ÓÊ÷
		exchange(root.left);
		exchange(root.right);
		
	}
}