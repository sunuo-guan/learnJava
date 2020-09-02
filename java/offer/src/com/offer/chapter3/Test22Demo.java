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
		//��һ������
		if (head == null) {
			return null;
		}
		
		//�ڶ������� ������0��
		if(k==0) {
			return null;
		}
		
		//���������⣺k������Ҫ��
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
