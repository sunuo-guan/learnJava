package com.two;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int T = scanner.nextInt();
		int H = scanner.nextInt();
		int W = scanner.nextInt();
		char[][] ping = new char[H][W];
		String[] arr = new String[H];
		for (int i = 0; i < H; i++) {
			arr[i] = scanner.nextLine();
			ping[i] = arr[i].toCharArray();
		}
		int P = scanner.nextInt();
		int Q = scanner.nextInt();
		String arr2[] = new String[P];
		char[][] zhu = new char[P][Q];
		for (int i = 0; i < P; i++) {
			arr2[i] = scanner.nextLine();
			zhu[i] = arr2[i].toCharArray();
		}
		int i = scanner.nextInt();
		int j = scanner.nextInt();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
	}
}
