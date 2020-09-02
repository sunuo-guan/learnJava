package com.offer.chapter4;

public class Test33Demo {
	public static void main(String[] args) {
		Solution33 solution33 = new Solution33();
		int[] order= {5,4,3,2,1};
		System.out.println(solution33.verifyPostorder(order));
	}
}

class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
    	//
    	if(postorder==null) {
    		return false;
    	}
    	if(postorder.length==1||postorder.length==0) {
    		return true;
    	}
    	
    	return verify(postorder, 0, postorder.length-1);
    	
    }
    
    /**
     * 
     * @param postorder 数组一直不变，操作的是下标
     * @param left 当前子树的左边
     * @param right 当前子树的右边
     * @return
     */
    public boolean verify(int[] postorder,int left,int right) {
    	if(right<=left) {
    		return true;
    	}
    	
    	int root=postorder[right];
    	int temp=left;
    	//找到左子树
    	while(left<right&&postorder[temp]<root) {
    		temp++;
    	}
    	
    	//找右子树是否符合条件
    	for (int i = temp; i < right; i++) {
			if(postorder[i]<root) {
				return false;
			}
		}
    	
    	return verify(postorder, left, temp-1)&&verify(postorder, temp, right-1);
    }
}
