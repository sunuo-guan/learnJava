package com.datastructure.sparsearray;

public class SparseArray {
	
	public static void main(String[] args) {
		//原始棋盘
		int[][] chessArr = new int[11][11];
		chessArr[1][2]=1;
		chessArr[2][3]=2;
		chessArr[3][4]=1;
		
		//创建稀疏数组
		//循环计数，读取,
		int count =0;
		for(int i=0;i<chessArr.length;i++) {
			for(int j=0;j<chessArr[0].length;j++) {
				if(chessArr[i][j]!=0) {
					count++;
				}
				System.out.print(chessArr[i][j]+"  ");
			}
			System.out.println();
		}
		
		System.out.println("********");
		int[][] sparseArr=new int[count+1][3];
		sparseArr[0][0]=11;
		sparseArr[0][1]=11;
		sparseArr[0][2]=count;
		int number=0;
		for(int i=0;i<chessArr.length;i++) {
			for(int j=0;j<chessArr[0].length;j++) {
				if(chessArr[i][j]!=0) {
					number++;
					sparseArr[number][0]=i;
					sparseArr[number][1]=j;
					sparseArr[number][2]=chessArr[i][j];
				}
			}
		}
		for(int i=0;i<sparseArr.length;i++) {
			for(int j=0;j<sparseArr[0].length;j++) {
				System.out.print(sparseArr[i][j]+" ");
			}
			System.out.println();
		}
		
		//稀疏数组恢复	
		System.out.println("*********");
		int chessRe[][] =new int[sparseArr[0][0]][sparseArr[0][1]];
		for(int i=1;i<sparseArr.length;i++) {
			chessRe[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
		}
		for(int i=0;i<chessRe.length;i++) {
			for(int j=0;j<chessRe[0].length;j++) {
				System.out.print(chessRe[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}
	



	
	
}
