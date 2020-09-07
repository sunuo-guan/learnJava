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
    	
    	//�����Ծ�����������ĸΪ��ͷ��Ѱ���Ƿ���·��
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
    	//�ȸ����˳�����
    	if(pathLen==word.length()) {
    		return true;
    	}
    	
    	boolean hasPath=false;
    	//���жϴ���ķ��ʵ��Ƿ�Ϸ�
    	if(row>=0&&row<rows&&column>=0&&column<columns
    			&&visited[row][column]==false
    			&&board[row][column]==word.charAt(pathLen)) {
    		//����ǰ�����Ϸ������Ƚ���ǰ����Ϊ�ѷ���
        	pathLen++;
        	visited[row][column]=true;
        	
        	//����һ���ܷ��ʵĵ�
        	if(findPath(visited, word, board, row-1, column, pathLen)) {
        		hasPath=true;
        	}else if(findPath(visited, word, board, row+1, column, pathLen)) {
        		hasPath=true;
        	}else if(findPath(visited, word, board, row, column-1, pathLen)) {
        		hasPath=true;
        	}else if(findPath(visited, word, board, row, column+1, pathLen)) {
        		hasPath=true;
        	}
        	
        	//�����ܷ��ʣ�����ݵ���һ����
        	if(hasPath==false) {
        		pathLen--;
        		visited[row][column]=false;
        	}
    	}
    	
    	return hasPath;
    }
}
