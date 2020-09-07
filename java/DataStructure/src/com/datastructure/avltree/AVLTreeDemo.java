package com.datastructure.avltree;


public class AVLTreeDemo {
	public static void main(String[] args) {
		int[] arr = {10,11,7,6,8,9};
		AVLTree tree = new AVLTree();
		Node temp;
		for (int i = 0; i < arr.length; i++) {
			temp = new Node(arr[i]);
			tree.add(temp);
		}
		tree.midOrder();
		System.out.println("************");
		//System.out.println(tree.root.height(tree.root));
	}
}


class AVLTree {
	public Node root;

	public void add(Node node) {
		// ����Ϊ�գ���ֱ����ӵ���
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	// ������� �������������
	public void midOrder() {
		root.midOrder();
	}

	// ɾ���ڵ�
	/*
	 * 1.Ҷ�ӽڵ㣺ֱ��ɾ�� 2.ֻ��һ�������Ľڵ㣺ɾ��Ŀ��ڵ㣬��������Ŀ��ڵ��λ��
	 * 3.�����������Ľڵ㣺��Ŀ��ڵ���������ҵ���Сֵ�������������������Ŀ��ڵ㣬 ���ߴ�Ŀ��ڵ���������ҵ����ֵ���������ұ���������Ŀ��ڵ�
	 */
	public void delNode(int value) {
		if (root == null) {
			System.out.println("��Ϊ�գ��޷�ɾ��");
		}

		Node parent = root.searchParent(value);
		Node target = root.searchTarget(value);

		if (target == null) {
			System.out.println("û���ҵ�Ŀ��ڵ㣬����ִ��ɾ��");
			return;
		}

		if (root.left == null && root.right == null) {
			root = null;
			System.out.println("������ɾ��");
			return;
		}

		if (target.left == null && target.right == null) { // Ŀ��ڵ���Ҷ�ӽڵ�
			if (parent.left != null && parent.left.value == target.value) { // Ҷ�ӽڵ��ڸ��ڵ�������
				parent.left = null;
			}
			if (parent.right != null && parent.right.value == target.value) { // Ҷ�ӽڵ��ڸ��ڵ�������
				parent.right = null;
			}
		} else if (target.left != null && target.right != null) { // Ŀ��ڵ�����������
			int minValue = delRightMin(target.right); // �ҵ���������С�ڵ㲢ɾ��
			target.value = minValue; // ��Сֵ����Ŀ��ڵ�

		} else { // Ŀ��ڵ���һ������
			// ���ж�Ŀ��ڵ������������������������
			if (target.left != null) {
				//����ע�⣬�˴�Ҫ����û�и��ڵ�����
				if(parent!=null) {
					// ���ж�Ŀ��ڵ��ڸ��ڵ��������
					if (parent.left != null && parent.left.value == target.value) {
						parent.left = target.left;
					} else {
						parent.right = target.left;
					}
				}else {
					root=target.left;
				}
				
			} else {
				//����ע�⣬�˴�Ҫ����û�и��ڵ�����
				if(parent!=null) {
					// ���ж�Ŀ��ڵ��ڸ��ڵ��������
					if (parent.left != null && parent.left.value == target.value) {
						parent.left = target.right;
					} else {
						parent.right = target.right;
					}
				}else {
					root=target.right;
				}
			}
		}
	}

	/**
	 * ����Ŀ��ڵ���������������� ��Ŀ��ڵ��������һֱ��������С��ֵ��ִ�н�����ɾ�� ������С��ֵ
	 */
	public int delRightMin(Node rightNode) {
		Node temp = rightNode;
		while (temp.left != null) {
			temp = temp.left;
		}
		int min = temp.value;
		delNode(min); // Ϊʲô����ɾ������ʱ��С�ڵ��������϶�Ϊ�գ�ֻ�����Լ�ΪҶ�ӽڵ��ֻ�����������������
		return min;
	}

}

class Node {
	public int value;
	public Node left;
	public Node right;

	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	//��ǰ�ڵ��������ĸ߶�
	public int leftHeight(Node node) {
		if(this.left==null) {
			return 0;
		}else {
			return height(node.left);
		}
	}
	//��ǰ�ڵ��������߶�
	public int rightHeight(Node Node) {
		if(this.right==null) {
			return 0;
		}else {
			return height(Node.right);
		}
	}
	
	//��ǰ�ڵ�ĸ߶�
	public int height(Node node) {
		if(node==null) {
			return 0;
		}
		int leftHeight=height(node.left);
		int rightHeight=height(node.right);
		int max=Math.max(leftHeight, rightHeight)+1;  //�ǵ�+1
		return max;
		
		//return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
	}
	
	
	/**
	 * ����ӽڵ�ʱ�����������ж���ת
	 */
	//����ת
	private void leftRotate() {
		//�����½ڵ� ����ǰ�ڵ��ֵ
		Node newNode=new Node(this.value);
		//�½ڵ���ָ��ָԭ�ڵ�������
		newNode.left=this.left;
		//�½ڵ���ָ��ָԭ�ڵ���������������
		newNode.right=this.right.left;
		//ԭ�ڵ㱻��ֵΪ��������
		this.value=this.right.value;
		//ԭ�ڵ���ָ��ָ�½ڵ�
		this.left=newNode;
		//ԭ�ڵ���ָ��ָԭ�ڵ����������������
		this.right=this.right.right;
	}
	
	//����ת
	private void rightRotate() {
		//����
		Node newNode=new Node(this.value);
		newNode.left=this.left.right;
		newNode.right=this.right;
		this.value=this.left.value;
		this.left=this.left.left;
		this.right=newNode;
	}
	
	// ��ӽڵ� �ݹ�
	public void add(Node node) {
		// ����ӱȵ�ǰС
		if (node.value < this.value) {
			if (this.left == null) { // ��Ϊ�գ���ֱ�����
				this.left = node;
			} else { // ��Ϊ�գ���ݹ����
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}
		
		//���֮�󣬿���������ж��Ƿ���Ҫ��ת
		if(rightHeight(this)-leftHeight(this)>1) {
			//����ǰ�ڵ�����������������ĸ߶ȴ��ڵ�ǰ�ڵ����������������ĸ߶�
			//��Ҫ�����ӽڵ������ٵ�ǰ�ڵ�����
			if(this.right!=null&&leftHeight(this.right)>rightHeight(this.left)) {
				this.right.rightRotate();
				this.leftRotate();
			}else {
				this.leftRotate();
			}
			return;  //���أ���
		}
		
		if(leftHeight(this)-rightHeight(this)>1) {
			//����ǰ�ڵ�����������������ĸ߶ȴ��ڵ�ǰ�ڵ����������������ĸ߶�
			//��Ҫ����ڵ������ٵ�ǰ�ڵ�����
			if(this.left!=null&&rightHeight(this.left)>leftHeight(this.right)) {
				this.left.leftRotate();
				this.rightRotate();
			}else {
				this.rightRotate();
			}
			return;
		}
	}

	public void midOrder() {
		if (this.left != null) {
			this.left.midOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.midOrder();
		}
	}

	// ����Ҫɾ���Ľڵ�
	public Node searchTarget(int value) {

		if (this.value == value) {
			return this;
		} else if (value < this.value && this.left != null) {
			return this.left.searchTarget(value);
		} else if (value > this.value && this.right != null) {
			return this.right.searchTarget(value);
		} else {
			return null;
		}
	}

	// ����Ҫɾ���ڵ�ĸ��ڵ�
	public Node searchParent(int value) {

		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else if (this.left != null && value < this.value) {
			return this.left.searchParent(value);
		} else if (this.right != null && value > this.value) {
			return this.right.searchParent(value);
		} else {
			return null;
		}
	}

}