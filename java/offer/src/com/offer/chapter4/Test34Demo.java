package com.offer.chapter4;

import java.util.ArrayList;
import java.util.List;

public class Test34Demo {
	public static void main(String[] args) {
		
	}
}

class Solution34 {
	private List<List<Integer>> result;
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	result=new ArrayList<List<Integer>>();
    	findPath(root, sum, new ArrayList<Integer>());
    	return result;
    }
    
    public void	findPath(TreeNode node,int sum,ArrayList<Integer> path) {
    	//退出循环条件
    	if(node==null) {
    		return;
    	}
    	path.add(node.val);   //先将当前的值加进路径
    	sum=sum-node.val;     //计算加进当前路径后的路径之和
    	if(sum==0&&node.left==null&&node.right==null) {   //路径之和=sum且为叶子节点
    		result.add(new ArrayList<Integer>(path));     //拷贝一份添加到路径
    	}else {
    		findPath(node.left,sum,path);            //左右子树进行递归
    		findPath(node.right,sum,path);
    	}
    	path.remove(path.size()-1);        //把满足条件的路径的最后一个叶子节点移出路径，继续找其他的路径
    }
    
}
