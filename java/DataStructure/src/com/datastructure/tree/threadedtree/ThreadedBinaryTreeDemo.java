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

		// 先手动添加
		tree.setHead(root); // 设置树根
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

	// 指向当前节点的中序遍历的前一个节点
	private Node pre;

	public void setHead(Node root) {
		this.root = root;
	}

	// 重载
	public void threadedNode() {
		this.threadedNode(root);
	}

	// 中序线索化
	// 将当前节点线索化
	private void threadedNode(Node cur) {
		if (cur == null) {
			return;
		}

		// 1.线索化左子树
		threadedNode(cur.getLeft());
		// 2.线索当前节点

		// 前驱节点
		if (cur.getLeft() == null) {
			cur.setLeft(pre);
			cur.setLeftType(1);
		}

		// 后继节点，通过当前节点的前节点指针设置
		// ！！前一个节点为空时 不用设置后继
		if (pre != null && pre.getRight() == null) {
			pre.setRight(cur);
			pre.setRightType(1);
		}
		// ！！前一个节点指针指向当前
		pre = cur;

		// 3.线索化右子树
		threadedNode(cur.getRight());
	}

	// 中序线索化二叉树遍历
	public void midThreadedShow() {
		if (root == null) {
			System.out.println("树为空");
			return;
		}
		Node cur = root; // 起始位置 根节点

		while (cur != null) {
			// 找左右都为线索指针的节点（叶子节点）当不是叶子节点时 一直往左边找
			while (cur.getLeftType() == 0) {
				cur = cur.getLeft();
			}

			// 找到后输出
			System.out.print(cur.getId() + " ");

			// 如果当前节点的右指针为线索指针，则继续输出
			while (cur.getRightType() == 1) {
				cur = cur.getRight();
				System.out.print(cur.getId() + " ");
			}

			// 如果当前节点右指针不是线索指针，则转到其右子树
			cur = cur.getRight();
		}

	}

	// 前序遍历
	public void preOrder() {
		if (root == null) {
			System.out.println("树为空");
			return;
		}
		root.preOrder();
	}

	public void midOrder() {
		if (root == null) {
			System.out.println("树为空");
			return;
		}
		root.midOrder();
	}

	public void postOrder() {
		if (root == null) {
			System.out.println("树为空");
			return;
		}
		root.postOrder();
	}

	// 前序遍历查找
	public Node preOrderSearch(int id) {
		Node res = null;
		if (this.root != null) {
			res = root.preOrderSearch(id);
		}
		return res;
	}

	// 中序查找
	public Node midOrderSearch(int id) {
		Node res = null;
		if (this.root != null) {
			res = root.midOrderSearch(id);
		}
		return res;
	}

	// 后序查找
	public Node postOrderSearch(int id) {
		Node res = null;
		if (this.root != null) {
			res = root.postOrderSearch(id);
		}
		return res;
	}

	// 删除节点
	public void delNode(int id) {
		// 先判断root是否为空
		if (root == null) {
			System.out.println("此树为空，无法删除");
		} else {
			// 判断root是否是待删除节点
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

	// 若为0，表示子树 若为1 ，表示前驱后继
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

	// 前序遍历
	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// 中序遍历
	public void midOrder() {
		if (this.left != null) {
			this.left.midOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.midOrder();
		}
	}

	// 后序遍历
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}

	// 前序查找
	public Node preOrderSearch(int id) {
		// 接收结果，没找到则为空
		Node res = null;

		if (this.id == id) {
			return this;
		}

		if (this.left != null) {
			res = this.left.preOrderSearch(id); // ！！记得要接收返回值
		}

		// 如果左子树找到，则退出
		if (res != null) {
			return res;
		}

		if (this.right != null) {
			res = this.right.preOrderSearch(id);
		}

		return res;
	}

	// 中序查找
	public Node midOrderSearch(int id) {
		Node res = null;

		// 左节点不为空 则中序遍历
		if (this.left != null) {
			res = this.left.midOrderSearch(id);
		}
		// 找到则返回
		if (res != null) {
			return res;
		}

		// 没找到则检查当前节点
		if (this.id == id) {
			return this;
		}

		// 再没找到则右节点中序遍历
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

	// 删除节点:考虑树id不重复 即只删除一次
	// 简化 叶子节点:直接删除 非叶子节点：整棵子树删除
	public void delNode(int id) {
		// 检查左右是否为待删除 而不是检查自己
		if (this.left != null && this.left.id == id) {
			this.left = null;
			return;
		}
		if (this.right != null && this.right.id == id) {
			this.right = null;
			return;
		}

		// 左右都非待删除 则依次向左右递归
		if (this.left != null) {
			this.left.delNode(id);
			// 这里没有return
		}
		if (this.right != null) {
			this.right.delNode(id);
		}
	}
}
