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
     * �����µĽڵ㣬����ԭ�ڵ��ֵ������ԭ�ڵ����
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
     * ���¸��ƵĽڵ��random���ӵ���Ӧ�ĸ��ƽڵ�
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
     * ��ԭ�����������ֿ�
     * @param head
     * @return
     */
    private Node separate(Node head) {
    	Node newhead=head.next;
    	Node newtemp=head.next;
    	Node temp=head;
    	
    	//��ֹ��ָ���쳣���ȴ���һ��ԭ����
    	temp.next=newtemp.next;
    	temp=temp.next;   	
    	
    	while(temp!=null) {
    		//�ȵ��������ָ���ٵ�ԭ����ָ�룬��ֹ��ָ���쳣
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