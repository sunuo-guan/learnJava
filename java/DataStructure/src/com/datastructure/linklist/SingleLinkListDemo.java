package com.datastructure.linklist;

import java.util.Stack;

public class SingleLinkListDemo {
	public static void main(String[] args) {
		Node hero1 = new Node(1, "宋江");
		Node hero2 = new Node(2, "林冲");
		Node hero3 = new Node(3, "吴用");
		Node hero4 = new Node(4, "武松");
		Node hero5 = new Node(5,"史进");

		SingleLinkList linkList = new SingleLinkList();
		
		/*
		 * linkList.add(hero1); linkList.add(hero2); linkList.add(hero3);
		 * linkList.showList();
		 */

		linkList.addByOrder(hero1);
		linkList.addByOrder(hero2);
		linkList.addByOrder(hero4);
		linkList.showList();

		System.out.println("*******");
		Node heroUpdate = new Node(1, "鲁智深");
		linkList.updateNode(heroUpdate);
		linkList.showList();

		System.out.println("*******");
		// linkList.deleteNode(3);
		linkList.showList();
		/*
		 * linkList.deleteNode(2); linkList.deleteNode(1); linkList.showList();
		 * linkList.deleteNode(2); linkList.showList();
		 */

		// 获取个数
		System.out.println("*******");
		System.out.println("当前链表的个数为：" + getLength(linkList.getHead()));

		// 测试倒数第n个
		System.out.println("*******");
		int n = -1;
		Node res = findLastIndexNode(linkList.getHead(), n);
		System.out.println("倒数第" + n + "个为：" + res);
		
		//反转单链表
		System.out.println("*******");
		linkList.showList();
		reverseLinkList(linkList.getHead());
		System.out.println("反转单链表为：");
		linkList.showList();
		
		//逆序打印单链表
		System.out.println("*******");
		linkList.showList();
		System.out.println("逆序打印：");
		reverseOutput(linkList.getHead());

		
		//两个有序链表合并成一个新有序链表
		SingleLinkList linkList2 = new SingleLinkList();
		linkList2.addByOrder(hero3);
		linkList2.addByOrder(hero5);
		//linkList2.addByOrder(hero1);
		linkList.showList();
		linkList2.showList();
		
	}

	/**
	 * 
	 * 输入头节点 输出链表有效节点个数
	 */
	public static int getLength(Node headNode) {
		Node temp = headNode;
		if (headNode.next == null) {
			return 0;
		}
		int length = 0;
		while (true) {
			if (temp.next == null) {
				return length;
			} else {
				temp = temp.next;
				length++;
			}
		}
	}

	/**
	 * 
	 * 找到倒数第n个结点 先计算总数，倒数第n个为总数-n 输入头节点和n 输出第n个节点
	 */
	public static Node findLastIndexNode(Node head, int n) {
		if (head.next == null) {
			System.out.println("链表空，没有找到");
			return null;
		}
		int size = getLength(head);
		Node temp = head;
		if (size < n || n < 0) {
			System.out.println("索引不正确，没有找到");
			return null;
		} else {
			int count = 0;
			while (count <= size - n) {
				temp = temp.next;
				count++;
			}
			return temp;
		}
	}

	/**
	 * 反向输出一个单链表 新建一个新的头节点 遍历旧链表，每遍历一个则将节点插入到新头节点的next 将旧链表的头节点next指向新的头节点next
	 * 
	 */
	public static void reverseLinkList(Node head) {
		Node newHead = new Node(0, "");
		if (head.next == null || head.next.next == null) {
			System.out.println("直接返回");
			return;
		}
		Node temp = head.next;
		Node temp2 = null;
		while (temp != null) {
			temp2 = temp.next;
			temp.next = newHead.next;
			newHead.next = temp;
			temp = temp2;
		}
		head.next = newHead.next;
	}

	/**
	 * 逆序打印 利用栈，先进后出
	 * 
	 * @param reverseOutput
	 */
	public static void reverseOutput(Node head) {
		int length = getLength(head);
		Node stack[] = new Node[length];
		Node temp = head;
		int count = 0;
		while (temp.next != null) {
			stack[count] = temp.next;
			temp = temp.next;
			count++;
		}
		for (int i = length - 1; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}
	
	public static void reverseOutput2(Node head) {
		if(head.next==null) {
			return;
		}
		Stack<Node> stack=new Stack<Node>();
		Node cur=head.next;
		while(cur!=null) {
			stack.push(cur);
			cur=cur.next;
		}
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
	}
}

//单向链表类
class SingleLinkList {

	// 头节点创建
	Node head = new Node(0, "");

	public Node getHead() {
		return head;
	}

	// 添加节点：1、直接在最后插入
	// 方法：遍历，找到最后的节点
	public void add(Node hero) {
		Node temp = head; // 辅助变量，开始先指向head
		while (true) {
			if (temp.next == null) {
				temp.next = hero;
				return; // 跳出方法
			}
			temp = temp.next;
		}

	}

	// 添加节点：2、按大小顺序插入，重复的不添加
	public void addByOrder(Node hero) {
		Node temp = head;
		while (true) {
			if (temp.next == null) { // 到了链表尾
				break;
			}
			if (temp.next.no == hero.no) {
				System.out.println("编号重复，不能添加");
				return;
			} else if (temp.next.no > hero.no) { // 找到位置
				break;
			}
			temp = temp.next;
		}
		hero.next = temp.next;
		temp.next = hero;
	}

	// 根据no进行修改，即no不能变
	public void updateNode(Node newNode) {
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				System.out.println("找不到指定英雄");
				return;
			}
			if (temp.next.no == newNode.no) {
				temp.next.name = newNode.name;
				return;
			}
			temp = temp.next;
		}
	}

	// 删除节点
	public void deleteNode(int no) {
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				System.out.println("找不到指定英雄");
				return;
			}
			if (temp.next.no == no) {
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
		}
	}

	// 遍历所有节点输出
	public void showList() {
		Node temp = head;
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		while (true) {
			if (temp.next == null) {
				return;
			}
			temp = temp.next;
			System.out.println(temp);
		}
	}
}

//节点类
class Node {
	public int no;
	public String name;
	public Node next;

	public Node(int hno, String hname) {
		this.name = hname;
		this.no = hno;
	}

	// 重写toString，alt+shift+s
	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}

}