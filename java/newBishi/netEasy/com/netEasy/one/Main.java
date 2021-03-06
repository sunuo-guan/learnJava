package com.netEasy.one;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		String temp = scanner.nextLine();
		for (int i = 0; i < m; i++) {
			String str = scanner.nextLine();
			String strArr[] = str.split(" ");
			HashSet<String> set = map.getOrDefault(strArr[0], new HashSet<String>());
			set.add(strArr[2]);
			map.put(strArr[0], set);
		}
		System.out.println(solution(map, n));
	}
	
	public static int solution(HashMap<String, HashSet<String>> map, int n) {
		HashSet<String> leafSet = new HashSet<String>();
		for (int i = 1; i <= n; i++) {
			if (!map.containsKey(""+i)) {
				leafSet.add(""+i);
			}
		}
		int res = 0;
		for(String node : map.keySet()) {
			HashSet<String> tempSet = map.get(node);
			if(tempSet.size() == 2 && leafSet.containsAll(tempSet)) {
				res++;
			}
		}
		return res;
	}
}
