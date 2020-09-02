package test3;

import java.util.*;

public class Nonghang {
	public static void main(String[] args) {
		String[] strArr = {"s1","s3","s9","s4","h1","p3","p2","q5","q4","q13","k2","k1"};
		solution(strArr);
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i]+" ");
		}
	}
	
	public static String[] solution(String[] strArr) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('k', 0);
		map.put('s', 1);
		map.put('h', 2);
		map.put('p', 3);
		map.put('q', 4);
		Arrays.sort(strArr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				int num1 = 0,num2 = 0;
				for (int i = 1; i < s1.length(); i++) {
					num1 = num1 * 10 + s1.charAt(i) - '0';
				}
				for (int i = 1; i < s2.length(); i++) {
					num2 = num2 * 10 + s2.charAt(i) - '0';
				}
				return map.get(s1.charAt(0)) == map.get(s2.charAt(0)) ? num1 - num2 : map.get(s1.charAt(0)) - map.get(s2.charAt(0));
			}
		});
		return strArr;
	}
}
