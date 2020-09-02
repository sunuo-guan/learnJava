package com.offer.chapter6;

public class Test65Demo {
	public static void main(String[] args) {
		int a = -1, b = 2;
		System.out.println(add(a, b));
	}

	/**
	 * 1.����󲻿��ǽ�λ 2.�����������λ������һλ 3.������ͽ�λ����ظ�1��2��ֱ��2��ֵΪ0
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
