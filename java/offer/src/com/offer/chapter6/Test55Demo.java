package com.offer.chapter6;

public class Test55Demo {

}

class Solution55 {
	private boolean isBal=true;
	
	/**
	 * ��ȣ�����������������+1��
	 * @param root
	 * @return
	 */
    public int maxDepth(TreeNode root) {
    	if(root==null) {
    		return 0;
    	}
    	
    	int left=maxDepth(root.left);
    	int right=maxDepth(root.right);
    	
    	return Math.max(left, right)+1;
    	
    }
    
    /**
     * �ж��Ƿ���ƽ�������
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
    	height(root);
    	return isBal;
    }
    
    private int height(TreeNode node) {
    	if(node==null||!isBal) {
    		return 0;
    	}
    	
    	//�������
    	int left=height(node.left);
    	int right=height(node.right);
    	if(Math.abs(left-right)>1) {
    		isBal=false;
    	}
    	
    	return 1+Math.max(left, right);
    }
}