package com.array;

public class Test240Demo {
	public static void main(String[] args) {
		int matrix[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int target = 1;
		System.out.println(searchMatrix(matrix, target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0||matrix[0].length==0) {
			return false;
		}
		int rows = matrix.length;
		int columns = matrix[0].length;

		//起点选定：必须为左下或右上
		int i = rows-1, j = 0;
		
		while(i>=0&&j<columns) {
			if(matrix[i][j]<target) {
				j++;
			}else if(matrix[i][j]>target) {
				i--;
			}else {
				return true;
			}
		}
		
		return false;

	}
}
