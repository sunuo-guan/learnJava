package com.math;

public class Test62Demo {
	public static void main(String[] args) {
		System.out.println(uniquePaths(13, 23));
	}
	
	
	//组合数：总共有m+n-2步，其中n-1（或m-1）步组合
	 public static int uniquePaths(int m, int n) {
	        if(m<=0||n<=0){
	            return 0;
	        }
	        if(m==1||n==1){
	            return 1;
	        }

	        //这样会越界
//	        long up=liancheng(m+n-2,m+n-2-(n-1));
//	        long down=liancheng(n-1,0);
//	        return (int)(up/down);
	        
	        long count = 1;
	        if(n<m){
	            int temp = n;
	            n = m;
	            m = temp;
	        }
	        for(int i=n;i<=m+n-2;i++){
	            count *= i;
	            count /= (i-n+1);
	        }
	        return (int)count;
	    }

	    public static long liancheng(int start,int end){
	        long count=1;
	        while(start>end){
	            count=count*start;
	            start--;
	        }
	        return count;
	    }
}
