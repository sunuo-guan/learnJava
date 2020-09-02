package com.algorithm.dynamic;

public class KnapsackDemo {
	public static void main(String[] args) {
		int[] weight= {1,4,3};    //����ֱ�����
		int[] value= {1500,3000,2000};    //����ֱ�ļ�ֵ
		int numOfGoods=weight.length;   //������������
		
		int capacity=4;        //��������
		
		int[][] v=new int[numOfGoods+1][capacity+1];   //���  ��Ϊ�����ĳ������ ��Ϊ����
		
		int[][] path=new int[numOfGoods+1][capacity+1];
		
		//��ʼ��
		for (int i = 0; i < v.length; i++) {
			v[i][0]=0;
		}
		
		//��ʼ��
		for (int i = 0; i < v[0].length; i++) {
			v[0][i]=0;
		}
		
		for (int i = 1; i < v.length; i++) {
			for (int j = 1; j < v[0].length; j++) {
				//��������������ڵ�ǰ�ı�������
				if(weight[i-1]>j) {
					//����һ�εķ����������з���
					v[i][j]=v[i-1][j];
				}else {
					//������������С�ڵ��ڵ�ǰ�ı�������
					//��Ƚϣ����뵱ǰ�����ʣ������װ���Ӧ����ѷ���֮�ͣ��루��һ��������С�Ƚϣ�
					//ȡ���ֵ
					if(v[i-1][j]>value[i-1]+v[i-1][j-weight[i-1]]) {
						v[i][j]=v[i-1][j];
					}else {
						v[i][j]=value[i-1]+v[i-1][j-weight[i-1]];
						path[i][j]=1;
					}
				}
			}
		}
		
		//������
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[0].length; j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("*******");
		
		int i=path.length-1;
		int j=path[0].length-1;
		while(i>0&&j>0) {
			if(path[i][j]==1) {
				System.out.println("��"+i+"�����ﱻװ��");
				j=j-weight[i-1];
			}
			i--;
		}
	}
}
