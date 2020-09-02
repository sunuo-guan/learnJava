package com.offer.chapter2;

import java.util.Arrays;

public class Test13Demo {
	public static void main(String[] args) {
		Solution13 solution13 = new Solution13();
//		int arr[]=solution13.resolve(1203);
//		System.out.println(Arrays.toString(arr));
		
		int m=1,n=2,k=1;
		int count=solution13.movingCount(m, n, k);
		System.out.println(count);
	}
}

class Solution13 {
	private int count;
	private int rows;
	private int columns;
	
    public int movingCount(int m, int n, int k) {
    	//�쳣�����ж�
    	if(m<=0||n<=0||k<0) {
    		return -1;
    	}
    	boolean[][] visited=new boolean[m][n];
    	rows=m;
    	columns=n;
    	count=0;
    	
    	move(visited, 0, 0, k);
    	
    	return count;
    }
    
    public void move(boolean[][] visited,int row,int column,int k) {
    	//���ж������ֵ�Ƿ�Ϸ����߽磬�Ƿ���ʹ����Ƿ�����������
    	if(row>=0&&row<rows&&column>=0&&column<columns&&
    			visited[row][column]==false&&sumOfResolve(row, column)<=k) {
    		//���Ϸ�����ɴ
    		count++;
    		visited[row][column]=true;
    		
    		//����Χ��
    		move(visited, row-1, column, k);
    		move(visited, row+1, column, k);
    		move(visited, row, column-1, k);
    		move(visited, row, column+1, k);
    		
    		//�߹�����ʧ�ܣ������޸�����
    	}
    }
    
    //����������λ�ֽ�֮��ĸ���λ֮��
    public int sumOfResolve(int row,int column) {
    	int rowVal[]=resolve(row);
    	int columnVal[]=resolve(column);
    	int sum=0;
    	for (int i = 0; i < rowVal.length; i++) {
			sum=rowVal[i]+sum;
		}
    	for (int i = 0; i < columnVal.length; i++) {
			sum=sum+columnVal[i];
		}
    	return sum;
    }
    
    //��һ������λ���ֽ�
    public int[] resolve(int value) {
    	String s=value+"";
    	int maxLen=s.length();
    	int[] resolveVal=new int[maxLen];
    	
    	int n=1;
    	for (int i = 0; i < maxLen; i++) {
    		resolveVal[i]=value/n%10;
			n=n*10;
		}
    	
    	return resolveVal;
    }
}