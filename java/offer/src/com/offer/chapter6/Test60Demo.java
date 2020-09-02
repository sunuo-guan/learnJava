package com.offer.chapter6;

import java.util.Arrays;

public class Test60Demo {
	public static void main(String[] args) {
		int n=11;
		System.out.println(Arrays.toString(twoSum(n)));
	}
	
    public static double[] twoSum(int n) {
    	if(n<=0) {
    		return new double[0];
    	}
    	
    	final int maxPoint=6;
    	
    	//�����������飬�����洢����֮�ͳ��ֵĴ������±꼴Ϊ����֮�ͣ��Լ��ٿռ�ʹ��
    	int temp[][]=new int[2][maxPoint*n+1];
    	
    	int flag=0;   //�����л��ı�־
    	
    	//��ʼ������ֻ��һ������
    	for(int i=1;i<=maxPoint;i++) {
    		temp[flag][i]=1;
    	}
    	
    	//�������������
    	for(int k=2;k<=n;k++) {
    		for(int j=0;j<k;j++) {
    			temp[1-flag][j]=0;     //�����������µ���֮�͵������������
    		}
    		
    		for(int j=k;j<=maxPoint*k;j++) {
    			temp[1-flag][j]=0;    //�����������µ���֮�͵������������
    			for (int o = 1; o <=j&&o<=maxPoint; o++) {
    				//�¼���һ�����Ӻ��µĵ���֮�ͣ��±�j����Ϊǰһ��j-1ֱ��j-6�Ĵ���֮��
    				//����Ϊ�������ӿ��ܳ��ֵĵ���Ϊ1-6�����ǰһ��j-1��j-6�ڱ��ֶ��п��ܳ�Ϊj
					temp[1-flag][j]+=temp[flag][j-o];             
				}
    		}
    		
    		flag=1-flag;
    	}
    	
    	double total=Math.pow(maxPoint, n);
    	double res[]=new double[maxPoint*n+1-n];
    	
    	for (int i = n; i <= maxPoint*n; i++) {
			res[i-n]=temp[flag][i]/total;
		}
    	
    	return res;
    }
}
