package com.test;

public class FinallyTest {
	public static void main(String[] args) {
		System.out.println(demo4());
	}

	public static int demo4() {
		int i = 0;
		try {
			return i;
		} finally {
			i = 12;
			System.out.println("finally trumps return.");
			return i;
		}
	}

}
