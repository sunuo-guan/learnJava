package test;

public class Solution {
	public static void main(String[] args) {
		String str = "1a10b12c";
		System.out.println(solution(str));
	}
	
	public static String solution(String str) {
		char[] strs = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		int index = 0;
    	while(index < strs.length) {
    		int sum = 0;
    		while(strs[index] >= '0' && strs[index] <= '9') {
    			sum = sum * 10 + (strs[index] - '0');
    			index++;
    		}
    		for(int i = 0; i < sum; i++) {
    			sb.append(strs[index]);
    		}
    		index++;
    	}
    	return sb.toString();
    }
}
