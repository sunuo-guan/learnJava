package com.tree;

public class Test114Demo {

}

class Solution {
    public void flatten(TreeNode root) {
    	TreeNode temp=root;
    	while(temp!=null) {
    		if(temp.left==null) {
    			temp=temp.right;
    		}else {
    			TreeNode leftRight=temp.left;
    			//�ҵ���ǰ�ڵ������������ҽڵ�
    			while(leftRight.right!=null) {
    				leftRight=leftRight.right;
    			}
    			//����ǰ�ڵ���������ӵ����ҽڵ���ұ�
    			leftRight.right=temp.right;
    			//��ǰ�ڵ���ұ߽������
    			temp.right=temp.left;
    			//���������Ϊ��
    			temp.left=null;
    			//�ı���һ���ڵ�Ľӷ�
    			temp=temp.right;
    		}
    	}
    }
}
