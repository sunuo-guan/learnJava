package com.tree;

import java.util.*;

public class Test105Demo {

}

class Solution105 {
	HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
    	TreeNode root=build(preorder, inorder, 0, 0, inorder.length-1);
    	return root;
    }
    
    public TreeNode build(int[] preorder, int[] inorder,int preRoot,int inLeft,int inRight) {
    	if(inLeft>inRight) {
    		return null;
    	}
    	TreeNode root=new TreeNode(preorder[preRoot]);
    	int inRoot=map.get(preorder[preRoot]);
    	root.left=build(preorder, inorder, preRoot+1, inLeft, inRoot-1);
    	root.right=build(preorder, inorder, preRoot+(inRoot-inLeft)+1, inRoot+1, inRight);
    	return root;
    }
}