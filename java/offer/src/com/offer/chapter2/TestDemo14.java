package com.offer.chapter2;

public class TestDemo14 {
	public static void main(String[] args) {
		Solution14 solution14 = new Solution14();
		System.out.println(solution14.cuttingRope2(120));
	}
}

class Solution14 {
    
	/**
	 * ��̬�滮
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
    	
    	//0-3����ѽ��������
        int[] res=new int[n+1];
        res[0]=0;
        res[1]=1;
        res[2]=2;
        res[3]=3;
        
        int max=0;       
        int temp;
        for (int i = 4; i < n+1; i++) {
			
        	for (int j = 1; j <= i/2; j++) {     //��һ�벻�ñ��������ظ�
				temp=res[j]*res[i-j];
				if(max<temp) {       //��ѽ�Ƚ�
					max=temp;
				}
			}
        	res[i]=max;
        	max=0;              //������
		}
        
        return res[n];
    }

	/**
	 * ̰�ģ���n��=5ʱ�������ܵؼ���3�����Ӷ�
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
