package com.offer.chapter5;

public class Test49Demo {
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(1690));
	}
	
	public static int nthUglyNumber(int n) {
		if(n<=0) {
			return 0;
		}
		
		int index2=0,index3=0,index5=0;   //三指针
		int uglyVal[]=new int[n];
		uglyVal[0]=1;
		
		for (int i = 1; i < n; i++) {
			int temp=Math.min(uglyVal[index2]*2, uglyVal[index3]*3);
			uglyVal[i]=Math.min(temp, uglyVal[index5]*5);
			
			//每次添加丑数进入数组后，三指针分别移动到乘以2、3、5后最小的大于新添加进数组的丑数的位置
			while(uglyVal[index2]*2<=uglyVal[i]) {
				index2++;
			}
			while(uglyVal[index3]*3<=uglyVal[i]) {
				index3++;
			}
			while(uglyVal[index5]*5<=uglyVal[i]) {
				index5++;
			}
		}
		
		return uglyVal[n-1];
		
    }
}
