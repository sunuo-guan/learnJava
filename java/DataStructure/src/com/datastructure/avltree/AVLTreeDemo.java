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

	//当前节点左子树的高度
	public int leftHeight(Node node) {
		if(this.left==null) {
			return 0;
		}else {
			return height(node.left);
		}
	}
	//当前节点右子树高度
	public int rightHeight(Node Node) {
		if(this.right==null) {
			return 0;
		}else {
			return height(Node.right);
		}
	}
	
	//当前节点的高度
	public int height(Node node) {
		if(node==null) {
			return 0;
		}
		int leftHeight=height(node.left);
		int rightHeight=height(node.right);
		int max=Math.max(leftHeight, rightHeight)+1;  //记得+1
		return max;
		
		//return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
	}
	
	
	/**
	 * 在添加节点时，根据条件判断旋转
	 */
	//左旋转
	private void leftRotate() {
		//创建新节点 赋当前节点的值
		Node newNode=new Node(this.value);
		//新节点左指针指原节点左子树
		newNode.left=this.left;
		//新节点右指针指原节点右子树的左子树
		newNode.right=this.right.left;
		//原节点被赋值为其右子树
		this.value=this.right.value;
		//原节点左指针指新节点
		this.left=newNode;
		//原节点右指针指原节点的右子树的右子树
		this.right=this.right.right;
	}
	
	//右旋转
	private void rightRotate() {
		//类似
		Node newNode=new Node(this.value);
		newNode.left=this.left.right;
		newNode.right=this.right;
		this.value=this.left.value;
		this.left=this.left.left;
		this.right=newNode;
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
		
		//添加之后，看树的情况判断是否需要旋转
		if(rightHeight(this)-leftHeight(this)>1) {
			//若当前节点的右子树的左子树的高度大于当前节点右子树的右子树的高度
			//则要先右子节点右旋再当前节点左旋
			if(this.right!=null&&leftHeight(this.right)>rightHeight(this.left)) {
				this.right.rightRotate();
				this.leftRotate();
			}else {
				this.leftRotate();
			}
			return;  //返回！！
		}
		
		if(leftHeight(this)-rightHeight(this)>1) {
			//若当前节点的左子树的右子树的高度大于当前节点左子树的左子树的高度
			//则要先左节点左旋再当前节点右旋
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