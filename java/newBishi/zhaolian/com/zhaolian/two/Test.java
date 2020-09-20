package com.zhaolian.two;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		int b6,b5,b4,b3,b2,b1;
		int nTotal = 0;
		int c1;
		int c2;
		int[] Contain2 = {0,5,3,1};
		while(true) {
			Scanner sc = new Scanner(System.in);
			b1 = sc.nextInt();
			b2 = sc.nextInt();
			b3 = sc.nextInt();
			b4 = sc.nextInt();
			b5 = sc.nextInt();
			b6 = sc.nextInt();
			if(b1 ==0&&b2==0&&b3==0&&b4==0&&b5==0&&b6==0)
				break;
			nTotal = b6+b5+b4+(b3+3)/4;     //1
			c2 = 5*b4 + Contain2[b3%4];       //2
			if(b2 >c2)
				nTotal += (b2 - c2 + 8) /9;
			c1 = 36 * nTotal - 36*b6 - 25*b5 - 16 * b4 - 9*b3 - 4 * b2;    //3
			if(b1>c1)
				nTotal += (b1 - c1 + 35) / 36;          //4、5
			System.out.println(nTotal);
		}
	}
}
