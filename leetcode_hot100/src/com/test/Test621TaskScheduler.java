package com.test;

import java.util.*;

public class Test621TaskScheduler {

	/*
	 * 1、排序，最多的任务先安排
	 * 2、优先队列，一轮处理一个时间间隙的任务，出列将次数减1然后载入列
	 * 3、填桶思路，先安排最多的任务，把剩余的任务安排到这些空闲时间里
	 * 
	 */
	public int leastInterval2(char[] tasks, int n) {
    	int map[] = new int[26];
    	for (int i = 0; i < tasks.length; i++) {
			map[tasks[i] - 'A']++;
		}
    	PriorityQueue < Integer > queue = new PriorityQueue < > (26, Collections.reverseOrder());
    	for (int i = 0; i < map.length; i++) {
			if(map[i] > 0)
				queue.add(map[i]);
		}
    	
    	int result = 0;
    	while(!queue.isEmpty()) {
    		int i = 0;
    		List<Integer> list = new ArrayList<Integer>();
    		while(i < n) {
    			if(!queue.isEmpty()) {
    				if(queue.peek()>1) {
    					list.add(queue.poll() - 1);
    				}else {
    					queue.poll();
    				}
    			}
    			result++;
    			if(queue.isEmpty() && list.size() == 0) {
    				break;
    			}
    			i++;
    		}
    		for(int val : list) {
    			queue.add(val);
    		}
    	}
    	return result;
    }
	
    public int leastInterval3(char[] tasks, int n) {
    	int map[] = new int[26];
    	for (int i = 0; i < tasks.length; i++) {
			map[tasks[i] - 'A']++;
		}
    	Arrays.sort(map);
    	int maxTimeOfMax = map[25] - 1;
    	int emptyTime = maxTimeOfMax * n;
    	for (int i = 24; i >= 0 && map[i] > 0; i--) {
    		emptyTime -= Math.min(map[i], maxTimeOfMax);
		}
    	return emptyTime > 0 ? emptyTime + tasks.length : tasks.length;
    }
}
