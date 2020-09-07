package com.array;

public class Test200Demo {
	public static void main(String[] args) {
		//char grid[][]= {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		char grid[][]= {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
		System.out.println(numIslands(grid));
	}
	
	//深度遍历
	public static int numIslands(char[][] grid) {
        int num=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    num++;
                    dfs(i, j, grid);
                }
            }
        }

        return num;
	}
	
	public static void dfs(int i,int j,char[][] grid) {
		int rows=grid.length;
		int columns=grid[0].length;
		
		if(i<0||j<0||i>=rows||j>=columns||grid[i][j]=='0') {
			return;
		}
		
		grid[i][j]='0';
		dfs(i-1, j, grid);
		dfs(i+1, j, grid);
		dfs(i, j+1, grid);
		dfs(i, j-1, grid);
	}
	
	//方法二：广度遍历
	//方法三：并查集
}
