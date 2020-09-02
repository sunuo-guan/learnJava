package com.datastructure.tree.threadedtree;

public class ThreadedBinaryTreeDemo {
	public static void main(String[] args) {
		ThreadedBinaryTree tree = new ThreadedBinaryTree();
		Node root = new Node(1, "tom");
		Node node1 = new Node(3, "jerry");
		Node node2 = new Node(6, "mike");
		Node node3 = new Node(8, "jonh");
		Node node4 = new Node(10, "lily");
		Node node5 = new Node(14, "lily");

		// ���ֶ����
		tree.setHead(root); // ��������
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);

		tree.threadedNode();

		System.out.println(node4.getLeft());
		System.out.println(node4.getRight());
		
		tree.midThreadedShow();

	}
}

class ThreadedBinaryTree {
	private Node root;

	// ָ��ǰ�ڵ�����������ǰһ���ڵ�
	private Node pre;

	public void setHead(Node root) {
		this.root = root;
	}

	// ����
	public void threadedNode() {
		this.threadedNode(root);
	}

	// ����������
	// ����ǰ�ڵ�������
	private void threadedNode(Node cur) {
		if (cur == null) {
			return;
		}

		// 1.������������
		threadedNode(cur.getLeft());
		// 2.������ǰ�ڵ�

		// ǰ���ڵ�
		if (cur.getLeft() == null) {
			cur.setLeft(pre);
			cur.setLeftType(1);
		}

		// ��̽ڵ㣬ͨ����ǰ�ڵ��ǰ�ڵ�ָ������
		// ����ǰһ���ڵ�Ϊ��ʱ �������ú��
		if (pre != null && pre.getRight() == null) {
			pre.setRight(cur);
			pre.setRightType(1);
		}
		// ����ǰһ���ڵ�ָ��ָ��ǰ
		pre = cur;

		// 3.������������
		threadedNode(cur.getRight());
	}

	// ��������������������
	public void midThreadedShow() {
		if (root == null) {
			System.out.println("��Ϊ��");
			return;
		}
		Node cur = root; // ��ʼλ�� ���ڵ�

		while (cur != null) {
			// �����Ҷ�Ϊ����ָ��Ľڵ㣨Ҷ�ӽڵ㣩������Ҷ�ӽڵ�ʱ һֱ�������
			while (cur.getLeftType() == 0) {
				cur = cur.getLeft();
			}

			// �ҵ������
			System.out.print(cur.getId() + " ");

			// �����ǰ�ڵ����ָ��Ϊ����ָ�룬��������
			while (cur.getRightType() == 1) {
				cur = cur.getRight();
				System.out.print(cur.getId() + " ");
			}

			// �����ǰ�ڵ���ָ�벻������ָ�룬��ת����������
			cur = cur.getRight();
		}

	}

	// ǰ�����
	public void preOrder() {
		if (root == null) {
			System.out.println("��Ϊ��");
			return;
		}
		root.preOrder();
	}

	public void midOrder() {
		if (root == null) {
			System.out.println("��Ϊ��");
			return;
		}
		root.midOrder();
	}

	public void postOrder() {
		if (root == null) {
			System.out.println("��Ϊ��");
			return;
		}
		root.postOrder();
	}

	// ǰ���������
	public Node preOrderSearch(int id) {
		Node res = null;
		if (this.root != null) {
			res = root.preOrderSearch(id);
		}
		return res;
	}

	// �������
	public Node midOrderSearch(int id) {
		Node res = null;
		if (this.root != null) {
			res = root.midOrderSearch(id);
		}
		return res;
	}

	// �������
	public Node postOrderSearch(int id) {
		Node res = null;
		if (this.root != null) {
			res = root.postOrderSearch(id);
		}
		return res;
	}

	// ɾ���ڵ�
	public void delNode(int id) {
		// ���ж�root�Ƿ�Ϊ��
		if (root == null) {
			System.out.println("����Ϊ�գ��޷�ɾ��");
		} else {
			// �ж�root�Ƿ��Ǵ�ɾ���ڵ�
			if (root.getId() == id) {
				root = null;
			} else {
				root.delNode(id);
			}
		}
	}
}

class Node {
	private int id;
	private String name;
	private Node left;
	private Node right;

	// ��Ϊ0����ʾ���� ��Ϊ1 ����ʾǰ�����
	private int leftType;
	private int rightType;

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public Node(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	// ǰ�����
	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// �������
	public void midOrder() {
		if (this.left != null) {
			this.left.midOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.midOrder();
		}
	}

	// �������
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}

	// ǰ�����
	public Node preOrderSearch(int id) {
		// ���ս����û�ҵ���Ϊ��
		Node res = null;

		if (this.id == id) {
			return this;
		}

		if (this.left != null) {
			res = this.left.preOrderSearch(id); // �����ǵ�Ҫ���շ���ֵ
		}

		// ����������ҵ������˳�
		if (res != null) {
			return res;
		}

		if (this.right != null) {
			res = this.right.preOrderSearch(id);
		}

		return res;
	}

	// �������
	public Node midOrderSearch(int id) {
		Node res = null;

		// ��ڵ㲻Ϊ�� ���������
		if (this.left != null) {
			res = this.left.midOrderSearch(id);
		}
		// �ҵ��򷵻�
		if (res != null) {
			return res;
		}

		// û�ҵ����鵱ǰ�ڵ�
		if (this.id == id) {
			return this;
		}

		// ��û�ҵ����ҽڵ��������
		if (this.right != null) {
			res = this.right.midOrderSearch(id);
		}

		return res;
	}

	public Node postOrderSearch(int id) {
		Node res = null;

		if (this.left != null) {
			res = this.left.postOrderSearch(id);
		}
		if (res != null) {
			return res;
		}

		if (this.right != null) {
			res = this.right.postOrderSearch(id);
		}
		if (res != null) {
			return res;
		}

		if (this.id == id) {
			return this;
		}

		return res;
	}

	// ɾ���ڵ�:������id���ظ� ��ֻɾ��һ��
	// �� Ҷ�ӽڵ�:ֱ��ɾ�� ��Ҷ�ӽڵ㣺��������ɾ��
	public void delNode(int id) {
		// ��������Ƿ�Ϊ��ɾ�� �����Ǽ���Լ�
		if (this.left != null && this.left.id == id) {
			this.left = null;
			return;
		}
		if (this.right != null && this.right.id == id) {
			this.right = null;
			return;
		}

		// ���Ҷ��Ǵ�ɾ�� �����������ҵݹ�
		if (this.left != null) {
			this.left.delNode(id);
			// ����û��return
		}
		if (this.right != null) {
			this.right.delNode(id);
		}
	}
}
