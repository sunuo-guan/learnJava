package com.offer.chapter2;

public class Test14Demo {
	public static void main(String[] args) {
		Solution15 solution15 = new Solution15();
		int i=solution15.hammingWeight(-3);
		System.out.println(i);
	}
}

class Solution15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int flag=1;
        int count=0;
        while(flag>0){
        	int f=flag&n;
            if(f>0){
                count++;
            }
            flag=flag<<1;
        }
        //µ¥¶ÀÅĞ¶Ï·ûºÅÎ»
        if(n<0) {
        	count++;
        }
        return count;
//    	 int res = 0;
//         while(n != 0) {
//             res += n & 1;
//             n >>>= 1;
//         }
//         return res;
    }
}
