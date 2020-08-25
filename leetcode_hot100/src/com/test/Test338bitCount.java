package com.test;

public class Test338bitCount {
	public static void main(String[] args) {
		
	}
	
    public int[] countBits(int num) {
    	int result[] = new int[num+1];
    	for(int i=0;i<=num;i++) {
    		//n&(n-1)将最末的一个1置为0，当循环到n=0时证明已经没有了1，输出计数
    		int sum=0,j=i;
    	    while (j != 0) {
    	        sum++;
    	        j &= (j - 1);
    	    }
    	    result[i] = sum;
    	}
    	return result;
    }
    
    public int[] countBits2(int num) {
    	int result[] = new int[num+1];
    	result[0]=0;
    	//奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
    	//偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
    	for(int i=1;i<=num;i++) {
    		if((i&1)==0) {
    			result[i] = result[i/2];
    		} else {
    			result[i] = result[i-1]+1;
    		}
    	}
    	return result;
    }
}
