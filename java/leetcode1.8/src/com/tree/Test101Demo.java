package com.tree;

import java.util.*;

public class Test101Demo {
	public static void main(String[] args) {
		System.out.println("helloworld");
	}
}

class Solution101 {
	
	//队列，类似广度优先，迭代
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null){
            return true;
        }
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode temp1=queue.remove();
            TreeNode temp2=queue.remove();
            if(temp1==null&&temp2==null){
                continue;
            }
            if(temp1==null||temp2==null){
                return false;
            }

            if(temp1.val!=temp2.val){
                return false;
            }

            queue.add(temp1.left);
            queue.add(temp2.right);
            queue.add(temp1.right);
            queue.add(temp2.left);

        }

        return true;
    }
    
    //递归
    public boolean isSymmetric2(TreeNode root) {
    	return isMirror(root,root);
    }
    
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
}