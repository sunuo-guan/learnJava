package com.offer.chapter5;

import java.util.*;

public class Test41Demo {
	public static void main(String[] args) {
		
	}
}

/**
 * ���������ѣ���ߵĶ����ڴ󶥶ѣ��ұߵĶ�����С����
 * @author Administrator
 *
 */
class MedianFinder {
	//�󶥶�
	private PriorityQueue<Integer> left;
	//С����
	private PriorityQueue<Integer> right;
	//�ܵļ�����Ŀ
	private int nums;
    /** initialize your data structure here. */
    public MedianFinder() {
    	left=new PriorityQueue<Integer>((o1,o2)->o2-o1);
    	right=new PriorityQueue<Integer>();
    	nums=0;
    }
    
    public void addNum(int num) {
    	//���뱣��ƽ�⣺����������ѣ�ż�������Ҷ�
    	if(nums%2==0) {
    		//Ϊ�˱�����Ѷ����Ҷ�С���ҶѲ�����Ԫ��ʱ����Ԫ���Ȳ�����ѣ�����ٵ���һ��Ԫ�ز����Ҷ�
    		left.add(num);
    		right.add(left.poll());
    	}else {
    		//Ϊ�˱�����Ѷ����Ҷ�С����Ѳ�����Ԫ��ʱ����Ԫ���Ȳ����Ҷѣ��Ҷ��ٵ���һ��Ԫ�ز������
    		right.add(num);
    		left.add(right.poll());
    	}
    	nums++;
    }
    
    public double findMedian() {
    	if(nums%2==0) {
    		return (left.peek()+right.peek())/2.0;
    	}else {
    		return right.peek()/1.0;
    	}
    }
}
