package com.datastruture.recursion;

public class MigongDemo {
	public static void main(String[] args) {
		//�����Թ�
		int[][] map=new int[8][8];
		for(int i=0;i<8;i++) {
			map[i][0]=1;
			map[i][7]=1;
			map[0][i]=1;
			map[7][i]=1;
		}
		
		//ǽ
		map[3][1]=1;
		map[3][2]=1;
		map[6][5]=1;
		map[5][5]=1;
		
		//����Թ����
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(map[i][j]+" ");
				
			}
			System.out.println("");
		}
		
		System.out.println("******");
		System.out.println("Ѱ·����Թ�����");
		getWay(map,1,1);
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(map[i][j]+" ");
				
			}
			System.out.println("");
		}
	}
	
	//�����㷨Ѱ·
	//1Ϊǽ 2Ϊ�߹���· 3 Ϊ�߲�ͨ�ĵ�
	//����Ϊ ��ͼ ��ʼ�ص� �趨�յ�Ϊ 6 6
	//����Ϊ ��������
	public static boolean getWay(int[][] map,int i, int j) {
		if(map[6][6]==2) {
			return true;
		}
		else if(map[i][j]==0) {
			map[i][j]=2;           //����˵����ͨ
			if(getWay(map,i+1,j)) {
				return true;
			}else if(getWay(map,i,j+1)) {
				return true;
			}else if(getWay(map, i-1, j)) {
				return true;
			}else if(getWay(map, i, j-1)) {
				return true;
			}else {
				map[i][j]=3;       //����ʧ�� �˵��޷���ͨ
				return false;
			}
		}
		else {
			return false;
		}
	}
	
}
