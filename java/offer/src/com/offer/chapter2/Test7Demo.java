package com.offer.chapter2;

import java.util.HashMap;

public class Test7Demo {
	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		int[] preorder= {3,9,20,15,7};
		int[] inorder= {9,3,15,20,7};
		solution.buildTree(preorder, inorder);
	}
}

//class Solution2 {
//	HashMap<Integer, Integer> dic = new HashMap<>();
//	int[] po;
//
//	public TreeNode buildTree(int[] preorder, int[] inorder) {
//		po = preorder;
//		for (int i = 0; i < inorder.length; i++)
//			dic.put(inorder[i], i);
//		return recur(0, 0, inorder.length - 1);
//	}
//
//	TreeNode recur(int pre_root, int in_left, int in_right) {
//		if (in_left > in_right)
//			return null;
//		TreeNode root = new TreeNode(po[pre_root]);
//		int pot=po[pre_root];
//		int i = dic.get(pot);
//		root.left = recur(pre_root + 1, in_left, i - 1);
//		root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
//		return root;
//	}
//}

class Solution3 {
    int[] preorder;//存放前序遍历结果
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();//值对应的中序的下标

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
        this.preorder=preorder;
        TreeNode root;
        root=recur(0,0,preorder.length-1);   //！！记得输入是下标
        return root;
        
    }
    
    /**
     * 输入一颗子树
     * @param preRoot  前序遍历中根节点的下标
     * @param inLeft   中序遍历中最左边的下标
     * @param inRight  中序遍历中最右边的下标
     * @return
     */
    public TreeNode recur(int preRoot,int inLeft,int inRight) {
    	//退出递归条件
    	if(inLeft>inRight) {
    		return null;
    	}
    	
    	int ValOfpreRoot=preorder[preRoot];   //通过索引获取当前节点的值
    	TreeNode root=new TreeNode(preRoot);   //创建当前父节点
    	int inParentIndex=map.get(ValOfpreRoot);   //通过当前节点的值获取中序遍历中父节点的下标
    	root.left=recur(preRoot+1,inLeft,inParentIndex-1);
    	root.right=recur(inParentIndex-inLeft+preRoot+1,inParentIndex+1,inRight);
    	return root;
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
