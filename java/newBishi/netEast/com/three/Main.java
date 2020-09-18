package com.three;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int T = scanner.nextInt();
		List<int[][]> list = new ArrayList<int[][]>();
		for (int i = 0; i < T; i++) {
			int n = scanner.nextInt();
			int move[][] = new int[n][2];
			for (int j = 0; j < move.length; j++) {
				move[j][0] = scanner.nextInt();
				move[j][1] = scanner.nextInt();
			}
			list.add(move);
		}
		for (int i = 0; i < T; i++) {
			int res = solution(list.get(i));
			System.out.println(res);
		}
	}
	
	public static int solution(int[][] move) {
		int len = move.length;
		int length = 10000;
		int map[][] = new int[length][length];
		int x = length / 2,y = length / 2;
		map[x][y] = 1;
		int indexX = x, indexY = y;
		for (int i = 0; i < len; i++) {
			if (move[i][1] == 1) {
				if (move[i][0] == 0) {
					indexY --;
				} else if (move[i][0] == 1) {
					indexY ++;
				} else if (move[i][0] == 2) {
					indexX --;
				} else if (move[i][0] == 3) {
					indexX ++;
				}
				map[indexX][indexY] = 1;
			}
		}
		int res = recurRoad(map,x,y,indexX,indexY);
		return res;
	}
	
	public static int recurRoad(int map[][],int x,int y,int indexX,int indexY) {
		
		return 0;
	}
}
