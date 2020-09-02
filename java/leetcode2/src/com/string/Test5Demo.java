package com.string;

public class Test5Demo {
	public static void main(String[] args) {
		String s="bananas";
		System.out.println(longestPalindrome(s));
	}
	
	public static String longestPalindrome2(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        
        //动态规划：dp存储之前是否为回文字符串
        int len=s.length();
        boolean dp[][]=new boolean[len][len];
        String res="";
        
        //每次遍历长度固定，改变起点终点
        for(int length=1;length<=len;length++) {
        	for(int start=0;start<len;start++) {
        		int end=length+start-1;
        		if(end>=len) {
        			break;
        		}
        		dp[start][end]=(length==1||length==2||dp[start+1][end-1])&&s.charAt(start)==s.charAt(end);
        		if(dp[start][end]) {
        			res=s.substring(start, end+1);
        		}
        	}
        }
        
        return res;
        
    }
	
	//3.22
    public static String longestPalindrome(String s) {
         if(s==null||s.length()==0){
             return s;
         }

        int length=s.length();
        boolean dp[][]=new boolean[length][length];
        String res="";

        for(int lenOfSbub=1;lenOfSbub<=length;lenOfSbub++){
            for(int start=0;start<length;start++){
                int end=start+lenOfSbub-1;
                if(end>=length){
                    break;
                }
                if(lenOfSbub==1){
                    dp[start][end]=true;
                }else if(lenOfSbub==2){
                    if(s.charAt(start)==s.charAt(end)){
                        dp[start][end]=true;
                    }
                }else{
                    if(s.charAt(start)==s.charAt(end)&&dp[start+1][end-1]){
                        dp[start][end]=true;
                    }
                }
                if(dp[start][end]==true){
                    res=s.substring(start,end+1);
                }
            }
            
        }

        return res;
        

    }
	
	//中心向外遍历：
	public static String longestPalindrome3(String s) {
		if(s==null||s.length()==0){
            return "";
        }
		
		int start=0,end=0;
		
		for (int i = 0; i < s.length(); i++) {
			int len1=centerExpand(i, i, s);
			int len2=centerExpand(i, i+1, s);
			int len=Math.max(len1, len2);
			if(len>end-start) {
				start=i-(len-1)/2;
				end=i+len/2;
			}
		}
		
		return s.substring(start,end+1);
		
	}
	
	private static int centerExpand(int left,int right,String s) {
		int l=left,r=right;
		while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)) {
			l--;
			r++;
		}
		return r-l-1;
	}
}
