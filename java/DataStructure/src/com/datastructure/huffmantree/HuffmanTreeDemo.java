package com.datastructure.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeDemo {
	public static void main(String[] args) {
		int[] array= {1,3,4,8,6,9,5};
		Node root=createHuffmanTree(array);
		preOrder(root);
		
	}
	
	//ǰ�������
	public static void preOrder(Node root) {
		if(root==null) {
			System.out.println("��Ϊ��");
			return;
		}else {
			root.preOrder();
		}
	}
	
	
	//������������
	public static Node createHuffmanTree(int[] arr) {
		List<Node> list =new ArrayList<Node>();  //����һ������
		Node tempNode;
		for (int i = 0; i < arr.length; i++) {   //���������Ľڵ㶼�ӽ�������
			tempNode=new Node(arr[i]);
			list.add(tempNode);
		}
		
		//���ϴ�����ֱ��������ֻ��һ��ֵ����ֵ��Ϊ���ĸ��ڵ�
		while(list.size()>1) {
			Collections.sort(list);      //��С��������
			
			//�ѵ�һ�����ó��� �����½ڵ�
			Node leftNode=list.get(0);
			Node rightNode=list.get(1);
			Node newNode=new Node(leftNode.value+rightNode.value);
			
			//���´�������ɵ������ڵ�������
			newNode.left=leftNode;
			newNode.right=rightNode;
			
			//�ѵ�һ����ɾ�� �������´����Ľڵ�
			list.remove(1);
			list.remove(0);
			list.add(newNode);
		}
		
		//�������һ�� �����ڵ�
		return list.get(0);
	}
}

class Node implements Comparable<Node>{
	public int value;
	public Node right;
	public Node left;
	
	public Node(int value) {
		this.value=value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		//��С��������
		return this.value-o.value;
	}
	
	public void preOrder() {
		System.out.println(this);
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}		
	}
	
}
