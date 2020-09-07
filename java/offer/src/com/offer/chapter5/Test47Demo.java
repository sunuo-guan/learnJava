package com.offer.chapter5;

public class Test47Demo {
	public static void main(String[] args) {
		int[][] grid= {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
		System.out.println(maxValue(grid));
	}
	
	public static int maxValue(int[][] grid) {
		if(grid==null||grid.length==0||grid[0].length==0) {
			return -1;
		}
		
		int rows=grid.length;
		int columns=grid[0].length;
		int dp[][]=new int[rows][columns];
		dp[0][0]=grid[0][0];
		
		//由于只能往右或往下走，因此最左和最上一栏的最大价值只能一直往左或一直往下走得到
		for (int i = 1; i < rows; i++) {
			dp[i][0]=grid[i][0]+dp[i-1][0];
		}
		for (int i = 1; i < columns; i++) {
			dp[0][i]=grid[0][i]+dp[0][i-1];
		}
		
		
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j])+grid[i][j];
			}
			
		}
		
		return dp[rows-1][columns-1];
    }
	
	
	/**
	 * 贪心算法：局部最优不能代表总体最优，不可行
	 * @param grid
	 * @return
	 */
	public static int maxValue2(int[][] grid) {
		if(grid==null||grid.length==0||grid[0].length==0) {
			return -1;
		}
		
		int rows=grid.length-1;
		int columns=grid[0].length-1;
		int val=grid[0][0];
		int row=0,column=0;
		while(true) {			
			if(row==rows&&column==columns) {
				break;
			}
			
			if(row+1>rows) {
				column++;
				val=val+grid[row][column];
			}else if(column+1>columns) {
				row++;
				val=val+grid[row][column];
			}else if(grid[row+1][column]>grid[row][column+1]) {
				row++;
				val=val+grid[row][column];
			}else {
				column++;
				val=val+grid[row][column];
			}
		}
		
		return val;
    }
}

