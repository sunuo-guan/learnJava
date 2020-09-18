package com.test;

public class Test538ConvertBSTtoGreaterTree {
	public static void main(String[] args) {
		
	}
	
	public int sum;
	
	//改变遍历顺序
	public TreeNode convertBST(TreeNode root) {
		if(root == null) {
			return root;
		}
		sum = 0;
		rightMidLeftOrder(root);
		return root;
    }
	
	public void rightMidLeftOrder(TreeNode node) {
		if (node.right !=null) {
			rightMidLeftOrder(node.right);
		}
		
		sum += node.val;
		node.val = sum;
		
		if (node.left != null) {
			rightMidLeftOrder(node.left);
		}
	}
}
