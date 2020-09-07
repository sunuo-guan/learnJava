package com.graph;

import java.util.*;

public class Test207Demo {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        
        //cp[1]->cp[0]
        //indegrees记录每个节点的入度，adjacency记录每个节点的出度节点
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        //入度为零的节点入队列
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);

        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            //删除出队列节点，即将出队列节点为入的节点的入度减一
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }
}
