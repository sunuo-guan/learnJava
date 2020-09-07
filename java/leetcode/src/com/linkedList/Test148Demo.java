package com.linkedList;

public class Test148Demo {
	public static void main(String[] args) {
		Test148Demo test148Demo = new Test148Demo();
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		ListNode listNode7 = new ListNode(7);
		ListNode listNode8 = new ListNode(8);
		ListNode listNode9 = new ListNode(9);
		ListNode listNode10 = new ListNode(10);
		
		listNode1.next=listNode2;
		listNode2.next=listNode3;
		listNode3.next=listNode4;
		listNode4.next=listNode5;
		listNode5.next=listNode6;
		listNode6.next=listNode7;
		listNode7.next=listNode8;
		listNode8.next=listNode9;
		listNode9.next=listNode10;
		
		test148Demo.sortList(listNode1);
	}
	
	public ListNode sortList(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		
		return mergeSort(head);
    }
	
	public ListNode mergeSort(ListNode head) {
		if(head.next==null) {
			return head;
		}
		
		ListNode fast=head,slow=head,slowPre=null;
		//要在slow的前面进行断开
		while(fast!=null&&fast.next!=null) {
			slowPre=slow;
			fast=fast.next.next;
			slow=slow.next;
		}
		slowPre.next=null;
		ListNode left=mergeSort(head);
		ListNode right=mergeSort(slow);
		return merge(left,right);
	}
	
	public ListNode merge(ListNode left,ListNode right) {
		ListNode newhead=new ListNode(0);
		ListNode cur=newhead;
		while(left!=null&&right!=null) {
			if(left.val>right.val) {
				cur.next=right;
				cur=cur.next;
				right=right.next;
			}else {
				cur.next=left;
				cur=cur.next;
				left=left.next;
			}
		}
		
		if(left!=null) {
			cur.next=left;
		}else {
			cur.next=right;
		}
		
		return newhead.next;
	}
}
