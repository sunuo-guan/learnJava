package com.tree;

import java.util.*;

public class Test102Demo {

}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	if(root==null) {
    		return res;
    	}
    	
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	queue.add(root);
    	
    	while(!queue.isEmpty()) {
    		int size=queue.size();
    		for (int i = 0; i < size; i++) {
    			TreeNode temp=queue.remove();
    			if(temp.left!=null) {
        			queue.add(temp.left);
        		}
        		if(temp.right!=null) {
        			queue.add(temp.right);
        		}
        		list.add(temp.val);
			}
    		res.add(new ArrayList<Integer>(list));
    		list.clear();
    	}
    	
    	return res;
    }
}
