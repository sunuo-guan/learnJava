package com.tree;

import java.util.Stack;

public class Test98Demo {
	private static boolean isValid=true;
	public static void main(String[] args) {
		int a=-2147483648;
		double b=Double.MIN_EXPONENT;
		System.out.println(b>=0);
	}
	
    public boolean isValidBST2(TreeNode root) {
    	return recur2(root, null, null);
    			
    }
    
    //�����������������
    public boolean isValidBST(TreeNode root) {
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	TreeNode temp=root;
    	double inorder=-Double.MAX_VALUE;
    	while(temp!=null||!stack.isEmpty()) {
    		while(temp!=null) {
    			stack.push(temp);
    			temp=temp.left;
    		}
    		
    		temp=stack.pop();
    		if(temp.val<=inorder) {
    			return false;
    		}
    		inorder=temp.val;
    		temp=temp.right;
    	}
    	
    	return true;
    }
    
    
    //�ݹ飬ÿ���ڵ㶼Ҫ�Ƚ�һ��ǰ����游�ڵ�
    public boolean recur2(TreeNode node,Integer upper,Integer lower) {
    	if(node==null)
    		return true;
    	
    	int val=node.val;
    	
    	if(lower!=null&&val<=lower)
    		return false;
    	
    	if(upper!=null&&val>=upper)
    		return false;
    	
    	if(!recur2(node.right,val,upper))
    		return false;
    	
    	if(!recur2(node.left,lower,val))
    		return false;
    	
    	return true;
    }
    
    //�˷���������ȫ��֤����5��1��4��n��n��3��6
    public void recur(TreeNode root) {
    	if(root!=null) {
    		if(root.left!=null) {
    			if(root.left.val>=root.val) {
    				isValid=false;
    				return;
    			}
    		}
    		
    		if(root.right!=null) {
    			if(root.right.val<=root.val) {
    				isValid=false;
    				return;
    			}
    		}
    		
    		recur(root.left);
    		recur(root.right);
    	}
    }
}
