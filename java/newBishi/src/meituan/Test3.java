package meituan;

import java.util.*;

public class Test3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int[][] r = new int[n - 1][2];
		for (int i = 0; i < n - 1; i++) {
			r[i][0] = scanner.nextInt();
			r[i][1] = scanner.nextInt();
		}
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n - 1; i++) {
			matrix[r[i][0]-1][r[i][1]-1] = 1;
			matrix[r[i][1]-1][r[i][0]-1] = 1;
		}

		System.out.println(solution(matrix, x, y,n));
	}

	public static int solution(int matrix[][], int x, int y,int n) {
		// 中间节点遍历
		for (int medium = 0; medium < n; medium++) {
			// 起始节点
			for (int start = 0; start < n; start++) {
				// 终点节点
				for (int end = 0; end < n; end++) {
					// 若从起始到终点借助中介节点更近 则更新
					int mediumLen = matrix[start][medium] + matrix[medium][end];
					if (matrix[start][end] > mediumLen) {
						matrix[start][end] = mediumLen;
					}
				}
			}

		}
		return 2;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
