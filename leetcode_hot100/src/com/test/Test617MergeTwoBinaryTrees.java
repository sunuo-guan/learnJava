package com.test;

public class Test617MergeTwoBinaryTrees {
	public static void main(String[] args) {
		TreeNode temp1 = new TreeNode(1);
		temp1.left = new TreeNode(3);
		temp1.right = new TreeNode(2);
		temp1.left.left = new TreeNode(5);
		TreeNode temp2 = new TreeNode(2);
		temp2.left = new TreeNode(1);
		temp2.right = new TreeNode(3);
		temp2.left.right = new TreeNode(4);
		temp2.right.right = new TreeNode(7);
		Test617MergeTwoBinaryTrees test = new Test617MergeTwoBinaryTrees();
		TreeNode res = test.mergeTrees(temp1, temp2);
	}
	
	//可优化
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	if(t1 == null)
    		return t2;
    	if(t2 == null)
    		return t1;
    	
    	TreeNode res = merge(t1, t2);
    	return res;
    }
    
    public TreeNode merge(TreeNode t1, TreeNode t2) {
    	if(t1 == null && t2 == null)
    		return null;
    	
    	int t1Val,t2Val;
    	t1Val = t1 == null?0:t1.val;
    	t2Val = t2 == null?0:t2.val;
    	
    	int newVal = t1Val + t2Val;
    	TreeNode temp = new TreeNode(newVal);
    	
    	TreeNode t1Temp = t1 == null?null:t1.left;
    	TreeNode t2Temp = t2 == null?null:t2.left;
    	temp.left = merge(t1Temp,t2Temp);
    	t1Temp = t1 == null?null:t1.right;
    	t2Temp = t2 == null?null:t2.right;
    	temp.right = merge(t1Temp,t2Temp);
    	return temp;
    }
}
