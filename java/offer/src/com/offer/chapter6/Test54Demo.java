package com.offer.chapter6;

public class Test54Demo {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(2);
		
		root.left=t2;
		root.right=t1;
		t2.right=t3;
		
		Solution solution = new Solution();
		
		System.out.println(solution.kthLargest(root, 1));
	}
}

class Solution {
	private int count;

	public int kthLargest(TreeNode root, int k) {
		count = k;
		TreeNode target;
		target=midSearch(root);
		
		return target.val;
	}

	private TreeNode midSearch(TreeNode node) {
		if (node == null) {
			return null;
		}
		
		TreeNode target=null;
		
		if (node.right != null) {
			target=midSearch(node.right);
		}
		
		//！！注意判断target是否已经有返回值，若有返回值则表明已经找到，不再判断
		if(target==null) {
			if (count != 1) {
				count--;
			} else {
				target= node;
			}
		}		

		if (target==null&&node.left != null) {
			target=midSearch(node.left);
		}
		
		return target;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
