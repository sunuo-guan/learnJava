package com.datastructure.linklist;

public class DoubleLinkListDemo {
	public static void main(String[] args) {
		Node2 hero1 = new Node2(1, "�ν�");
		Node2 hero2 = new Node2(2, "�ֳ�");
		Node2 hero3 = new Node2(3, "����");
		Node2 hero4 = new Node2(4, "����");
		Node2 hero5 = new Node2(5, "ʷ��");

		DoubleLinkList linkList2 = new DoubleLinkList();
		//���
		linkList2.addByOrder(hero2);
		linkList2.addByOrder(hero5);
		linkList2.addByOrder(hero3);
		linkList2.addByOrder(hero1);
		linkList2.addByOrder(hero4);
		linkList2.showList();
		
		System.out.println("*******");
		//�޸�
		Node2 hero6 = new Node2(1, "³����");
		linkList2.updateNode(hero6);
		linkList2.showList();
		
		System.out.println("*******");
		//ɾ��
		int delete=2;
		linkList2.deleteNode(delete);
		linkList2.showList();
		
	}
}

//˫��������
class DoubleLinkList {

	// ͷ�ڵ㴴��
	Node2 head = new Node2(0, "");

	public Node2 getHead() {
		return head;
	}

	// ��ӽڵ㣺1��ֱ����������
	// �������������ҵ����Ľڵ�
	public void add(Node2 hero) {
		Node2 temp = head; // ������������ʼ��ָ��head
		while (true) {
			if (temp.next == null) {
				temp.next = hero;
				hero.pre = temp;
				return; // ��������
			}
			temp = temp.next;
		}

	}

	// ��ӽڵ㣺2������С˳����룬�ظ��Ĳ����
	public void addByOrder(Node2 hero) {
		Node2 temp = head;
		while (true) {
			if (temp.next == null) { // ��������β
				break;
			}
			if (temp.next.no == hero.no) {
				System.out.println("����ظ����������");
				return;
			} else if (temp.next.no > hero.no) { // �ҵ�λ��
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

	// ����no�����޸ģ���no���ܱ�
	public void updateNode(Node2 newNode) {
		Node2 temp = head;
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
		Node2 temp = head.next;
		while (true) {
			if (temp == null) {
				System.out.println("�Ҳ���ָ��Ӣ��");
				return;
			}
			if (temp.no == no) {
				temp.pre.next = temp.next;
				// ��������һ�仰��������һ�䲻��Ҫִ��
				if (temp.next != null) {
					temp.next.pre = temp.pre;
				}

				return;
			}
			temp = temp.next;
		}
	}

	// �������нڵ����
	public void showList() {
		Node2 temp = head;
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
class Node2 {
	public int no;
	public String name;
	public Node2 next; // Ĭ��Ϊnull
	public Node2 pre; // Ĭ��Ϊnull

	public Node2(int hno, String hname) {
		this.name = hname;
		this.no = hno;
	}

	// ��дtoString��alt+shift+s
	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}

}