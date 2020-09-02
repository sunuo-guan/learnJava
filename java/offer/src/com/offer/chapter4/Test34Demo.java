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
    	//�˳�ѭ������
    	if(node==null) {
    		return;
    	}
    	path.add(node.val);   //�Ƚ���ǰ��ֵ�ӽ�·��
    	sum=sum-node.val;     //����ӽ���ǰ·�����·��֮��
    	if(sum==0&&node.left==null&&node.right==null) {   //·��֮��=sum��ΪҶ�ӽڵ�
    		result.add(new ArrayList<Integer>(path));     //����һ����ӵ�·��
    	}else {
    		findPath(node.left,sum,path);            //�����������еݹ�
    		findPath(node.right,sum,path);
    	}
    	path.remove(path.size()-1);        //������������·�������һ��Ҷ�ӽڵ��Ƴ�·����������������·��
    }
    
}
