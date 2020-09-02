package com.offer.chapter4;

public class Test36Demo {
	public static void main(String[] args) {
		Node2 root = new Node2(4);
		Node2 n1 = new Node2(2);
		Node2 n2 = new Node2(5);
		Node2 n3 = new Node2(1);
		Node2 n4 = new Node2(3);
		
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n1.right=n4;
		
		Solution36 solution36 = new Solution36();
		Node2 head=solution36.treeToDoublyList(root);
	}
}

class Solution36 {
	private Node2 head,lastNode;
	
	public Node2 treeToDoublyList(Node2 root) {
		if (root == null) {
			return root;
		}

		lastNode = null;
		treeToLastList(root);

		head.left = lastNode;
		lastNode.right = head;

		return head;

	}

	public void treeToLastList(Node2 node) {   //�������βָ���������ÿ�εݹ�ǰ�����ֵ��Ϊ��
		if (node == null) {
			return;
		}

		Node2 cur = node;

		// ������������������������
		if (cur.left != null) {
			treeToLastList(cur.left);
		}

		cur.left = lastNode;
		if (lastNode != null) {
			lastNode.right = cur;
		}else {
			head=cur;             //��βָ��Ϊ�գ���˽ڵ�Ϊ˫����ĵ�һ���ڵ�
		}
		lastNode = cur;

		if (cur.right != null) {
			treeToLastList(cur.right);
		}
	}
}

class Node2 {
	public int val;
	public Node2 left;
	public Node2 right;

	public Node2() {
	}

	public Node2(int _val) {
		val = _val;
	}

	public Node2(int _val, Node2 _left, Node2 _right) {
		val = _val;
		left = _left;
		right = _right;
	}
}