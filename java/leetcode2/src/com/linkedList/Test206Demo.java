package com.linkedList;

import java.util.Stack;

public class Test206Demo {
	//利用栈，不太好
	public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack=new Stack<ListNode>();
        ListNode temp=head;
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }

        ListNode newhead=new ListNode(0);
        temp=newhead;
        while(!stack.isEmpty()){
        	ListNode out=stack.pop();
            temp.next=out;
            temp=temp.next;
        }
        temp.next=null;
        	
        return newhead.next;
    }
	
	//双指针
	public ListNode reverseList2(ListNode head) {
        if(head==null) {
        	return head;
        }
        
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode cur=head;
        ListNode newhead=new ListNode(0);
        
        while(cur!=null) {
        	pre.next=cur.next;
        	cur.next=newhead.next;
        	newhead.next=cur;
        	cur=pre.next;
        }
        
        return newhead.next;
    }
	
	//递归
	public ListNode reverseList3(ListNode head) {
	    if (head == null || head.next == null) return head;
	    ListNode p = reverseList3(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}
	
}
