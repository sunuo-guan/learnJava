package com.offer.chapter3;

public class Test23Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n3;

		Solution23 solution23 = new Solution23();
		ListNode temp = solution23.beginRing(n1);
		System.out.println(temp.val);
	}

}

class Solution23 {
	// 快慢针是否相遇判断是否有环
	public ListNode isRing(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode slow = head.next, fast = head.next.next;
		while (fast != null && slow != null) {
			if (fast == slow) {
				return slow;
			}

			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}

		return null;
	}

	// 有环，得到相遇节点后，针再在相遇节点走一次，直到回到相遇点，得到圈的大小
	// 同时置于起点，一针向前走圈的大小，另一针起步，相遇点则为圈的起点
	public ListNode beginRing(ListNode head) {
		ListNode meet = isRing(head);
		if (meet == null) {
			return null;
		}

		ListNode slow = meet.next;
		int count = 1;
		while (meet != slow) {
			slow = slow.next;
			count++;
		}

		slow = head;
		ListNode fast = head;

		for (int i = 0; i < count; i++) {
			fast = fast.next;
		}

		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;

	}

	public ListNode reverseList(ListNode head) {
		if(head==null) {
			return null;
		}
		if(head.next==null) {
			return head;
		}
		ListNode newhead=null;
		ListNode slow=head;
		ListNode fast=head.next;
		
		while(slow!=null) {
			slow.next=newhead;
			newhead=slow;
			slow=fast;
			if(fast==null) {
				break;
			}else {
				fast=fast.next;
			}			
		}
		
		return newhead;
	}
}
