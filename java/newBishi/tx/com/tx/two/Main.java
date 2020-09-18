package com.tx.two;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		List<HashSet<Integer>> list = new LinkedList<HashSet<Integer>>();
		for (int i = 0; i < m; i++) {
			int x = scanner.nextInt();
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < x; j++) {
				set.add(scanner.nextInt());
			}
			list.add(set);
		}
		System.out.println(solution(list, m));
	}
	
	public static int solution(List<HashSet<Integer>> list,int m) {
		HashSet<Integer> res = new HashSet<Integer>();
		if (list.size() == 0) {
			return 0;
		}
		for (HashSet<Integer> set : list) {
			if (set.contains(0)) {
				res.add(0);
				break;
			}
		}
		if (res.size() == 0) {
			return 0;
		}
		int size = 0;
		HashSet<Integer> temp = new HashSet<Integer>();
		while(size != res.size()) {
			size = res.size();
			HashSet<Integer> temp2 = new HashSet<Integer>();
			if (temp.size() == list.size()) {
				break;
			}
			for(int value : res) {
				for (int i = 0; i < m; i++) {
					if (!temp.contains(i) && list.get(i).contains(value)) {
						temp2.addAll(list.get(i));
						temp.add(i);
					}
				}
			}
			res.addAll(temp2);
		}
		return res.size();
	}
}
