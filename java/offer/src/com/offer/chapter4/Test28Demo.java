package com.offer.chapter4;

public class Test28Demo {

}

class Solution28 {
    public boolean isSymmetric(TreeNode root) {
    	return isSame(root, root);
    }
    
    /**
     * 前序遍历的序列与前序遍历的镜像序列（即中右左）是否一样
     * 即，比较两颗树根是否一样，一颗的左边是否==另一颗的右，右是否==左
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSame(TreeNode root1,TreeNode root2) {
    	//全为空
    	if(root1==null&&root2==null) {
    		return true;
    	}
    	
    	//只有一个为空
    	if(root1==null||root2==null) {
    		return false;
    	}
    	
    	if(root1.val!=root2.val) {
    		return false;
    	}
    	
    	return isSame(root1.left, root2.right)&&isSame(root1.right, root2.left);
    }
}