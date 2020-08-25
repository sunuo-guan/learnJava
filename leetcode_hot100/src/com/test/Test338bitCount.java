package com.test;

public class Test338bitCount {
	public static void main(String[] args) {
		
	}
	
    public int[] countBits(int num) {
    	int result[] = new int[num+1];
    	for(int i=0;i<=num;i++) {
    		//n&(n-1)����ĩ��һ��1��Ϊ0����ѭ����n=0ʱ֤���Ѿ�û����1���������
    		int sum=0,j=i;
    	    while (j != 0) {
    	        sum++;
    	        j &= (j - 1);
    	    }
    	    result[i] = sum;
    	}
    	return result;
    }
    
    public int[] countBits2(int num) {
    	int result[] = new int[num+1];
    	result[0]=0;
    	//�����������Ʊ�ʾ�У�����һ����ǰ���Ǹ�ż����һ�� 1����Ϊ��ľ������λ�� 1��
    	//ż���������Ʊ�ʾ�У�ż���� 1 �ĸ���һ���ͳ��� 2 ֮����Ǹ���һ���ࡣ��Ϊ���λ�� 0������ 2 ��������һλ��Ҳ���ǰ��Ǹ� 0 Ĩ�����ѣ����� 1 �ĸ����ǲ���ġ�
    	for(int i=1;i<=num;i++) {
    		if((i&1)==0) {
    			result[i] = result[i/2];
    		} else {
    			result[i] = result[i-1]+1;
    		}
    	}
    	return result;
    }
}
