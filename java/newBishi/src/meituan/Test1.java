package meituan;

import java.util.*;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n = scanner.nextInt();
		String str = scanner.next();
		int tou = touIndex(str, n) + 1;
		int wei = weiIndex(str, n);
		String res = str.substring(tou, wei);
		System.out.println(res);
	}
	
	public static int touIndex(String str, int n) {
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'T') {
				for (int j = 0; j < i; j++) {
					if (str.charAt(j) == 'M') {
						return i;
					}
				}
			}
		}
		return -1;
	}
	
	public static int weiIndex(String str, int n) {
		for (int i = n-1; i >= 0; i--) {
			if(str.charAt(i) == 'M') {
				for (int j = n-1; j > i; j--) {
					if (str.charAt(j) == 'T') {
						return i;
					}
				}
			}
		}
		return -1;
	}
}
