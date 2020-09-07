package com.offer.chapter4;

public class Test35Demo {
	public static void main(String[] args) {
		
	}
}

class Solution35 {
    public Node copyRandomList(Node head) {
        if(head==null) {
        	return head;
        }
        copyBehind(head);
        linkRandom(head);
        return separate(head);
    }
    
    /**
     * 创造新的节点，复制原节点的值并连在原节点后面
     * @param head
     * @return
     */
    private void copyBehind(Node head) {
    	Node temp=head;
    	while(temp!=null) {
    		Node copy=new Node(temp.val);
    		copy.next=temp.next;
    		temp.next=copy;
    		temp=copy.next;
    	}
    }
    
    /**
     * 将新复制的节点的random连接到相应的复制节点
     * @param head
     */
    private void linkRandom(Node head) {
    	Node temp=head;    	
    	while(temp!=null) {
    		Node copy=temp.next;
    		if(temp.random!=null) {
    			copy.random=temp.random.next;
    		}   		
    		temp=copy.next;    		
    	}
    }
    
    /**
     * 将原链表和新链表分开
     * @param head
     * @return
     */
    private Node separate(Node head) {
    	Node newhead=head.next;
    	Node newtemp=head.next;
    	Node temp=head;
    	
    	//防止空指针异常，先处理一次原链表
    	temp.next=newtemp.next;
    	temp=temp.next;   	
    	
    	while(temp!=null) {
    		//先调新链表的指针再调原链表指针，防止空指针异常
    		newtemp.next=temp.next;
    		newtemp=newtemp.next;
    		temp.next=newtemp.next;
    		temp=temp.next;   		
    	}
    	return newhead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}