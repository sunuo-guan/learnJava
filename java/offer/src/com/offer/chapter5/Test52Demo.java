package com.offer.chapter5;

public class Test52Demo {

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) {
        	return null;
        }
        
        int numOfa=0,numOfb=0;
        
        ListNode tempA=headA;
        while(tempA!=null) {
        	numOfa++;
        	tempA=tempA.next;
        }
        
        ListNode tempB=headB;
        while(tempB!=null) {
        	numOfb++;
        	tempB=tempB.next;
        }
        
        int diffOfab=numOfa-numOfb;
        ListNode longList,shortList;
        if(diffOfab>0) {
        	longList=headA;
        	shortList=headB;
        }else {
        	longList=headB;
        	shortList=headA;
        	diffOfab=numOfb-numOfa;
        }
        
        for (int i = 0; i < diffOfab; i++) {
			longList=longList.next;
		}
        
        while(longList!=null&&shortList!=null&&longList!=shortList) {
        	longList=longList.next;
        	shortList=shortList.next;
        }
        
        return longList;
        
    }
}