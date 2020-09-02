package com.array;

public class Test48Demo {
	public static void main(String[] args) {
		
	}
	
	public static void rotate(int[][] matrix) {
        if(matrix==null){
            return;
        }

        //1¡¢ÏÈ×ªÖÃÔÙ×óÓÒ¾µÏñ
        int len=matrix.length;

        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<len;i++){
            for(int j=0;j<len/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][len-1-j];
                matrix[i][len-1-j]=temp;
            }
        }

    }
}
