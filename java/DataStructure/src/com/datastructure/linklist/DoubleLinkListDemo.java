package com.datastructure.linklist;

public class DoubleLinkListDemo {
	public static void main(String[] args) {
		Node2 hero1 = new Node2(1, "宋江");
		Node2 hero2 = new Node2(2, "林冲");
		Node2 hero3 = new Node2(3, "吴用");
		Node2 hero4 = new Node2(4, "武松");
		Node2 hero5 = new Node2(5, "史进");

		DoubleLinkList linkList2 = new DoubleLinkList();
		//添加
		linkList2.addByOrder(hero2);
		linkList2.addByOrder(hero5);
		linkList2.addByOrder(hero3);
		linkList2.addByOrder(hero1);
		linkList2.addByOrder(hero4);
		linkList2.showList();
		
		System.out.println("*******");
		//修改
		Node2 hero6 = new Node2(1, "鲁智深");
		linkList2.updateNode(hero6);
		linkList2.showList();
		
		System.out.println("*******");
		//删除
		int delete=2;
		linkList2.deleteNode(delete);
		linkList2.showList();
		
	}
}

//双向链表类
class DoubleLinkList {

	// 头节点创建
	Node2 head = new Node2(0, "");

	public Node2 getHead() {
		return head;
	}

	// 添加节点：1、直接在最后插入
	// 方法：遍历，找到最后的节点
	public void add(Node2 hero) {
		Node2 temp = head; // 辅助变量，开始先指向head
		while (true) {
			if (temp.next == null) {
				temp.next = hero;
				hero.pre = temp;
				return; // 跳出方法
			}
			temp = temp.next;
		}

	}

	// 添加节点：2、按大小顺序插入，重复的不添加
	public void addByOrder(Node2 hero) {
		Node2 temp = head;
		while (true) {
			if (temp.next == null) { // 到了链表尾
				break;
			}
			if (temp.next.no == hero.no) {
				System.out.println("编号重复，不能添加");
				return;
			} else if (temp.next.no > hero.no) { // 找到位置
				hero.pre=temp;
				hero.next=temp.next;
				temp.next.pre=hero;
				temp.next=hero;
				break;
			}
			temp = temp.next;
		}
		temp.next = hero;
		hero.pre = temp;
	
	}

	// 根据no进行修改，即no不能变
	public void updateNode(Node2 newNode) {
		Node2 temp = head;
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
		Node2 temp = head.next;
		while (true) {
			if (temp == null) {
				System.out.println("找不到指定英雄");
				return;
			}
			if (temp.no == no) {
				temp.pre.next = temp.next;
				// 如果是最后一句话，则下面一句不需要执行
				if (temp.next != null) {
					temp.next.pre = temp.pre;
				}

				return;
			}
			temp = temp.next;
		}
	}

	// 遍历所有节点输出
	public void showList() {
		Node2 temp = head;
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
class Node2 {
	public int no;
	public String name;
	public Node2 next; // 默认为null
	public Node2 pre; // 默认为null

	public Node2(int hno, String hname) {
		this.name = hname;
		this.no = hno;
	}

	// 重写toString，alt+shift+s
	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}

}