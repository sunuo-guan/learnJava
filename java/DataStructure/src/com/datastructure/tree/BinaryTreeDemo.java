package com.datastructure.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		Node root=new Node(1, "tom");
		Node node1=new Node(2, "jerry");
		Node node2=new Node(3, "mike");
		Node node3=new Node(4,"jonh");
		Node node4=new Node(5,"lily");
		
		//���ֶ����		
		tree.setHead(root);    //��������
		root.setLeft(node1);
		root.setRight(node2);
		node2.setRight(node3);
		node2.setLeft(node4);
		
		System.out.println("ǰ�������");
		tree.preOrder();
		System.out.println("*********");
		System.out.println("���������");
		tree.midOrder();
		System.out.println("*********");
		System.out.println("���������");
		tree.postOrder();
		
		System.out.println("*********");
		int id=6;
		Node result=null;
		result=tree.preOrderSearch(id);
		if(result!=null) {
			System.out.println("�ҵ���"+result);
		}else {
			System.out.println("û���ҵ�");
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
	
	//ǰ�����
	public void preOrder() {
		if(root==null) {
			System.out.println("��Ϊ��");
			return;
		}
		root.preOrder();
	}
	
	public void midOrder() {
		if(root==null) {
			System.out.println("��Ϊ��");
			return;
		}
		root.midOrder();
	}
	
	public void postOrder() {
		if(root==null) {
			System.out.println("��Ϊ��");
			return;
		}
		root.postOrder();
	}
	
	//ǰ���������
	public Node preOrderSearch(int id) {
		Node res=null;
		if(this.root!=null) {
			res=root.preOrderSearch(id);
		}
		return res;
	}
	
	//�������
	public Node midOrderSearch(int id) {
		Node res=null;
		if(this.root!=null) {
			res=root.midOrderSearch(id);
		}
		return res;
	}
	
	//�������
	public Node postOrderSearch(int id) {
		Node res=null;
		if(this.root!=null) {
			res=root.postOrderSearch(id);
		}
		return res;
	}
	
	//ɾ���ڵ�
	public void delNode(int id) {
		//���ж�root�Ƿ�Ϊ��
		if(root==null) {
			System.out.println("����Ϊ�գ��޷�ɾ��");
		}else {
			//�ж�root�Ƿ��Ǵ�ɾ���ڵ�
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
	
	//ǰ�����
	public void preOrder() {
		System.out.println(this);
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
	
	//�������
	public void midOrder() {
		if(this.left!=null) {
			this.left.midOrder();
		}
		System.out.println(this);
		if(this.right!=null) {
			this.right.midOrder();
		}
	}
	
	//�������
	public void postOrder() {
		if(this.left!=null) {
			this.left.postOrder();
		}
		if(this.right!=null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	//ǰ�����
	public Node preOrderSearch(int id) {		
		//���ս����û�ҵ���Ϊ��
		Node res=null;
		
		if(this.id==id) {
			return this;
		}
				
		if(this.left!=null) {
			res=this.left.preOrderSearch(id);        //�����ǵ�Ҫ���շ���ֵ
		}
		
		//����������ҵ������˳�
		if(res!=null) {
			return res;
		}
		
		if(this.right!=null) {
			res=this.right.preOrderSearch(id);
		}
		
		return res;		
	}
	
	//�������
	public Node midOrderSearch(int id) {
		Node res =null;
		
		//��ڵ㲻Ϊ�� ���������
		if(this.left!=null) {
			res=this.left.midOrderSearch(id);
		}
		//�ҵ��򷵻�
		if(res!=null) {
			return res;
		}
		
		//û�ҵ����鵱ǰ�ڵ�
		if(this.id==id) {
			return this;
		}
		
		//��û�ҵ����ҽڵ��������
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
	
	//ɾ���ڵ�:������id���ظ� ��ֻɾ��һ��
	//�� Ҷ�ӽڵ�:ֱ��ɾ�� ��Ҷ�ӽڵ㣺��������ɾ��
	public void delNode(int id) {
		//��������Ƿ�Ϊ��ɾ�� �����Ǽ���Լ�
		if(this.left!=null&&this.left.id==id) {
			this.left=null;
			return;
		}
		if(this.right!=null&&this.right.id==id) {
			this.right=null;
			return;
		}
		
		//���Ҷ��Ǵ�ɾ�� �����������ҵݹ�
		if(this.left!=null) {
			this.left.delNode(id);
			//����û��return
		}
		if(this.right!=null) {
			this.right.delNode(id);
		}
	}
}
