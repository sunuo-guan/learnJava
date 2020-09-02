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

//��������
class CirleSingleLinkList {
	private Boy first = null; // ͷָ�룬���ܶ�

	//���컷������
	public void createCicle(int num) {
		// ����У��
		if (num < 1) {
			System.out.println("�����������");
			return;
		}

		Boy curBoy = null; // βָ�룬ʼ��Ҫָ������β
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
	
	//������������
	public void showList() {
		//�ж��Ƿ�Ϊ��
		if(first==null) {
			System.out.println("����Ϊ��");
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
	 * ���ݲ�ͬ������
	 * ������Ȧ˳��
	 */
	public void josepfu(int startNum,int turn,int total) {
		//�������ݼ���
		if(startNum>total||startNum<1||first==null) {
			System.out.println("��������");
			return;
		}
		
		Boy current = first;     //ָ��ǰ��boy��ָ��
		Boy preBoy =current;        //ָ��currentǰ���boy��ָ��
		
		//�Ƚ�preBoy�Ƶ�currentǰ��
		for (int i = 0; i < total-1; i++) {
			preBoy=preBoy.getNext();
		}
		
		//��current��preBoy�ƶ���ָ��������λ��start
		for (int i = 0; i < startNum-1; i++) {
			preBoy=preBoy.getNext();
			current=current.getNext();
		}
		
		//��ʼ����������
		while(true) {
			//�ж��Ƿ������һ��boy
			if(current==preBoy) {
				break;
			}
			else {
				for (int i = 0; i < turn-1; i++) {
					preBoy=preBoy.getNext();
					current=current.getNext();
				}
				//����ָ��λ�� ����
				System.out.println(current.getNo()+"�ų���");
				preBoy.setNext(current.getNext());
				current=current.getNext();
			}
		}
		System.out.println("���ʣ�µ���"+current.getNo()+"��");
	}
}

//�ڵ���
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