package com.algorithm.kruskal;

import java.util.Arrays;

public class KruskalDemo {

	private static final int maxValue = 10000;

	public static void main(String[] args) {
//		int edge[][] = { 
//				{ 0, 12, maxValue, maxValue, maxValue, 16, 14 }, 
//				{ 12, 0, 10, maxValue, maxValue, 7, maxValue },
//				{ maxValue, 10, 0, 3, 5, 6, maxValue },
//				{ maxValue, maxValue, 3, 0, 4, maxValue, maxValue }, 
//				{ maxValue, maxValue, 5, 4, 0, 2, 8 },
//				{ 16, 7, 6, maxValue, 2, 0, 9 }, 
//				{ 14, maxValue, maxValue, maxValue, 8, 9, 0 } };
		int edge[][] = {
				{maxValue,5,7,maxValue,maxValue,maxValue,2},
				{5,maxValue,maxValue,9,maxValue,maxValue,3},
				{7,maxValue,maxValue,maxValue,8,maxValue,maxValue},
				{maxValue,9,maxValue,maxValue,maxValue,4,maxValue},
				{maxValue,maxValue,8,maxValue,maxValue,5,4},
				{maxValue,maxValue,maxValue,4,5,maxValue,6},
				{2,3,maxValue,maxValue,4,6,maxValue}
		};
		char[] data = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		Graph graph = new Graph(data, edge);
		graph.showGraph();
		Edges[] minTree = graph.getAllEdges();
		minTree = graph.kruskal();
		for (int i = 0; i < minTree.length; i++) {
			System.out.println(minTree[i]);
		}

	}
}

class Graph {
	private int edgesNum;
	private int vertexsNum;
	private char[] vertex;
	private int[][] edges;
	private static final int maxValue = 10000;

	public Graph(char[] vertex, int[][] edges) {
		vertexsNum = vertex.length;
		this.vertex = new char[vertexsNum];
		this.edges = new int[vertexsNum][vertexsNum];

		// 赋值
		for (int i = 0; i < vertexsNum; i++) {
			this.vertex[i] = vertex[i];
		}

		for (int i = 0; i < vertexsNum; i++) {
			for (int j = 0; j < vertexsNum; j++) {
				this.edges[i][j] = edges[i][j];
				if (edges[i][j] != 0 && edges[i][j] != maxValue) {
					edgesNum++;
				}
			}
		}
		edgesNum = edgesNum / 2;

	}

	public void showGraph() {
		for (int i = 0; i < vertexsNum; i++) {
			for (int j = 0; j < vertexsNum; j++) {
				System.out.print(edges[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 边的权值排序
	public void sortEdges(Edges[] allEdges) {
		for (int i = 0; i < allEdges.length - 1; i++) {
			for (int j = 0; j < allEdges.length - 1 - i; j++) {
				if (allEdges[j + 1].weight < allEdges[j].weight) {
					Edges temp = allEdges[j];
					allEdges[j] = allEdges[j + 1];
					allEdges[j + 1] = temp;
				}
			}
		}
	}

	// 返回顶点对应的下标
	public int getPosition(char point) {
		for (int i = 0; i < vertexsNum; i++) {
			if (vertex[i] == point) {
				return i;
			}
		}
		return -1;
	}

	// 将图中的边都放到边数组
	public Edges[] getAllEdges() {
		Edges[] allEdges = new Edges[edgesNum];
		int index = 0;
		for (int i = 0; i < vertexsNum; i++) {
			for (int j = i + 1; j < vertexsNum; j++) {
				if (edges[i][j] != maxValue) {
					allEdges[index] = new Edges(vertex[i], vertex[j], edges[i][j]);
					index++;
				}
			}
		}
		return allEdges;

	}

	/**
	 * 获取当前下标顶点的终点的下标，若没有连通，终点则为自己！！
	 * 
	 * @param end
	 * @param i
	 * @return
	 */
	public int getEnd(int end[], int i) {
		while (end[i] != 0) {    //!!while控制了从某一点一直找直到找到终点，利用了终点end为零的特性
			i= end[i];
		} 
		return i;
	}

	// 打印边数组
	public void showEdges(Edges allEdges[]) {
		for (int i = 0; i < edgesNum; i++) {
			System.out.println(allEdges[i]);
		}
	}

	// 最小生成树
	public Edges[] kruskal() {
		int[] end = new int[vertexsNum];

		Edges[] allEdges = getAllEdges();
		Edges[] minTree = new Edges[vertexsNum-1];
		int index = 0;
		sortEdges(allEdges);

		// 不断取最小边 若不构成回路则加进树 若构成回路则不加
		for (int i = 0; i < allEdges.length; i++) {
			// 获取一条边的始终点下标(endIndex肯定比startIndex大)
			int startIndex = getPosition(allEdges[i].start);
			int endIndex = getPosition(allEdges[i].end);

			// 假设把此边接入最小生成树
			// 看看构不构成回路
			int p1 = getEnd(end, startIndex);
			int p2 = getEnd(end, endIndex);
			if (p1 != p2) {
				// 若不构成回路
				end[p1] = p2;    //！！！两个子树连通时，终点时两个子树之中的一个的终点，		
				minTree[index] = allEdges[i];
				index++;
			}
		}
		return minTree;
	}
}

//边类
class Edges {
	public char start;
	public char end;
	public int weight;

	public Edges(char start, char end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edges [start=" + start + ", end=" + end + ", weight=" + weight + "]";
	}

}