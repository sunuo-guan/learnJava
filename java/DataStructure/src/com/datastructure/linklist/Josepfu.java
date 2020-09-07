package com.datastructure.linklist;

public class Josepfu {
	public static void main(String[] args) {
		CirleSingleLinkList list = new CirleSingleLinkList();
		int num=15;
		list.createCicle(num);
		list.showList();
		System.out.println("*******");
		int start=7;
		int turn=54564;
		list.josepfu(start, turn, num);
	}
}

//环形链表
class CirleSingleLinkList {
	private Boy first = null; // 头指针，不能动

	//构造环形链表
	public void createCicle(int num) {
		// 数据校验
		if (num < 1) {
			System.out.println("数据输入错误");
			return;
		}

		Boy curBoy = null; // 尾指针，始终要指向链表尾
		for (int i = 1; i <= num; i++) {
			if (i == 1) {
				Boy boy=new Boy(1);
				first=boy;
				first.setNext(first);
				curBoy=first;
			}else {
				Boy boy =new Boy(i);
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy=boy;
			}
		}
		return;
	}
	
	//遍历环形链表
	public void showList() {
		//判断是否为空
		if(first==null) {
			System.out.println("队列为空");
			return;
		}
		Boy cur=first;
		while(true) {
			System.out.println(cur.getNo());
			if(cur.getNext()==first) {
				break;
			}
			cur=cur.getNext();
		}
	}
	
	/**
	 * 根据不同的输入
	 * 给出出圈顺序
	 */
	public void josepfu(int startNum,int turn,int total) {
		//输入数据检验
		if(startNum>total||startNum<1||first==null) {
			System.out.println("输入有误");
			return;
		}
		
		Boy current = first;     //指向当前的boy的指针
		Boy preBoy =current;        //指向current前面的boy的指针
		
		//先将preBoy移到current前面
		for (int i = 0; i < total-1; i++) {
			preBoy=preBoy.getNext();
		}
		
		//将current、preBoy移动到指定的启动位置start
		for (int i = 0; i < startNum-1; i++) {
			preBoy=preBoy.getNext();
			current=current.getNext();
		}
		
		//开始报数，出列
		while(true) {
			//判断是否是最后一个boy
			if(current==preBoy) {
				break;
			}
			else {
				for (int i = 0; i < turn-1; i++) {
					preBoy=preBoy.getNext();
					current=current.getNext();
				}
				//到达指定位置 出列
				System.out.println(current.getNo()+"号出列");
				preBoy.setNext(current.getNext());
				current=current.getNext();
			}
		}
		System.out.println("最后剩下的是"+current.getNo()+"号");
	}
}

//节点类
class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
}