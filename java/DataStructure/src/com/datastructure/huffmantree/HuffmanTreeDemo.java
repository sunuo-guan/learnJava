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
	
	//前序遍历树
	public static void preOrder(Node root) {
		if(root==null) {
			System.out.println("树为空");
			return;
		}else {
			root.preOrder();
		}
	}
	
	
	//创建哈夫曼树
	public static Node createHuffmanTree(int[] arr) {
		List<Node> list =new ArrayList<Node>();  //创建一个集合
		Node tempNode;
		for (int i = 0; i < arr.length; i++) {   //将数组代表的节点都加进集合内
			tempNode=new Node(arr[i]);
			list.add(tempNode);
		}
		
		//不断创建，直到集合内只有一个值，此值即为最后的根节点
		while(list.size()>1) {
			Collections.sort(list);      //从小到大排序
			
			//把第一二个拿出来 创建新节点
			Node leftNode=list.get(0);
			Node rightNode=list.get(1);
			Node newNode=new Node(leftNode.value+rightNode.value);
			
			//将新创建的与旧的两个节点连起来
			newNode.left=leftNode;
			newNode.right=rightNode;
			
			//把第一二个删除 并加入新创建的节点
			list.remove(1);
			list.remove(0);
			list.add(newNode);
		}
		
		//返回最后一个 即根节点
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
		//从小到大排序
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
