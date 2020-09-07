package test2;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		String[] str = {"1a10b12c","2","2","as","wa","as","as"};
		int k = 2;
		String[][] result = topKFrequent(str,k);
		for(int i = 0;i < k;i++) {
			System.out.print(result[i][0] + ",");
			System.out.println(result[i][1]);
		}		
	}
	
	public static String[][] topKFrequent(String[] ipArr, int k) {
        Map<String, Integer> count = new HashMap<String, Integer>();
        for (String ip: ipArr) {
            count.put(ip, count.getOrDefault(ip, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        String[][] result = new String[k][2];
        for(int i=0;i<k;i++) {
        	result[i][0] = candidates.get(i);
        	result[i][1] = count.get(candidates.get(i)) + "";
        }
        return result;
	}
}
