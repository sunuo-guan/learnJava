package com.linkedList;

public class Test142Demo {
	
	public static void main(String[] args) {
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
		listNode10.next=listNode10;
		
		detectCycle(listNode1);
	}
	
	public static ListNode detectCycle(ListNode head) {
        if(head==null){
            return head;
        }
        boolean hasCycle=false;
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
            	hasCycle=true;
            	break;
            }
        }

        if(!hasCycle){
            return null;
        }

        fast=head;
        while(fast.val!=slow.val){
            fast=fast.next;
            slow=slow.next;
        }

        return fast;
        
    }
}
