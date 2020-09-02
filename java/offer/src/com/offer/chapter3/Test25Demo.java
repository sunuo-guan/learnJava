package com.offer.chapter3;

public class Test25Demo {
	public static void main(String[] args) {
		
	}
}

class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	//空链表输入
    	if(l1==null) {
    		return l2;
    	}else if(l2==null) {
    		return l1;
    	}
    	
    	ListNode newhead=new ListNode(-1);
    	ListNode newlast=newhead;
    	while(l1!=null&&l2!=null) {
    		if(l1.val<l2.val) {
    			//l1的节点接入新链
    			newlast.next=l1;
    			l1=l1.next;
    			newlast=newlast.next;
    		}else {
    			newlast.next=l2;
    			l2=l2.next;
    			newlast=newlast.next;
    		}
    	}
    	
    	if(l1==null) {
    		newlast.next=l2;
    	}else if(l2==null) {
    		newlast.next=l1;
    	}
    	
    	newhead=newhead.next;
    	
    	return newhead;
    	
    }
}
