package com.zhaohang.two;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int len = 2 * n;
		int arr[] = new int[len];
		int pos[]=new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = scanner.nextInt();
			pos[arr[i]]=i;
		}

		System.out.println(least(arr, pos, len));
	}

	public static int least(int arr[],int pos[], int len) {
		int res = 0;
		for (int i = 0; i < len; i = i + 2) {
			int same;
			if (arr[i] % 2 == 0) {
				same = arr[i] + 1;
			} else {
				same = arr[i] - 1;
			}
			if (arr[i + 1] != same) {
				res++;
				int temp = arr[i + 1];
				int temppos = pos[same];
				swap(arr, i + 1, pos[same]);
				pos[temp] = temppos;
			}
		}
		return res;

	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}