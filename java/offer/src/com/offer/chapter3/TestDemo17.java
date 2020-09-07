package com.offer.chapter3;

public class TestDemo17 {
	public static void main(String[] args) {
		Solution17 solution17 = new Solution17();
		//System.out.println(Arrays.toString(solution17.printNumbers(2)));
		solution17.print1ToMaxOfNDigits(2);
	}
}

class Solution17 {
	public int[] printNumbers(int n) {
		
		int maxVal = 1;
		for (int i = 0; i < n; i++) {
			maxVal = maxVal * 10;
		}
		maxVal = maxVal - 1;
		int res[] = new int[maxVal];
		for (int i = 0, j = 1; i < maxVal; i++, j++) {
			res[i] = j;
		}
		return res;
	}
	
	// 考虑大数问题
	public void print1ToMaxOfNDigits(int n) {
		if (n <= 0)
			return;
		char[] number = new char[n];
		print1ToMaxOfNDigits(number, 0);
	}

	private void print1ToMaxOfNDigits(char[] number, int digit) {
		if (digit == number.length) {
			printNumber(number);
			return;
		}
		for (int i = 0; i < 10; i++) {
			number[digit] = (char) (i + '0');                      //递归，从低位到高位不断遍历0-9并打印
			print1ToMaxOfNDigits(number, digit + 1);
		}
	}

	private void printNumber(char[] number) {
		int index = 0;
		while (index < number.length && number[index] == '0')   //高位为零则不打印，从高位不为零开始打印
			index++;
		while (index < number.length)           
			System.out.print(number[index++]);
		System.out.println();
	}
}