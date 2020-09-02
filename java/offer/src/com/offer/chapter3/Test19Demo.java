package com.offer.chapter3;

public class Test19Demo {
	public static void main(String[] args) {
		String s="ab";
		String p=".*";
		Solution19 solution19 = new Solution19();
		System.out.println(solution19.isMatch(s, p));
	}
}

class Solution19 {
    public boolean isMatch(String s, String p) {
        //非法输入检查
        if(s==null||p==null){
            return false;
        }

        int sLen=s.length();
        int pLen=p.length();
        
        boolean[][] dp=new boolean[sLen+1][pLen+1];
        dp[0][0]=true;
        
        //先初始化表的第一列
        for (int i = 1; i <= pLen; i++) {
			if(p.charAt(i-1)=='*') {
				dp[0][i]=dp[0][i-2];
			}
		}
        
        for (int i = 1; i <= sLen; i++) {
        	for (int j = 1; j <= pLen; j++) {
				if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.') {
					dp[i][j]=dp[i-1][j-1];
				}else if(p.charAt(j-1)=='*') {
					if(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.') {      //先判断是否有点'.'
						dp[i][j]=dp[i][j-2]||dp[i][j-1]||dp[i-1][j];
					}else if(p.charAt(j-2)!=s.charAt(i-1)) {       //!!!
						dp[i][j]=dp[i][j-2];
					}
				}
			}			
		}
        
        return dp[sLen][pLen];
    }

   
}
