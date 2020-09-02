package com.linkedList;

public class Test19Demo {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }

        ListNode fast=head.next;
        ListNode slow=head;			//��ָ��ָ���ɾ���ڵ��ǰһ���ڵ�
        int isDeleteHead=0;
        while(fast!=null&&isDeleteHead<n){
        	//��ָ�������
            fast=fast.next;
            isDeleteHead++;
        }

        if(isDeleteHead==n-1){
        	//��ʱɾ������ͷ�ڵ�
            head=head.next;
            return head;
        }else if(isDeleteHead<n-1){
        	//��ʱn������Ҫ�������null
            return null;
        }else{
        	//��ʱ����ָ��һ���ߣ�ֱ����ָ���ߵ�����β������ɾ��
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            slow.next=slow.next.next;
            return head;
        }
    }
}
