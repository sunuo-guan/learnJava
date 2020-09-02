package com.offer.chapter4;

public class Test28Demo {

}

class Solution28 {
    public boolean isSymmetric(TreeNode root) {
    	return isSame(root, root);
    }
    
    /**
     * ǰ�������������ǰ������ľ������У����������Ƿ�һ��
     * �����Ƚ����������Ƿ�һ����һ�ŵ�����Ƿ�==��һ�ŵ��ң����Ƿ�==��
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSame(TreeNode root1,TreeNode root2) {
    	//ȫΪ��
    	if(root1==null&&root2==null) {
    		return true;
    	}
    	
    	//ֻ��һ��Ϊ��
    	if(root1==null||root2==null) {
    		return false;
    	}
    	
    	if(root1.val!=root2.val) {
    		return false;
    	}
    	
    	return isSame(root1.left, root2.right)&&isSame(root1.right, root2.left);
    }
}