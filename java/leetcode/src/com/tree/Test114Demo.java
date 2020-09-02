package com.tree;

public class Test114Demo {

}

class Solution {
    public void flatten(TreeNode root) {
    	TreeNode temp=root;
    	while(temp!=null) {
    		if(temp.left==null) {
    			temp=temp.right;
    		}else {
    			TreeNode leftRight=temp.left;
    			//找到当前节点左子树的最右节点
    			while(leftRight.right!=null) {
    				leftRight=leftRight.right;
    			}
    			//将当前节点的右子树接到最右节点的右边
    			leftRight.right=temp.right;
    			//当前节点的右边接上左边
    			temp.right=temp.left;
    			//而左边则置为空
    			temp.left=null;
    			//改变下一个节点的接法
    			temp=temp.right;
    		}
    	}
    }
}
