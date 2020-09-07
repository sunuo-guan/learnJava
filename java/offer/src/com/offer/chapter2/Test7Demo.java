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
    int[] preorder;//���ǰ��������
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();//ֵ��Ӧ��������±�

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
        this.preorder=preorder;
        TreeNode root;
        root=recur(0,0,preorder.length-1);   //�����ǵ��������±�
        return root;
        
    }
    
    /**
     * ����һ������
     * @param preRoot  ǰ������и��ڵ���±�
     * @param inLeft   �������������ߵ��±�
     * @param inRight  ������������ұߵ��±�
     * @return
     */
    public TreeNode recur(int preRoot,int inLeft,int inRight) {
    	//�˳��ݹ�����
    	if(inLeft>inRight) {
    		return null;
    	}
    	
    	int ValOfpreRoot=preorder[preRoot];   //ͨ��������ȡ��ǰ�ڵ��ֵ
    	TreeNode root=new TreeNode(preRoot);   //������ǰ���ڵ�
    	int inParentIndex=map.get(ValOfpreRoot);   //ͨ����ǰ�ڵ��ֵ��ȡ��������и��ڵ���±�
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
