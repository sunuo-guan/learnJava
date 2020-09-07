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
        //indegrees��¼ÿ���ڵ����ȣ�adjacency��¼ÿ���ڵ�ĳ��Ƚڵ�
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        //���Ϊ��Ľڵ������
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);

        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            //ɾ�������нڵ㣬���������нڵ�Ϊ��Ľڵ����ȼ�һ
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }
}
