package com.linkedList;

public class Test2Demo {
	public static void main(String[] args) {

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode head = new ListNode(0);
		ListNode last = head;

		int inVal = 0;
		int quotient = 0;

		// 下面三个循环可以合在一起写
		while (temp1 != null || temp2 != null) {
			int l1Val = temp1 == null ? 0 : temp1.val;
			int l2Val = temp2 == null ? 0 : temp2.val;
			int sum=inVal+l1Val+l2Val;
			inVal=sum/10;
			quotient=sum%10;
			ListNode newTemp = new ListNode(quotient);
			last.next=newTemp;
			last=newTemp;
			temp1=temp1.next==null?null:temp1.next;
			temp2=temp2.next==null?null:temp2.next;

		}

		if (inVal != 0) {
			ListNode newTemp = new ListNode(inVal);
			last.next = newTemp;
			last = newTemp;
		}

		return head.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
