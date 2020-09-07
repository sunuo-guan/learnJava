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

		// ��ֵ
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

	// �ߵ�Ȩֵ����
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

	// ���ض����Ӧ���±�
	public int getPosition(char point) {
		for (int i = 0; i < vertexsNum; i++) {
			if (vertex[i] == point) {
				return i;
			}
		}
		return -1;
	}

	// ��ͼ�еı߶��ŵ�������
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
	 * ��ȡ��ǰ�±궥����յ���±꣬��û����ͨ���յ���Ϊ�Լ�����
	 * 
	 * @param end
	 * @param i
	 * @return
	 */
	public int getEnd(int end[], int i) {
		while (end[i] != 0) {    //!!while�����˴�ĳһ��һֱ��ֱ���ҵ��յ㣬�������յ�endΪ�������
			i= end[i];
		} 
		return i;
	}

	// ��ӡ������
	public void showEdges(Edges allEdges[]) {
		for (int i = 0; i < edgesNum; i++) {
			System.out.println(allEdges[i]);
		}
	}

	// ��С������
	public Edges[] kruskal() {
		int[] end = new int[vertexsNum];

		Edges[] allEdges = getAllEdges();
		Edges[] minTree = new Edges[vertexsNum-1];
		int index = 0;
		sortEdges(allEdges);

		// ����ȡ��С�� �������ɻ�·��ӽ��� �����ɻ�·�򲻼�
		for (int i = 0; i < allEdges.length; i++) {
			// ��ȡһ���ߵ�ʼ�յ��±�(endIndex�϶���startIndex��)
			int startIndex = getPosition(allEdges[i].start);
			int endIndex = getPosition(allEdges[i].end);

			// ����Ѵ˱߽�����С������
			// �����������ɻ�·
			int p1 = getEnd(end, startIndex);
			int p2 = getEnd(end, endIndex);
			if (p1 != p2) {
				// �������ɻ�·
				end[p1] = p2;    //����������������ͨʱ���յ�ʱ��������֮�е�һ�����յ㣬		
				minTree[index] = allEdges[i];
				index++;
			}
		}
		return minTree;
	}
}

//����
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