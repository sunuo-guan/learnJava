package com.tree;

import java.util.*;

public class Test236Demo {
	public static void main(String[] args) {
		System.out.println("hello world");
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		LinkedList<TreeNode> pQueue=new LinkedList<TreeNode>();
		LinkedList<TreeNode> qQueue=new LinkedList<TreeNode>();
		
		preOrder(root, p, pQueue);
		preOrder(root, q, qQueue);
		
		TreeNode res=new TreeNode(0);
		
		while(!pQueue.isEmpty()&&!qQueue.isEmpty()) {
			TreeNode pTemp=pQueue.removeFirst();
			TreeNode qTemp=qQueue.removeFirst();
			if (pTemp==qTemp) {
				res=pTemp;
			}else {
				break;
			}
		}
		
		return res;
	}
	
	private boolean preOrder(TreeNode root,TreeNode target,LinkedList<TreeNode> queue) {
		queue.addLast(root);
		if(root==target) {
			return true;
		}
		
		boolean hasFound = false;
		if(!hasFound&&root.left!=null) {
			hasFound=preOrder(root.left, target, queue);
		}
		
		if(!hasFound&&root.right!=null) {
			hasFound=preOrder(root.right, target, queue);
		}
		
		if (hasFound) {
			return true;
		}else {
			queue.removeLast();
			return false;
		}
		
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