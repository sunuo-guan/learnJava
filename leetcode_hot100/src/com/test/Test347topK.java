package com.test;

import java.util.*;

public class Test347topK {
	public static void main(String[] args) {
		int k = 2;
		int nums[] = {1,1,1,2,2,3};
		System.out.println(topKFrequentWithHeap(nums, k));
	}
	
	//ͳ��Ԫ��Ƶ���������
    public int[] topKFrequent(int[] nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length; i++) {
    		if(map.containsKey(nums[i])) {
    			map.put(nums[i], map.get(nums[i])+1);
    		} else {
    			map.put(nums[i], 1);
    		}
    	}
    	ArrayList<Integer> sortList = new ArrayList<Integer>(map.keySet());
    	//ѡ����
    	Collections.sort(sortList,new Comparator<Integer>() {
             @Override
             public int compare(Integer o1, Integer o2) {
                 // ����ֵΪint���ͣ�����0��ʾ����С��0��ʾ����
                 return map.get(o2)-map.get(o1);
             }
         });
//    	Collections.sort(sortList, (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
    	int[] result = new int[k];
    	for(int i=0;i<k;i++) {
    		result[i] = sortList.get(i);
    	}
    	return result;
    }
    
    //ʹ�öѽ��й������
    public static int[] topKFrequentWithHeap(int[] nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length; i++) {
    		if(map.containsKey(nums[i])) {
    			map.put(nums[i], map.get(nums[i])+1);
    		} else {
    			map.put(nums[i], 1);
    		}
    	}
    	PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
    			(w1, w2) -> map.get(w1).equals(map.get(w2)) ?
    	         w2.compareTo(w1) : map.get(w1) - map.get(w2));
    	for(int i:map.keySet()) {
    		heap.offer(i);
    		if(heap.size()>k)
    			heap.poll();
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	while(!heap.isEmpty()) {
    		list.add(heap.poll());
    	}
    	Collections.reverse(list);
    	int[] result = new int[k];
    	for(int i=0;i<k;i++) {
    		result[i] = list.get(i);
    	}
    	return result;
    }
}
