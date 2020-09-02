package com.tree;

import java.util.*;

public class Test94Demo {
	public static void main(String[] args) {

	}
	
	/*
	 * �������������
	 * ջS;
	 * p= root;
	 * while(p || S����){
	 *  while(p){
	 *  	 p��S;
	 *  	 p = p��������;
	 *  }
	 *  p = S.top ��ջ;
	 *  ����p;
	 *   p = p��������;
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
	 * ǰ���������
	 * ջS;
	 * p= root;
	 * while(p || S����){
	 * 		while(p){
	 * 			����p�ڵ㣻
	 * 			p����������S;
	 * 			p = p��������;
	 * 		}
	 * 	p = Sջ������;
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
	 * ջS;
	 * p= root;
	 * while(p || S����){
	 * 		while(p){
	 * 			����p�ڵ㣻
	 * 			p����������S;
	 * 			p = p��������;
	 * 		}
	 * p = Sջ������;
	 * }
	 * �����������;
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