package com.offer.chapter3;

public class Test22Demo {
	public static void main(String[] args) {

	}
}

class Solution {
	public ListNode getKthFromEnd(ListNode head, int k) {
		if (head == null) {
			return null;
		}

		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		if (len < k) {
			return null;
		} else {
			int move = len - k;
			temp = head;
			for (int i = 0; i < move; i++) {
				temp = temp.next;
			}
			return temp;
		}
	}

	public ListNode getKthFromEnd2(ListNode head, int k) {
		//第一个问题
		if (head == null) {
			return null;
		}
		
		//第二个问题 倒数第0个
		if(k==0) {
			return null;
		}
		
		//第三个问题：k比链表还要长
		ListNode temp1=head,temp2=head;
		for (int i = 0; i < k-1; i++) {
			if(temp2!=null) {
				temp2=temp2.next;
			}else {
				return null;
			}
		}
		
		while(temp2.next!=null) {
			temp1=temp1.next;
			temp2=temp2.next;
		}
		
		return temp1;
		
		
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
