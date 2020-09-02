package com.offer.chapter6;

public class Test65Demo {
	public static void main(String[] args) {
		int a = -1, b = 2;
		System.out.println(add(a, b));
	}

	/**
	 * 1.异或求不考虑进位 2.与运算求出进位后左移一位 3.异或结果和进位结果重复1、2，直到2的值为0
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b) {
		int temp;
		while (b != 0) {
			temp = a ^ b;
			b = (a & b) << 1;
			a=temp;
		}

		return a;
	}
}
