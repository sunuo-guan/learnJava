package com.datastructure.hashtab;

import java.util.Scanner;

public class HashTabDemo {
	public static void main(String[] args) {
		int maxSize=8;
		HashTab table=new HashTab(maxSize);
		Scanner scanner=new Scanner(System.in);
		boolean loop=true;
		
		while(loop) {
			System.out.println("add:���");
			System.out.println("show:����");
			System.out.println("search:����id����");
			System.out.println("exit:�˳�");
			String key=scanner.next();
			switch (key) {
			case "add":
				System.out.println("������id");
				int id=scanner.nextInt();
				System.out.println("����������");
				String name=scanner.next();
				table.addNode(id, name);
				break;
			case "show":
				table.showTab();
				break;
			case "search":
				System.out.println("������Ҫ���ҵ�id��");
				id=scanner.nextInt();
				table.searchById(id);
				break;
			case "exit":
				loop=false;
				scanner.close();
				break;
			default:
				break;
			}
		}
	}
}

//�ڵ���
class Node{
	public int id;
	public String name;
	Node next;       //Ĭ��Ϊ��
	
	//������
	public Node(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
}

//������
class LinkList{
	
	/*
	 * private Node head;
	 * 
	 * public void add(Node newNode){
	 * 		if(head==null){
	 * 			head=newNode;
	 * 			return;
	 * 		}
	 * 		Node temp=head;
	 * 		while(head.next!=null){
	 * 			temp=temp.next;	
	 * 		}
	 * 		temp.next=newNode;
	 * }
	 * 
	 * 
	 */
	//ͷ�ڵ�
	Node head=new Node(-1,"");
	
	//��ӽڵ�
	public void add(Node newNode) {
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newNode;
	}
	
	
	
	//�����ڵ�
	public void showList() {
		Node temp=head.next;
		while(temp!=null) {
			System.out.print("=>id="+temp.id+",name="+temp.name+" ");
			temp=temp.next;
		}
		System.out.println("");
	}
	
	//����id���ҽڵ�
	public void search(int key) {
		Node temp=head.next;
		while(temp!=null) {
			if(temp.id==key) {
				System.out.println("���ҽڵ�Ϊ��id="+temp.id+",name="+temp.name);
				return;
			}
			temp=temp.next;
		}
		System.out.println("�����ڴ�id");
	}
	
}

//��ϣ����
class HashTab{
	private int size;
	
	LinkList list[];
	
	public HashTab(int maxSize) {
		this.size=maxSize;
		list=new LinkList[size];
		for (int i = 0; i < size; i++) {   //�ֱ�ֵ��ʼ��
			list[i]=new LinkList();
		}
	}
	
	//��ϣ���� ȡģ
	public int hashFun(int num) {
		return num%size;
	}
	
	//��ӽڵ�
	public void addNode(int id,String name) {
		//���ϣ
		int hash=hashFun(id);
		//ѡ��Ӧ������ ��ӽ�
		Node newNode=new Node(id,name);
		list[hash].add(newNode);
	}
	
	//����
	public void showTab() {
		for (int i = 0; i < size; i++) {
			System.out.print("��"+(i+1)+"������Ϊ��");
			list[i].showList();
		}
	}
	
	//����
	public void searchById(int id) {
		//���ù�ϣ����
		int hash =hashFun(id);
		//ѡ��Ӧ��������в���
		list[hash].search(id);
		
	}
}
