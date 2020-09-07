package meituan;

import java.util.*;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] r = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				r[i][j] = scanner.nextInt();
			}
		}
		int res[] = solution(n, r);
		for (int i = 0; i < n; i++) {
			System.out.print(res[i]+" ");
		}
	}
	
	public static int[] solution(int n, int[][] arr) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!map.containsValue(arr[i][j])) {
					map.put(i, arr[i][j]);
					break;
				}
			}
		}
		int res[] = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = map.get(i);
		}
		return res;
	}
}
