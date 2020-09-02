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
        
        //二叉搜索树，左子树比父节点小，右子树比父节点大
        //若两节点都比当前节点小，则最低公共祖先在左子树
        //若两节点都比当前节点大，则最低公共祖先在右子树
        //否则就是当前节点
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
        
        //栈，用于遍历节点
        Stack<TreeNode> stack=new Stack<TreeNode>();
        
        //哈希表，用于存放当前节点的父节点  key为当前节点 value为当前节点父节点
        HashMap<TreeNode,TreeNode> map=new HashMap<TreeNode, TreeNode>();
        
        map.put(root, null);     //初始化，root的父节点是空
        stack.push(root);
        
        //一直遍历，直到找到p和q为止
        while(!map.containsKey(p)||!map.containsKey(q)) {
        	
        	//弹出节点，沿着该节点遍历
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
        
        //找到p和q以后，将p的祖先们放到一个set中
        HashSet<TreeNode> set=new HashSet<TreeNode>();
        
        while(p!=null) {
        	set.add(p);
        	p=map.get(p);
        }
        
        //按q的公共祖先路径一直往上找，找到第一个存在于set的节点即为公共节点
        while(!set.contains(q)) {
        	q=map.get(q);
        }
        
        return q;
        
    }
}