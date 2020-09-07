package com.offer.chapter3;

public class TestDemo16 {
	public static void main(String[] args) {
		Solution16 solution16 = new Solution16();
		System.out.println(solution16.myPow(2, -2147483648));
	}
}

class Solution16 {
	public double myPow(double x, int n) {
		// 要考虑到各种情况：底为零、底不为零；指数为正，零，负
		// 若底为零：
		long longN=n;
		double res;
		if (x == 0.0) {
			return 0;
		}else {
			// 底不为零时，指数为正，零，负
			if (n > 0) {
				res = 1.0;
				for (int i = 0; i < n; i++) {
					res = res * x;
				}
			} else if (n == 0) {
				res = 1.0;
			} else {
				res = 1.0;
				longN = -longN;                 //当 n = -2147483648n=−2147483648 时执行n=−n 会因越界而赋值出错，要转变成long类型
				for (int i = 0; i < longN; i++) {
					res = res * x;
				}
				res = 1.0 / res;
			}
			return res;
		}
	}
}