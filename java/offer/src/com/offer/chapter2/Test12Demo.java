package com.offer.chapter2;

public class Test12Demo {
	public static void main(String[] args) {
		
	}
}

class Solution11 {
	private boolean visited[][];
	private int pathLen;
	private int rows;
	private int columns;
	
    public boolean exist(char[][] board, String word) {
    	if(board.length==0||word==""||board==null) {
    		return false;
    	}
    	rows=board.length;
    	columns=board[0].length;
    	pathLen=0;
    	visited=new boolean[rows][columns];
    	
    	//遍历以矩阵内所有字母为开头，寻找是否有路径
    	for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(findPath(visited, word, board,i,j,pathLen)) {
					return true;
				}
			}
		}
    	
    	return false;
    	
    }
    
    public boolean findPath(boolean visited[][],String word,char[][] board,int row,int column,int pathLen) {
    	//先给出退出条件
    	if(pathLen==word.length()) {
    		return true;
    	}
    	
    	boolean hasPath=false;
    	//先判断传入的访问点是否合法
    	if(row>=0&&row<rows&&column>=0&&column<columns
    			&&visited[row][column]==false
    			&&board[row][column]==word.charAt(pathLen)) {
    		//若当前传入点合法，则先将当前点置为已访问
        	pathLen++;
        	visited[row][column]=true;
        	
        	//找下一个能访问的点
        	if(findPath(visited, word, board, row-1, column, pathLen)) {
        		hasPath=true;
        	}else if(findPath(visited, word, board, row+1, column, pathLen)) {
        		hasPath=true;
        	}else if(findPath(visited, word, board, row, column-1, pathLen)) {
        		hasPath=true;
        	}else if(findPath(visited, word, board, row, column+1, pathLen)) {
        		hasPath=true;
        	}
        	
        	//都不能访问，则回溯到上一个点
        	if(hasPath==false) {
        		pathLen--;
        		visited[row][column]=false;
        	}
    	}
    	
    	return hasPath;
    }
}
