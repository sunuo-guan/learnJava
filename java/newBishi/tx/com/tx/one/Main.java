package com.tx.one;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int first[] = new int[n];
		for (int i = 0; i < n; i++) {
			first[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int second[] = new int[m];
		for (int i = 0; i < m; i++) {
			second[i] = scanner.nextInt();
		}
		List<Integer> res = solution(first, second);
		for (int item : res) {
			System.out.print(item + " ");
		}
	}
	
	public static List<Integer> solution(int first[],int second[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < first.length; i++) {
			set.add(first[i]);
		}
		for (int i = 0; i < second.length; i++) {
			if (set.contains(second[i])) {
				list.add(second[i]);
			}
		}
		return list;
	}
}
