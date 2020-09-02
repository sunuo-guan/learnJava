package com.linkedList;

public class Test141Demo {
	public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }

        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null){
            if(fast.next==null){
                return false;
            }else{
                fast=fast.next.next;
            }
            slow=slow.next;

            if(fast!=null&&fast.val==slow.val){
                return true;
            }
        }

        return false;
    }
}
