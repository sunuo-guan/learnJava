package com.test;

import java.util.*;

public class Test406HeightQueue {
	public static void main(String[] args) {
		
	}
	
    public int[][] reconstructQueue(int[][] people) {
    	//先按身高进行降序排序，若身高相同按索引升序排序
    	Arrays.sort(people, new Comparator<int[]>() {
    		public int compare(int[] w1, int[] w2) {
    			return w1[0] == w2[0] ? w1[1] - w2[1] : w2[0] - w1[0];
    		}
		});
    	
    	//将排序好的数组按顺序和索引位置放入新数组
    	LinkedList<int[]> list = new LinkedList<int[]>();
    	for (int[] arr :people) {
			list.add(arr[1], arr);
		}
    	
    	int[][] result = new int[people.length][2];
    	result = list.toArray(new int[people.length][2]);
    	return result;
    }
}
