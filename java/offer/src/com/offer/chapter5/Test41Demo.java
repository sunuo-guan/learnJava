package com.offer.chapter5;

import java.util.*;

public class Test41Demo {
	public static void main(String[] args) {
		
	}
}

/**
 * 创建两个堆：左边的都放在大顶堆，右边的都放在小顶堆
 * @author Administrator
 *
 */
class MedianFinder {
	//大顶堆
	private PriorityQueue<Integer> left;
	//小顶堆
	private PriorityQueue<Integer> right;
	//总的加入数目
	private int nums;
    /** initialize your data structure here. */
    public MedianFinder() {
    	left=new PriorityQueue<Integer>((o1,o2)->o2-o1);
    	right=new PriorityQueue<Integer>();
    	nums=0;
    }
    
    public void addNum(int num) {
    	//插入保持平衡：奇数插在左堆，偶数插在右堆
    	if(nums%2==0) {
    		//为了保持左堆都比右堆小，右堆插入新元素时，新元素先插在左堆，左堆再弹出一个元素插入右堆
    		left.add(num);
    		right.add(left.poll());
    	}else {
    		//为了保持左堆都比右堆小，左堆插入新元素时，新元素先插在右堆，右堆再弹出一个元素插入左堆
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
