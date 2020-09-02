package com.tree;

import java.util.*;

public class Test94Demo {
	public static void main(String[] args) {

	}
	
	/*
	 * 中序迭代遍历：
	 * 栈S;
	 * p= root;
	 * while(p || S不空){
	 *  while(p){
	 *  	 p入S;
	 *  	 p = p的左子树;
	 *  }
	 *  p = S.top 出栈;
	 *  访问p;
	 *   p = p的右子树;
	 *}
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        
        while(node!=null||!stack.isEmpty()) {
        	while(node!=null) {
        		stack.push(node);
        		node=node.left;
        	}
        	node=stack.pop();
        	list.add(node.val);
        	node=node.right;
        	
        }
        
        return list;
    }
	
	/*
	 * 前序迭代遍历
	 * 栈S;
	 * p= root;
	 * while(p || S不空){
	 * 		while(p){
	 * 			访问p节点；
	 * 			p的右子树入S;
	 * 			p = p的左子树;
	 * 		}
	 * 	p = S栈顶弹出;
	 *}
	 */
	
	public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        
        while(node!=null||!stack.isEmpty()) {
        	while(node!=null) {
        		list.add(node.val);
        		node=node.left;
        		stack.push(node.right);
        	}
        	node=stack.pop();
        }
        
        return list;
    }
	
	/**
	 * 栈S;
	 * p= root;
	 * while(p || S不空){
	 * 		while(p){
	 * 			访问p节点；
	 * 			p的左子树入S;
	 * 			p = p的右子树;
	 * 		}
	 * p = S栈顶弹出;
	 * }
	 * 结果序列逆序;
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        Stack<Integer> res=new Stack<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        
        while(node!=null||!stack.isEmpty()) {
        	while(node!=null) {
        		res.push(node.val);
        		node=node.right;
        		stack.push(node.left);
        	}
        	node=stack.pop();
        }
        
        while(!res.isEmpty()) {
        	list.add(res.pop());
        }
        
        return list;
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