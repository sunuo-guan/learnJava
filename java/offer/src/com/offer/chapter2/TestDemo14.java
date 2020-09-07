package com.offer.chapter2;

public class TestDemo14 {
	public static void main(String[] args) {
		Solution14 solution14 = new Solution14();
		System.out.println(solution14.cuttingRope2(120));
	}
}

class Solution14 {
    
	/**
	 * 动态规划
	 * @param n
	 * @return
	 */
	public int cuttingRope(int n) {
    	if(n<2) {
    		return 0;
    	}
    	if(n==3) {
    		return 2;
    	}
    	if(n==2) {
    		return 1;
    	}
    	
    	//0-3的最佳解存入数组
        int[] res=new int[n+1];
        res[0]=0;
        res[1]=1;
        res[2]=2;
        res[3]=3;
        
        int max=0;       
        int temp;
        for (int i = 4; i < n+1; i++) {
			
        	for (int j = 1; j <= i/2; j++) {     //另一半不用遍历，会重复
				temp=res[j]*res[i-j];
				if(max<temp) {       //最佳解比较
					max=temp;
				}
			}
        	res[i]=max;
        	max=0;              //务必清空
		}
        
        return res[n];
    }

	/**
	 * 贪心，当n》=5时，尽可能地剪成3的绳子段
	 * @param n
	 * @return
	 */
	public int cuttingRope2(int n) {
    	if(n<2) {
    		return 0;
    	}
    	if(n==3) {
    		return 2;
    	}
    	if(n==2) {
    		return 1;
    	}
    	
    	int numOf3=n/3;
    	int modOf3=n%3;
    	
    	if(modOf3==1) {
    		numOf3--;
    	}
    	
    	int res=1;
    	for(int i=0;i<numOf3;i++) {
    		res=res*3%1000000007;
    	}
    	
    	int lastLen=n-3*numOf3;
    	if(lastLen==0) {
    		return res;
    	}else {
    		res=lastLen*res;
        	return (int)res;
    	}
    	
    	
    	
    }
    
}
