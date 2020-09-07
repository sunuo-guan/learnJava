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
         * dp[i-1][j]->dp[i][j]:��ʾi��jҪ��ﵽ�����ַ�����ȫһ����Ҫ��i-1��j��һ��word2����Ӳ�������word1��ɾ����
         * dp[i][j-1]->dp[i][j]:��ʾi��jҪ��ﵽ�����ַ�����ȫһ����Ҫ��i-1��j��һ��word1����Ӳ�������word2��ɾ����
         * dp[i-1][j-1]->dp[i][j]:��ʾi��jҪ��ﵽ�����ַ�����ȫһ����Ҫ��i-1��j-1��һ��word2������word1�����滻��������i��j��������i-1��j-1��������ַ���һ���ģ���ô���滻��ʡ����
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
