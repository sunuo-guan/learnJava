package com.datastructure.linklist;

import java.util.Stack;

public class SingleLinkListDemo {
	public static void main(String[] args) {
		Node hero1 = new Node(1, "�ν�");
		Node hero2 = new Node(2, "�ֳ�");
		Node hero3 = new Node(3, "����");
		Node hero4 = new Node(4, "����");
		Node hero5 = new Node(5,"ʷ��");

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
		Node heroUpdate = new Node(1, "³����");
		linkList.updateNode(heroUpdate);
		linkList.showList();

		System.out.println("*******");
		// linkList.deleteNode(3);
		linkList.showList();
		/*
		 * linkList.deleteNode(2); linkList.deleteNode(1); linkList.showList();
		 * linkList.deleteNode(2); linkList.showList();
		 */

		// ��ȡ����
		System.out.println("*******");
		System.out.println("��ǰ����ĸ���Ϊ��" + getLength(linkList.getHead()));

		// ���Ե�����n��
		System.out.println("*******");
		int n = -1;
		Node res = findLastIndexNode(linkList.getHead(), n);
		System.out.println("������" + n + "��Ϊ��" + res);
		
		//��ת������
		System.out.println("*******");
		linkList.showList();
		reverseLinkList(linkList.getHead());
		System.out.println("��ת������Ϊ��");
		linkList.showList();
		
		//�����ӡ������
		System.out.println("*******");
		linkList.showList();
		System.out.println("�����ӡ��");
		reverseOutput(linkList.getHead());

		
		//������������ϲ���һ������������
		SingleLinkList linkList2 = new SingleLinkList();
		linkList2.addByOrder(hero3);
		linkList2.addByOrder(hero5);
		//linkList2.addByOrder(hero1);
		linkList.showList();
		linkList2.showList();
		
	}

	/**
	 * 
	 * ����ͷ�ڵ� ���������Ч�ڵ����
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
	 * �ҵ�������n����� �ȼ���������������n��Ϊ����-n ����ͷ�ڵ��n �����n���ڵ�
	 */
	public static Node findLastIndexNode(Node head, int n) {
		if (head.next == null) {
			System.out.println("����գ�û���ҵ�");
			return null;
		}
		int size = getLength(head);
		Node temp = head;
		if (size < n || n < 0) {
			System.out.println("��������ȷ��û���ҵ�");
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
	 * �������һ�������� �½�һ���µ�ͷ�ڵ� ����������ÿ����һ���򽫽ڵ���뵽��ͷ�ڵ��next ���������ͷ�ڵ�nextָ���µ�ͷ�ڵ�next
	 * 
	 */
	public static void reverseLinkList(Node head) {
		Node newHead = new Node(0, "");
		if (head.next == null || head.next.next == null) {
			System.out.println("ֱ�ӷ���");
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
	 * �����ӡ ����ջ���Ƚ����
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

//����������
class SingleLinkList {

	// ͷ�ڵ㴴��
	Node head = new Node(0, "");

	public Node getHead() {
		return head;
	}

	// ��ӽڵ㣺1��ֱ����������
	// �������������ҵ����Ľڵ�
	public void add(Node hero) {
		Node temp = head; // ������������ʼ��ָ��head
		while (true) {
			if (temp.next == null) {
				temp.next = hero;
				return; // ��������
			}
			temp = temp.next;
		}

	}

	// ��ӽڵ㣺2������С˳����룬�ظ��Ĳ����
	public void addByOrder(Node hero) {
		Node temp = head;
		while (true) {
			if (temp.next == null) { // ��������β
				break;
			}
			if (temp.next.no == hero.no) {
				System.out.println("����ظ����������");
				return;
			} else if (temp.next.no > hero.no) { // �ҵ�λ��
				break;
			}
			temp = temp.next;
		}
		hero.next = temp.next;
		temp.next = hero;
	}

	// ����no�����޸ģ���no���ܱ�
	public void updateNode(Node newNode) {
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				System.out.println("�Ҳ���ָ��Ӣ��");
				return;
			}
			if (temp.next.no == newNode.no) {
				temp.next.name = newNode.name;
				return;
			}
			temp = temp.next;
		}
	}

	// ɾ���ڵ�
	public void deleteNode(int no) {
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				System.out.println("�Ҳ���ָ��Ӣ��");
				return;
			}
			if (temp.next.no == no) {
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
		}
	}

	// �������нڵ����
	public void showList() {
		Node temp = head;
		if (head.next == null) {
			System.out.println("����Ϊ��");
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

//�ڵ���
class Node {
	public int no;
	public String name;
	public Node next;

	public Node(int hno, String hname) {
		this.name = hname;
		this.no = hno;
	}

	// ��дtoString��alt+shift+s
	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}

}