package com.string;

import java.util.ArrayList;

public class Test79Demo {
	public static void main(String[] args) {
		Solution79 solution79 = new Solution79();
		char[][] board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word="ABCB";
		System.out.println(solution79.exist(board, word));
	}
}

class Solution79 {
    boolean isExist=false;
    boolean isVisited[][];
    int rows,columns;
    public boolean exist(char[][] board, String word) {
        rows=board.length;
        columns=board[0].length;
        isVisited=new boolean[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(isExist){
                    return isExist;
                }
                if(board[i][j]==word.charAt(0)){
                    ArrayList<Character> list=new ArrayList<Character>();
                    isVisited[i][j]=true;
                    list.add(word.charAt(0));
                    recur(board,word,list,1,i,j);
                    isVisited[i][j]=false;
                }
            }
        }
        
        return isExist;
    }

    public void recur(char[][] board, String word,ArrayList<Character> list,int start,int row,int column){
        if(list.size()==word.length()){
            isExist=true;
            return;
        }

        if(row-1>=0&&!isVisited[row-1][column]&&board[row-1][column]==word.charAt(start)){
            list.add(word.charAt(start));
            isVisited[row-1][column]=true;
            recur(board,word,list,start+1,row-1,column);
            if(isExist){
                return;
            }
            isVisited[row-1][column]=false;
            list.remove(list.size()-1);
        }

        if(column+1<columns&&!isVisited[row][column+1]&&board[row][column+1]==word.charAt(start)){
            list.add(word.charAt(start));
            isVisited[row][column+1]=true;
            recur(board,word,list,start+1,row,column+1);
            if(isExist){
                return;
            }
            isVisited[row][column+1]=false;
            list.remove(list.size()-1);
        }

        if(row+1<rows&&!isVisited[row+1][column]&&board[row+1][column]==word.charAt(start)){
            list.add(word.charAt(start));
            isVisited[row+1][column]=true;
            recur(board,word,list,start+1,row+1,column);
            if(isExist){
                return;
            }
            isVisited[row+1][column]=false;
            list.remove(list.size()-1);
        }

        if(column-1>=0&&!isVisited[row][column-1]&&board[row][column-1]==word.charAt(start)){
            list.add(word.charAt(start));
            isVisited[row][column-1]=true;
            recur(board,word,list,start+1,row,column-1);
            if(isExist){
                return;
            }
            isVisited[row][column-1]=false;
            list.remove(list.size()-1);
        }

    }
}