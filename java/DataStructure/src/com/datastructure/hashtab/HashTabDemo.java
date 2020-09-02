package com.datastructure.hashtab;

import java.util.Scanner;

public class HashTabDemo {
	public static void main(String[] args) {
		int maxSize=8;
		HashTab table=new HashTab(maxSize);
		Scanner scanner=new Scanner(System.in);
		boolean loop=true;
		
		while(loop) {
			System.out.println("add:添加");
			System.out.println("show:遍历");
			System.out.println("search:根据id查找");
			System.out.println("exit:退出");
			String key=scanner.next();
			switch (key) {
			case "add":
				System.out.println("请输入id");
				int id=scanner.nextInt();
				System.out.println("请输入名字");
				String name=scanner.next();
				table.addNode(id, name);
				break;
			case "show":
				table.showTab();
				break;
			case "search":
				System.out.println("请输入要查找的id：");
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

//节点类
class Node{
	public int id;
	public String name;
	Node next;       //默认为空
	
	//构造器
	public Node(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
}

//链表类
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
	//头节点
	Node head=new Node(-1,"");
	
	//添加节点
	public void add(Node newNode) {
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newNode;
	}
	
	
	
	//遍历节点
	public void showList() {
		Node temp=head.next;
		while(temp!=null) {
			System.out.print("=>id="+temp.id+",name="+temp.name+" ");
			temp=temp.next;
		}
		System.out.println("");
	}
	
	//给定id查找节点
	public void search(int key) {
		Node temp=head.next;
		while(temp!=null) {
			if(temp.id==key) {
				System.out.println("所找节点为：id="+temp.id+",name="+temp.name);
				return;
			}
			temp=temp.next;
		}
		System.out.println("不存在此id");
	}
	
}

//哈希表类
class HashTab{
	private int size;
	
	LinkList list[];
	
	public HashTab(int maxSize) {
		this.size=maxSize;
		list=new LinkList[size];
		for (int i = 0; i < size; i++) {   //分别赋值初始化
			list[i]=new LinkList();
		}
	}
	
	//哈希函数 取模
	public int hashFun(int num) {
		return num%size;
	}
	
	//添加节点
	public void addNode(int id,String name) {
		//求哈希
		int hash=hashFun(id);
		//选对应的链表 添加进
		Node newNode=new Node(id,name);
		list[hash].add(newNode);
	}
	
	//遍历
	public void showTab() {
		for (int i = 0; i < size; i++) {
			System.out.print("第"+(i+1)+"条链表为：");
			list[i].showList();
		}
	}
	
	//查找
	public void searchById(int id) {
		//调用哈希函数
		int hash =hashFun(id);
		//选对应的链表进行查找
		list[hash].search(id);
		
	}
}
