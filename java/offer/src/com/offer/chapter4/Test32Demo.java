package com.offer.chapter4;

import java.util.*;

public class Test32Demo {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		root.left = n1;
		root.right = n2;
		n2.left = n3;
		n2.right = n4;
		Solution32 solution32 = new Solution32();
		List<List<Integer>> result = solution32.levelOrder3(root);
	}
}

class Solution32 {

	// 与图的广度遍历类似
	public int[] levelOrder(TreeNode root) {
		if (root == null) {
			return new int[] {};
		}
		ArrayList<TreeNode> tree = new ArrayList<TreeNode>();
		LinkedList<Integer> res = new LinkedList<Integer>();

		tree.add(root);
		res.addLast(root.val);
		while (!tree.isEmpty()) {
			TreeNode temp = tree.remove(0);
			if (temp.left != null) {
				tree.add(temp.left);
				res.addLast(temp.left.val);
			}
			if (temp.right != null) {
				tree.add(temp.right);
				res.addLast(temp.right.val);
			}

		}
		int result[] = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}
		return result;
	}

	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		LinkedList<TreeNode> tree = new LinkedList<TreeNode>();
		// LinkedList<Integer> res = new LinkedList<Integer>();

		tree.add(root);
		int level = 0;
		while (!tree.isEmpty()) {
			result.add(new ArrayList<Integer>());

			//for (int i = 0; i < tree.size(); i++) {  不能这样写，tree的大小会在循环里有变化
			int treeSize=tree.size();
			for (int i = 0; i < treeSize; i++) {
				TreeNode temp = tree.remove(0);
				result.get(level).add(temp.val);
				if (temp.left != null) {
					tree.add(temp.left);

				}
				if (temp.right != null) {
					tree.add(temp.right);

				}
			}	
			level++;
		}

		return result;
	}
	
	/**
	 * 两个栈解决：一个栈弹父节点，另一个栈压入子节点
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder3(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		//LinkedList<TreeNode> tree = new LinkedList<TreeNode>();
		// LinkedList<Integer> res = new LinkedList<Integer>();
		Stack<TreeNode> stack1=new Stack<TreeNode>();
		Stack<TreeNode> stack2=new Stack<TreeNode>();

		stack1.push(root);
		int level = 0;
		while (!stack1.isEmpty()||!stack2.isEmpty()) {
			if(stack2.isEmpty()) {
				result.add(new ArrayList<Integer>());
				int satck1Size=stack1.size();
				for (int i = 0; i < satck1Size; i++) {
					TreeNode temp = stack1.pop();
					result.get(level).add(temp.val);
					if (temp.left != null) {
						stack2.push(temp.left);

					}
					if (temp.right != null) {
						stack2.push(temp.right);

					}
				}	
				level++;
			}else if(stack1.isEmpty()) {
				result.add(new ArrayList<Integer>());
				int satck2Size=stack2.size();
				for (int i = 0; i < satck2Size; i++) {
					TreeNode temp = stack2.pop();
					result.get(level).add(temp.val);
					if (temp.right != null) {
						stack1.push(temp.right);

					}
					if (temp.left != null) {
						stack1.push(temp.left);

					}
				}
				level++;
			}else {
				break;
			}
			
		}

		return result;
	}
	
}