package com.offer.chapter4;

import java.util.ArrayList;
import java.util.Arrays;

public class Test37Demo {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		root.left = n1;
		root.right = n2;
		n2.left = n3;
		n2.right = n4;
		Codec codec = new Codec();
		System.out.println(codec.serialize(root));
		String data=codec.serialize(root);
		TreeNode resRoot=codec.deserialize(data);
		System.out.println(codec.serialize(resRoot));
	}
}

class Codec {

    // Encodes a tree to a single string.
	/**
	 * 广度遍历序列化；但深度遍历更合适（利用前序遍历）
	 * @param root
	 * @return
	 */
    public String serialize(TreeNode root) {
        String res="";
    	if(root==null) {
    		res="null";
        	return res;
        }
    	
    	ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
    	
    	queue.add(root);
    	res=res+root.val;
    	
    	while(!queue.isEmpty()) {
    		TreeNode temp=queue.remove(0);
    		if(temp.left!=null) {
    			queue.add(temp.left);
    			res=res+","+temp.left.val;
    		}else {
    			res=res+",null";
    		}
    		
    		if(temp.right!=null) {
    			queue.add(temp.right);
    			res=res+","+temp.right.val;
    		}else {
    			res=res+",null";
    		}
    	}
    	
    	return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null) {
        	return null;
        }
        
        //队列存放node
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        
        //将data拆分
        String strs[]=data.split(",");
        
        //创建头节点
        TreeNode root=new TreeNode(Integer.valueOf(strs[0]));
        
        //加入队列
        queue.add(root);
        int nums=1;  //字符串数组下标
        while(!queue.isEmpty()) {
        	TreeNode temp=queue.remove(0);
        	//判断左节点
        	if(strs[nums].equals("null")) {
        		temp.left=null;
        	}else {
        		TreeNode newNode = new TreeNode(Integer.valueOf(strs[nums]));
        		temp.left=newNode;
        		queue.add(newNode);         //不为空则要加入队列
        	}
        	
        	//判断右节点
        	if(strs[nums+1].equals("null")) {
        		temp.right=null;
        	}else{
        		TreeNode newNode = new TreeNode(Integer.valueOf(strs[nums+1]));
        		temp.right=newNode;
        		queue.add(newNode);
        	}
        	
        	nums=nums+2;
        	
        }
        
        return root;
        
        
    }
}
