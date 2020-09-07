package com.linkedList;

import org.junit.jupiter.api.Test;

public class Test23Demo {

}

class Solution23 {
	
	@Test
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }

        if(lists.length==1){
            return lists[0];
        }

//        ListNode newhead=mergeTwoLists(lists[0],lists[1]);
//        for(int i=2;i<lists.length;i++){
//            newhead=mergeTwoLists(lists[i],newhead);
//        }
        
        ListNode newhead=mergeByMergeSort(0,lists.length-1,lists);
        
        return newhead;
    }
	
	public ListNode mergeByMergeSort(int listsLeft,int listsRight,ListNode[] lists){
        //注意达到终止条件时，要返回单个的节点
		if(listsLeft==listsRight){
            return lists[listsLeft];
        }
        int mid=(listsLeft+listsRight)/2;
        ListNode newLeft=mergeByMergeSort(listsLeft,mid,lists);
        ListNode newRight=mergeByMergeSort(mid+1,listsRight,lists);
        ListNode newhead=mergeTwoLists(newLeft,newRight);
        return newhead;
    }
	
	//改进：不同的链表先两两合并再合并在一起，类似归并排序
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }

        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode newhead=new ListNode(0);
        ListNode newTemp=newhead;

        while(temp1!=null&&temp2!=null){
            if(temp1.val<temp2.val){
                newTemp.next=temp1;
                temp1=temp1.next;
            }else{
                newTemp.next=temp2;
                temp2=temp2.next;               
            }
            newTemp=newTemp.next;
        }

       newTemp.next=temp1==null?temp2:temp1;

        return newhead.next;
    }
}