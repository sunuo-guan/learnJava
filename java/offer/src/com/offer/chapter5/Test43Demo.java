package com.offer.chapter5;

public class Test43Demo {
	public static void main(String[] args) {
		 System.out.println(countDigitOne(142));
	}

	public static int countDigitOne(int n) {
		return recur(n);
	}
	
	/**
	 * 递归求解
	 * @param n
	 * @return
	 */
	public static int recur(int n) {
		if(n<=0) {
			return 0;
		}
		
		String nStr=n+"";
		int nLen=nStr.length();   //最高有多少位
		int highOfn=(int) Math.pow(10, nLen - 1);    //个十百千。。。
		int highest=nStr.charAt(0)-'0';
		int leftover=n%highOfn;          //除去最高位剩下的数字
		
		if(highest==1) {
			return leftover+1+recur(leftover)+recur(highOfn-1);
			/**
			 * 当最高位为1，以千为例，分为三部分：
			 * 1.0-999：recur(highOfn-1)
			 * 2.1000-n的千位：leftover+1
			 * 3.1000-n的非千位：recur(leftover)
			 */
		}else {
			return recur(leftover)+highest*recur(highOfn-1)+highOfn;
			/**
			 * 当最高位不是1，以千为例，分为三部分：
			 * 1.1000-1999：一个单位的最高位highOfn，表示最高位为1的出现次数
			 * 2.0-999，1000-1999，2000-2999中，低三位的出现一的次数：highest*recur(highOfn-1)
			 * 3.x000-xabc：1的出现次数：recur(leftover)
			 */
		}
		
	}

	/**
	 * 直接求解太慢
	 * 
	 * @param n
	 * @return
	 */
	public static int numOf1(int n) {
		int numOf1 = 0;
		for (int i = 0; i <= n; i++) {
			numOf1 = numOf1 + has1(i);
		}
		return numOf1;
	}

	public static int has1(int n) {
		int res = 0;
		int mod = n;
		while (mod != 0) {
			if (mod % 10 == 1) {
				res++;
			}
			mod = mod / 10;
		}
		return res;
	}

//	数学法：
//	将 ii 从 11 遍历到 nn，每次遍历 ii 扩大 1010 倍：
//	(n/(i*10))*i表示 (i*10)位上 ’1’ 的个数。
//	min(max((n mod (i*10))−i+1,0),i) 表示需要额外数的 (i*10)位上’1’ 的个数。
	public static int mathMethod(int n) {
		int cnt = 0;
		for (int m = 1; m <= n; m *= 10) {
			int a = n / m, b = n % m;
			cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
		}
		return cnt;
	}

}
