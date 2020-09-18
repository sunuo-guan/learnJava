package com.tx.three;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		String r[] = new String[n];
		for (int i = 0; i < n; i++) {
			r[i] = scanner.next();
		}
		solution(k, r);
	}
	
	public static void solution(int k,String r[]) {
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < r.length; i++) {
			map.put(r[i],map.getOrDefault(r[i], 0) + 1);
		}
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() == o1.getValue() ? stringCompare(o2.getKey(),o1.getKey()) : o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < k; i++) {
			System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
		}
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() == o1.getValue() ? stringCompare(o2.getKey(),o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });
        for (int i = 0; i < k; i++) {
			System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
		}
	}
	
	public static int stringCompare(String str1,String str2) {
		int minLen = Math.min(str1.length(), str2.length());
		for (int i = 0; i < minLen; i++) {
			if (str2.charAt(i) == str1.charAt(i)) {
				continue;
			} else {
				return str2.charAt(i) - str1.charAt(i);
			}
		}
		return str2.length() - str1.length();
	}
}