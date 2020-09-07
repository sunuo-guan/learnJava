package com.algorithm.floyd;

public class FloydDemo {
	private static final int maxValue = 10000;

	public static void main(String[] args) {
		int edge[][] = { { 0, 5, 7, maxValue, maxValue, maxValue, 2 },
				{ 5, 0, maxValue, 9, maxValue, maxValue, 3 },
				{ 7, maxValue, 0, maxValue, 8, maxValue, maxValue },
				{ maxValue, 9, maxValue, 0, maxValue, 4, maxValue },
				{ maxValue, maxValue, 8, maxValue, 0, 5, 4 },
				{ maxValue, maxValue, maxValue, 4, 5, 0, 6 },
				{ 2, 3, maxValue, maxValue, 4, 6, 0 } };
		char[] data = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		Graph graph = new Graph(data, edge);
		graph.showGraph();
		System.out.println("**********");
		graph.floyd();
		graph.showGraph();
	}
}

class Graph {
	private int vertexsNum;
	private char[] vertex;
	private int[][] edges;
	private int[][] pre;

	public Graph(char[] vertex, int[][] edges) {
		vertexsNum = vertex.length;
		this.vertex = new char[vertexsNum];
		this.edges = new int[vertexsNum][vertexsNum];
		this.pre = new int[vertexsNum][vertexsNum];

		// 赋值
		for (int i = 0; i < vertexsNum; i++) {
			this.vertex[i] = vertex[i];
		}

		for (int i = 0; i < vertexsNum; i++) {
			for (int j = 0; j < vertexsNum; j++) {
				this.edges[i][j] = edges[i][j];
			}
		}

		for (int i = 0; i < vertexsNum; i++) {
			for (int j = 0; j < vertexsNum; j++) {
				this.pre[i][j] = i;
			}
		}
	}

	//显示
	public void showGraph() {
		for (int i = 0; i < vertexsNum; i++) {
			for (int j = 0; j < vertexsNum; j++) {
				System.out.print(edges[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=======");
		for (int i = 0; i < vertexsNum; i++) {
			for (int j = 0; j < vertexsNum; j++) {
				System.out.print(vertex[pre[i][j]] + " ");
			}
			System.out.println();
		}
	}
	
	//floyd
	public void floyd() {
		
		//中间节点遍历
		for (int medium = 0; medium < vertexsNum; medium++) {
			//起始节点
			for(int start=0;start<vertexsNum;start++) {
				//终点节点
				for(int end=0;end<vertexsNum;end++) {
					//若从起始到终点借助中介节点更近 则更新
					int mediumLen=edges[start][medium]+edges[medium][end];
					if(edges[start][end]>mediumLen) {
						edges[start][end]=mediumLen;
						pre[start][end]=pre[medium][end];
					}
				}
			}
			
		}
	}

}