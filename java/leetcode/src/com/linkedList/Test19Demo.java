package com.linkedList;

public class Test19Demo {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }

        ListNode fast=head.next;
        ListNode slow=head;			//慢指针指向待删除节点的前一个节点
        int isDeleteHead=0;
        while(fast!=null&&isDeleteHead<n){
        	//快指针向后走
            fast=fast.next;
            isDeleteHead++;
        }

        if(isDeleteHead==n-1){
        	//此时删除的是头节点
            head=head.next;
            return head;
        }else if(isDeleteHead<n-1){
        	//此时n比链表还要长，输出null
            return null;
        }else{
        	//此时快慢指针一起走，直到快指针走到链表尾，进行删除
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            slow.next=slow.next.next;
            return head;
        }
    }
}
