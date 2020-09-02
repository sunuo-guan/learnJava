package com.datastructure.binarysorttree;

public class BinarySortTreeDemo {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 6, 4, 8, 11, 2 };
		BinarySortTree tree = new BinarySortTree();
		Node temp;
		for (int i = 0; i < arr.length; i++) {
			temp = new Node(arr[i]);
			tree.add(temp);
		}
		tree.midOrder();
		System.out.println("************");
		int value = 11;
		tree.delNode(value);
		tree.midOrder();

	}
}

class BinarySortTree {
	public Node root;

	public void add(Node node) {
		// 若根为空，则直接添加到根
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	// 中序遍历 则输出有序数组
	public void midOrder() {
		root.midOrder();
	}

	// 删除节点
	/*
	 * 1.叶子节点：直接删除 2.只有一颗子树的节点：删除目标节点，子树顶上目标节点的位置
	 * 3.有两颗子树的节点：从目标节点的右子树找到最小值（不断向左遍历）顶替目标节点， 或者从目标节点的左子树找到最大值（不断向右遍历）顶替目标节点
	 */
	public void delNode(int value) {
		if (root == null) {
			System.out.println("树为空，无法删除");
		}

		Node parent = root.searchParent(value);
		Node target = root.searchTarget(value);

		if (target == null) {
			System.out.println("没有找到目标节点，不能执行删除");
			return;
		}

		if (root.left == null && root.right == null) {
			root = null;
			System.out.println("整棵树删除");
			return;
		}

		if (target.left == null && target.right == null) { // 目标节点是叶子节点
			if (parent.left != null && parent.left.value == target.value) { // 叶子节点在父节点左子树
				parent.left = null;
			}
			if (parent.right != null && parent.right.value == target.value) { // 叶子节点在父节点左子树
				parent.right = null;
			}
		} else if (target.left != null && target.right != null) { // 目标节点有两个子树
			int minValue = delRightMin(target.right); // 找到右子树最小节点并删除
			target.value = minValue; // 最小值赋给目标节点

		} else { // 目标节点有一个子树
			// 先判断目标节点的子树是左子树还是右子树
			if (target.left != null) {
				//！！注意，此处要考虑没有父节点的情况
				if(parent!=null) {
					// 再判断目标节点在父节点的左还是右
					if (parent.left != null && parent.left.value == target.value) {
						parent.left = target.left;
					} else {
						parent.right = target.left;
					}
				}else {
					root=target.left;
				}
				
			} else {
				//！！注意，此处要考虑没有父节点的情况
				if(parent!=null) {
					// 再判断目标节点在父节点的左还是右
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
	 * 用于目标节点有两个子树的情况 在目标节点的右子树一直向左找最小的值，执行交换和删除 返回最小的值
	 */
	public int delRightMin(Node rightNode) {
		Node temp = rightNode;
		while (temp.left != null) {
			temp = temp.left;
		}
		int min = temp.value;
		delNode(min); // 为什么可以删除？此时最小节点左子树肯定为空，只存在自己为叶子节点或只有右子树的两种情况
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

	// 添加节点 递归
	public void add(Node node) {
		// 待添加比当前小
		if (node.value < this.value) {
			if (this.left == null) { // 若为空，则直接添加
				this.left = node;
			} else { // 不为空，则递归添加
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
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

	// 查找要删除的节点
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

	// 查找要删除节点的父节点
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