package com.array;

import java.util.*;

public class Test46Demo {

}


class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0){
            return res;
        }

        boolean isVisited[]=new boolean[nums.length];
        LinkedList<Integer> list=new LinkedList<Integer>();

        recur(nums,res,list,isVisited);

        return res;
    }

    public void recur(int[] nums,List<List<Integer>> res, LinkedList<Integer> list,boolean isVisited[]){
        if(list.size()==nums.length){
            res.add(new LinkedList<Integer>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!isVisited[i]){
                list.add(nums[i]);
                isVisited[i]=true;
                recur(nums,res,list,isVisited);
                list.removeLast();
                isVisited[i]=false;
            }
        }
    }
}