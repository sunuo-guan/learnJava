package com.datastructure.tree;

public class ArrBinaryTreeDemo {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6};
		
		ArrBinaryTree tree=new ArrBinaryTree(arr);
		tree.preOrder();
	}
}

//˳��洢������������洢�� ��ǰ�к��� 
//��ȫ������ ��ڵ��±�2n+1 �ҽڵ��±�2n+2
class ArrBinaryTree {
	private int[] arr;

	// ������ ��������
	public ArrBinaryTree(int arr[]) {
		this.arr = arr;
	}
	
	//���� ����ʱ����д��ʼ����0
	public void preOrder() {
		this.preOrder(0);
	}

	// ǰ��
	public void preOrder(int index) {
		// �������û��Ԫ�� ������Ϊ��
		if (arr == null || arr.length == 0) {
			System.out.println("�����");
		} else {
			// ǰ��
			System.out.print(arr[index] + " ");
			// ����
			if (2 * index + 1 < arr.length) { // ��ֹ�������
				preOrder(2 * index + 1);
			}
			//����
			if (2 * index + 2 < arr.length) {
				preOrder(2 * index + 2);
			}
		}
	}
}