package com.offer.chapter6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Test68Demo {
	public static void main(String[] args) {
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		n1.left=n2;
		
		Solution68 solution68 = new Solution68();
		
		solution68.lowestCommonAncestor2(n1, n1, n2);
	}
}

class Solution68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
        	return root;
        }
        
        //�������������������ȸ��ڵ�С���������ȸ��ڵ��
        //�����ڵ㶼�ȵ�ǰ�ڵ�С������͹���������������
        //�����ڵ㶼�ȵ�ǰ�ڵ������͹���������������
        //������ǵ�ǰ�ڵ�
        if(p.val>root.val&&q.val>root.val) {
        	return lowestCommonAncestor(root.right, p, q);
        }else if(p.val<root.val&&q.val<root.val) {
        	return lowestCommonAncestor(root.left, p, q);
        }else {
        	return root;
        }        
    }
    
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
        	return null;
        }
        
        //ջ�����ڱ����ڵ�
        Stack<TreeNode> stack=new Stack<TreeNode>();
        
        //��ϣ�����ڴ�ŵ�ǰ�ڵ�ĸ��ڵ�  keyΪ��ǰ�ڵ� valueΪ��ǰ�ڵ㸸�ڵ�
        HashMap<TreeNode,TreeNode> map=new HashMap<TreeNode, TreeNode>();
        
        map.put(root, null);     //��ʼ����root�ĸ��ڵ��ǿ�
        stack.push(root);
        
        //һֱ������ֱ���ҵ�p��qΪֹ
        while(!map.containsKey(p)||!map.containsKey(q)) {
        	
        	//�����ڵ㣬���Ÿýڵ����
        	TreeNode temp=stack.pop();
        	
        	if(temp.left!=null) {
        		stack.push(temp.left);
        		map.put(temp.left, temp);
        	}
        	
        	if(temp.right!=null) {
        		stack.push(temp.right);
        		map.put(temp.right,temp );
        	}
        }
        
        //�ҵ�p��q�Ժ󣬽�p�������Ƿŵ�һ��set��
        HashSet<TreeNode> set=new HashSet<TreeNode>();
        
        while(p!=null) {
        	set.add(p);
        	p=map.get(p);
        }
        
        //��q�Ĺ�������·��һֱ�����ң��ҵ���һ��������set�Ľڵ㼴Ϊ�����ڵ�
        while(!set.contains(q)) {
        	q=map.get(q);
        }
        
        return q;
        
    }
}