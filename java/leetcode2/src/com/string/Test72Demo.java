package com.string;

public class Test72Demo {
	public static void main(String[] args) {
		
	}
	
	public static int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();

        if(len1==0||len2==0){
            return Math.max(len1,len2);
        }

        int dp[][]=new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++){
            dp[i][0]=i;
        }

        for(int i=0;i<=len2;i++){
            dp[0][i]=i;
        }

        /*
         * dp[i-1][j]->dp[i][j]:表示i，j要想达到两个字符串完全一样，要比i-1，j多一步word2的添加操作（或word1的删除）
         * dp[i][j-1]->dp[i][j]:表示i，j要想达到两个字符串完全一样，要比i-1，j多一步word1的添加操作（或word2的删除）
         * dp[i-1][j-1]->dp[i][j]:表示i，j要想达到两个字符串完全一样，要比i-1，j-1多一步word2（或者word1）的替换操作，若i，j最后面比起i-1，j-1多出来的字符是一样的，那么连替换都省下了
         */
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]);
                }else{
                    dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                }
            }
        }

        return dp[len1][len2];

    }
}
