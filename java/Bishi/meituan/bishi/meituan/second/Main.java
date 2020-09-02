package bishi.meituan.second;

import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = scanner.nextInt();
		}
		Arrays.sort(r);
		
		double result = 0.0;
		int index = r.length;
		while (index > 1) {
			result = result + (Math.pow(r[index - 1], 2) - Math.pow(r[index - 2], 2))*Math.PI;
			index = index - 2;
		}
		if (index == 1) {
			result = result + Math.pow(r[index - 1], 2)*Math.PI;
		}
		System.out.print(String.format("%.5f", result));
	}
}
