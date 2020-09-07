package com.datastructure.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		Node root=new Node(1, "tom");
		Node node1=new Node(2, "jerry");
		Node node2=new Node(3, "mike");
		Node node3=new Node(4,"jonh");
		Node node4=new Node(5,"lily");
		
		//先手动添加		
		tree.setHead(root);    //设置树根
		root.setLeft(node1);
		root.setRight(node2);
		node2.setRight(node3);
		node2.setLeft(node4);
		
		System.out.println("前序遍历：");
		tree.preOrder();
		System.out.println("*********");
		System.out.println("中序遍历：");
		tree.midOrder();
		System.out.println("*********");
		System.out.println("后序遍历：");
		tree.postOrder();
		
		System.out.println("*********");
		int id=6;
		Node result=null;
		result=tree.preOrderSearch(id);
		if(result!=null) {
			System.out.println("找到："+result);
		}else {
			System.out.println("没有找到");
		}
		
		System.out.println("*********");
		int id2=3;
		tree.delNode(id2);
		tree.preOrder();
		
	}
}

class BinaryTree{
	private Node root;

	public void setHead(Node root) {
		this.root = root;
	}
	
	//前序遍历
	public void preOrder() {
		if(root==null) {
			System.out.println("树为空");
			return;
		}
		root.preOrder();
	}
	
	public void midOrder() {
		if(root==null) {
			System.out.println("树为空");
			return;
		}
		root.midOrder();
	}
	
	public void postOrder() {
		if(root==null) {
			System.out.println("树为空");
			return;
		}
		root.postOrder();
	}
	
	//前序遍历查找
	public Node preOrderSearch(int id) {
		Node res=null;
		if(this.root!=null) {
			res=root.preOrderSearch(id);
		}
		return res;
	}
	
	//中序查找
	public Node midOrderSearch(int id) {
		Node res=null;
		if(this.root!=null) {
			res=root.midOrderSearch(id);
		}
		return res;
	}
	
	//后序查找
	public Node postOrderSearch(int id) {
		Node res=null;
		if(this.root!=null) {
			res=root.postOrderSearch(id);
		}
		return res;
	}
	
	//删除节点
	public void delNode(int id) {
		//先判断root是否为空
		if(root==null) {
			System.out.println("此树为空，无法删除");
		}else {
			//判断root是否是待删除节点
			if(root.getId()==id) {
				root=null;
			}else {
				root.delNode(id);
			}
		}
	}
}

class Node{
	private int id;
	private String name;
	private Node left;
	private Node right;
	
	public Node(int id,String name) {
		this.id=id;
		this.name=name;
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
	
	//前序遍历
	public void preOrder() {
		System.out.println(this);
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
	
	//中序遍历
	public void midOrder() {
		if(this.left!=null) {
			this.left.midOrder();
		}
		System.out.println(this);
		if(this.right!=null) {
			this.right.midOrder();
		}
	}
	
	//后序遍历
	public void postOrder() {
		if(this.left!=null) {
			this.left.postOrder();
		}
		if(this.right!=null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	//前序查找
	public Node preOrderSearch(int id) {		
		//接收结果，没找到则为空
		Node res=null;
		
		if(this.id==id) {
			return this;
		}
				
		if(this.left!=null) {
			res=this.left.preOrderSearch(id);        //！！记得要接收返回值
		}
		
		//如果左子树找到，则退出
		if(res!=null) {
			return res;
		}
		
		if(this.right!=null) {
			res=this.right.preOrderSearch(id);
		}
		
		return res;		
	}
	
	//中序查找
	public Node midOrderSearch(int id) {
		Node res =null;
		
		//左节点不为空 则中序遍历
		if(this.left!=null) {
			res=this.left.midOrderSearch(id);
		}
		//找到则返回
		if(res!=null) {
			return res;
		}
		
		//没找到则检查当前节点
		if(this.id==id) {
			return this;
		}
		
		//再没找到则右节点中序遍历
		if(this.right!=null){
			res=this.right.midOrderSearch(id);
		}
		
		return res;
	}
	
	public Node postOrderSearch(int id) {
		Node res=null;
		
		if(this.left!=null) {
			res=this.left.postOrderSearch(id);
		}
		if(res!=null) {
			return res;
		}
		
		if(this.right!=null) {
			res=this.right.postOrderSearch(id);
		}
		if(res!=null) {
			return res;
		}
		
		if(this.id==id) {
			return this;
		}
		
		return res;
	}
	
	//删除节点:考虑树id不重复 即只删除一次
	//简化 叶子节点:直接删除 非叶子节点：整棵子树删除
	public void delNode(int id) {
		//检查左右是否为待删除 而不是检查自己
		if(this.left!=null&&this.left.id==id) {
			this.left=null;
			return;
		}
		if(this.right!=null&&this.right.id==id) {
			this.right=null;
			return;
		}
		
		//左右都非待删除 则依次向左右递归
		if(this.left!=null) {
			this.left.delNode(id);
			//这里没有return
		}
		if(this.right!=null) {
			this.right.delNode(id);
		}
	}
}
