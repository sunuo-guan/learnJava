package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*���ݿ��
 * result = []
 * def backtrack(·��, ѡ���б�):
 * 		if �����������:
 * 			result.add(·��)
 * 			return
 * 
 * 		for ѡ�� in ѡ���б�:
 * 			��ѡ��
 * 			backtrack(·��, ѡ���б�)
 * 			����ѡ��
 */
public class Test39Demo {
	public static void main(String[] args) {
		int candidates[]= {2,3,6,7};
		int target=7;
		Solution39 solution39 = new Solution39();
		List<List<Integer>> res=solution39.combinationSum(candidates, target);
		
	}
}

//��֦��ȥ�ظ�
class Solution39 {
	private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res=new LinkedList<List<Integer>>();
        if(candidates==null||candidates.length==0){
            return res;
        }
        
        //���򣬱��ڼ�֦
        Arrays.sort(candidates);
        LinkedList<Integer> list=new LinkedList<Integer>();
        
        recur(candidates, target, list,0,0);
        
        return res;
    }
    
    /**
     * 
     * @param candidates  ��������
     * @param target
     * @param list
     * @param addAll   �ͳ���target�Ͳ��������ң�
     * @param start    �ӵ�ǰ�㿪ʼ�����ң������ҵ���ǰ�ķ�֧�������˵���
     */
    private void recur(int[] candidates,int target,LinkedList<Integer> list,int addAll,int start) {
    	int sum=0;
    	for(int i:list) {
    		sum+=i;
    	}
    	
    	if(sum==target) {
    		res.add(new LinkedList<Integer>(list));
    		return;
    	}else {
    		for(int i=start;i<candidates.length;i++) {
    			if(addAll+candidates[i]>target) {
    				break;
    			}
    			list.add(candidates[i]);
    			recur(candidates, target, list,sum+candidates[i],i);
    			list.removeLast();
    		}    		
    	}
    }
}

