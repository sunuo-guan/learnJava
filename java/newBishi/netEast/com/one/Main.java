package com.one;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] values = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
		}
		List<String[]> list = new ArrayList<String[]>();
		for (int i = 0; i < m; i++) {
			int token = scanner.nextInt();
			String people[] = new String[token];
			String temp = scanner.nextLine();
			for (int j = 0; j < token; j++) {
				people[j] = scanner.nextLine();
			}
			list.add(people);
		}
		int res[] = solution(n, m, values, list);
		for (int i = 0; i < m; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] solution(int n, int m, int[] values, List<String[]> list) {
		int res[] = new int[m];
		HashMap<Integer, Stack<Integer>> map = new HashMap<Integer, Stack<Integer>>();
		for (int i = 0; i < n; i++) {
			map.put(i+1, new Stack<Integer>());
		}
		for (int i = 0; i < m; i++) {
			String[] token = list.get(i);
			res[i] = countPrice(token, map, values);
		}
		return res;
	}

	public static int countPrice(String[] token, HashMap<Integer, Stack<Integer>> map, int[] values) {
		int len = token.length;
		int res = 0;
		int left = 0, right = 0;
		for (int i = 0; i < len; i++) {
			String[] handle = token[i].split(" ");
			if (handle[0].equals("left")) {
				if (handle[1].equals("take")) {
					int index = Integer.parseInt(handle[2]);
					if (map.get(index).isEmpty()) {
						left = values[index-1];
					} else {
						left = map.get(index).pop();
					}
				} else if (handle[1].equals("return")) {
					map.get(Integer.parseInt(handle[2])).push(left);
					left = 0;
				} else {
					res += left;
					left = 0;
				}
			} else {
				if (handle[1].equals("take")) {
					int index = Integer.parseInt(handle[2]);
					if (map.get(index).isEmpty()) {
						right = values[index-1];
					} else {
						right = map.get(index).pop();
					}
				} else if (handle[1].equals("return")) {
					map.get(Integer.parseInt(handle[2])).push(right);
					right = 0;
				} else {
					res += right;
					right = 0;
				}
			}
		}
		res = res + left + right;
		return res;
	}
}