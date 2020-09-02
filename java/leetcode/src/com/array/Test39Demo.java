package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*回溯框架
 * result = []
 * def backtrack(路径, 选择列表):
 * 		if 满足结束条件:
 * 			result.add(路径)
 * 			return
 * 
 * 		for 选择 in 选择列表:
 * 			做选择
 * 			backtrack(路径, 选择列表)
 * 			撤销选择
 */
public class Test39Demo {
	public static void main(String[] args) {
		int candidates[]= {2,3,6,7};
		int target=7;
		Solution39 solution39 = new Solution39();
		List<List<Integer>> res=solution39.combinationSum(candidates, target);
		
	}
}

//剪枝，去重复
class Solution39 {
	private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res=new LinkedList<List<Integer>>();
        if(candidates==null||candidates.length==0){
            return res;
        }
        
        //排序，便于剪枝
        Arrays.sort(candidates);
        LinkedList<Integer> list=new LinkedList<Integer>();
        
        recur(candidates, target, list,0,0);
        
        return res;
    }
    
    /**
     * 
     * @param candidates  必须有序
     * @param target
     * @param list
     * @param addAll   和超过target就不再往下找，
     * @param start    从当前点开始往下找，以免找到以前的分支搜索过了的数
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

