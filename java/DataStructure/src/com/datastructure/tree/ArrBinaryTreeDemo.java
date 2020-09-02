package com.datastructure.tree;

public class ArrBinaryTreeDemo {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6};
		
		ArrBinaryTree tree=new ArrBinaryTree(arr);
		tree.preOrder();
	}
}

//顺序存储二叉树：数组存储树 按前中后序 
//完全二叉树 左节点下标2n+1 右节点下标2n+2
class ArrBinaryTree {
	private int[] arr;

	// 构造器 传入数组
	public ArrBinaryTree(int arr[]) {
		this.arr = arr;
	}
	
	//重载 调用时不用写起始参数0
	public void preOrder() {
		this.preOrder(0);
	}

	// 前序
	public void preOrder(int index) {
		// 如果数组没有元素 或数组为空
		if (arr == null || arr.length == 0) {
			System.out.println("数组空");
		} else {
			// 前序
			System.out.print(arr[index] + " ");
			// 向左
			if (2 * index + 1 < arr.length) { // 防止数组溢出
				preOrder(2 * index + 1);
			}
			//向右
			if (2 * index + 2 < arr.length) {
				preOrder(2 * index + 2);
			}
		}
	}
}