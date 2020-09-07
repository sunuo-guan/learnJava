package com.offer.chapter3;

public class Test26Demo {
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		
		TreeNode treeNodeTest = new TreeNode(3);
		
		treeNode1.left=treeNode2;
		treeNode1.right=treeNode3;
		treeNode2.left=treeNode4;
		
		Solution26 solution26 = new Solution26();
		System.out.println(solution26.isSubStructure(treeNode1, treeNodeTest));
	}
}

class Solution26 {
	// �����ڵ��Ƿ���ͬ
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if (A == null || B == null) {
			return false;
		}

		boolean res = false;
		if (A.val == B.val) {
			res = isLikelyTree(A, B);
		}
		if (res == false) {
			res = isSubStructure(A.left, B);
		}
		if (res == false) {
			res = isSubStructure(A.right, B);
		}

		return res;
	}

	// �ж������Ƿ����
	private boolean isLikelyTree(TreeNode a, TreeNode b) {
		//˳�����⣡����
		//����ab��Ϊ��ʱ���ж�Ϊfalse�ˣ�Ӧ����true
//		if (a == null) {
//			return false;
//		}
//		if (b == null) {
//			return true;
//		}
		
		//b��Ϊ��aΪ�գ���false
		if (b == null) {
			return true;
		}
		if (a == null) {
			return false;
		}

		if (a.val != b.val) {
			return false;
		}

		return isLikelyTree(a.left, b.left) && isLikelyTree(a.right, b.right);
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