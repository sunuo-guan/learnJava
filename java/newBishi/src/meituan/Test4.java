package meituan;

import java.util.*;

public class Test4 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = scanner.nextInt();
		}
		
		System.out.println(solution(m, n, r));
	}
	
	public static int solution(int m,int n,int arr[]) {
		int count=0;
		for (int r = 2; r <= m; r++) {
			for (int l = 1; l <= r; l++) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < arr.length; i++) {
					if((arr[i] > 0 && arr[i] < l) || (arr[i] > r && arr[i] < m+1)) {
						list.add(arr[i]);
					}
				}
				if (isMatchArr(list)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static boolean isMatchArr(ArrayList<Integer> list) {
		int size = list.size();
		for (int i = 0; i < size - 1; i++) {
			if (list.get(i) > list.get(i+1)) {
				return false;
			}
		}
		return true;
	}
}
