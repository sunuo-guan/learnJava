package com.datastruture.recursion;

public class MigongDemo {
	public static void main(String[] args) {
		//创建迷宫
		int[][] map=new int[8][8];
		for(int i=0;i<8;i++) {
			map[i][0]=1;
			map[i][7]=1;
			map[0][i]=1;
			map[7][i]=1;
		}
		
		//墙
		map[3][1]=1;
		map[3][2]=1;
		map[6][5]=1;
		map[5][5]=1;
		
		//输出迷宫情况
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(map[i][j]+" ");
				
			}
			System.out.println("");
		}
		
		System.out.println("******");
		System.out.println("寻路后的迷宫如下");
		getWay(map,1,1);
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(map[i][j]+" ");
				
			}
			System.out.println("");
		}
	}
	
	//回溯算法寻路
	//1为墙 2为走过的路 3 为走不通的点
	//输入为 地图 起始地点 设定终点为 6 6
	//策略为 下右上左
	public static boolean getWay(int[][] map,int i, int j) {
		if(map[6][6]==2) {
			return true;
		}
		else if(map[i][j]==0) {
			map[i][j]=2;           //假设此点可走通
			if(getWay(map,i+1,j)) {
				return true;
			}else if(getWay(map,i,j+1)) {
				return true;
			}else if(getWay(map, i-1, j)) {
				return true;
			}else if(getWay(map, i, j-1)) {
				return true;
			}else {
				map[i][j]=3;       //假设失败 此点无法走通
				return false;
			}
		}
		else {
			return false;
		}
	}
	
}
