package com.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphDemo {
	public static void main(String[] args) {
		int n=5;
		Graph graph=new Graph(n);
		String[] vertex= {"a","b","c","d","e"};
		for (int i = 0; i < vertex.length; i++) {
			graph.addVertex(vertex[i]);
		}
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 1);
		graph.addEdge(1, 4, 1);

		graph.showGraph();
		System.out.println("*******");
		graph.dfs();
		System.out.println();
		System.out.println("*******");
		graph.bfs();
		
		
	}
}

class Graph {
	private ArrayList<String> vertex;
	private int[][] edges;
	private int numOfEdges;
	private int numOfVertex;

	public Graph(int n) {
		vertex=new ArrayList<String>(n);
		edges=new int[n][n];
		numOfEdges=0;
		numOfVertex=0;
	}

	//��ʾͼ
	public void showGraph() {
		for(int i=0;i<edges.length;i++) {
			for (int j = 0; j < edges.length; j++) {
				System.out.print(edges[i][j]+", ");
			}
			System.out.println();
		}
	}
	
	
	// ��ӽڵ�ֵ
	public void addVertex(String value) {
		vertex.add(value);
		numOfVertex++;
	}
	
	//���ر���
	public int getNumOfEdges() {
		return numOfEdges;
	}

	//���ؽڵ���
	public int getNumOfVertex() {
		return numOfVertex;
	}

	//�����±��Ӧ�Ľڵ�ֵ
	public String getValueOfVertex(int i) {
		return vertex.get(i);
	}
	
	//����v1 v2Ȩֵ
	public int getWeightOfEdges(int v1,int v2) {
		return edges[v1][v2];
	}

	//��ӱ�
	/**
	 * 
	 * @param v1   ��һ���ڵ��±�
	 * @param v2 �ڶ����ڵ��±�
	 * @param weight �ߵ�Ȩֵ
	 */
	public void addEdge(int v1,int v2,int weight) {
		edges[v1][v2]=weight;
		edges[v2][v1]=weight;
		numOfEdges++;
	}
	
	//���ݴ�ʱ�ڵ��±��ȡ��һ���ڽӽڵ���±�
	public int getFirtstNeighbor(int v1) {
		for (int i = 0; i < edges.length; i++) {    //?
			if(edges[v1][i]==1) {  
				return i;
			}
		}
		return -1;
	}
	
	//���ݴ�ʱ�ڵ��±�͵�һ���ڽӽڵ���±�����ȡ�ڶ����ڽӽڵ��±�
	public int getSecondNeighbor(int v1,int v2) {
		for (int i = v2+1; i < edges.length; i++) {
			if(edges[v1][i]==1) {
				return i;
			}
		}
		return -1;
	}
	
	//��ȱ�������
	private void dfs(boolean isVisited[], int index) {
		System.out.print(vertex.get(index)+" ");
		isVisited[index]=true;
		//���ڽӽڵ�
		int neighbor=getFirtstNeighbor(index);
		while(neighbor!=-1) {   //�����ڽӣ�����Ƿ���ʹ�������� ��������ֱ�ӷ���
			if(isVisited[neighbor]==false) {   //δ���ʹ�����������������ȷ���
				dfs(isVisited,neighbor);
			}else {                          //�����ʹ����򿴵ڶ����ڽӽڵ�
				neighbor=getSecondNeighbor(index, neighbor);
			}
			
		}
	}
	
	//����ӿڣ�ѭ��ͼ������Ԫ�ؽ�����ȱ��������ܴ��ڷ���ͨͼ�����
	public void dfs() {
		boolean isVisited[]=new boolean[vertex.size()];
		for (int i = 0; i < getNumOfVertex(); i++) {
			if(isVisited[i]==false) {
				dfs(isVisited,i);
			}		
		}
		
	}
	
	//�������
	/**
	 * �õ�����
	 * ������һ���� �������������
	 * ��ǰ���޷������� ������� ������һ�����еı���
	 * @param isVisited
	 * @param index
	 */
	private void bfs(boolean[] isVisited,int index) {
		int queueHead;
		int neighbor;
		LinkedList<Integer> queue=new LinkedList<Integer>();
		//��ʼ�㴦��
		System.out.print(getValueOfVertex(index)+" ");
		isVisited[index]=true;
		queue.addLast(index);
		
		while(queue.isEmpty()!=true) {
			queueHead=(Integer)queue.removeFirst();            //���е�һ������
			neighbor=getFirtstNeighbor(queueHead);
			while(neighbor!=-1) {
				if(isVisited[neighbor]==false) {          //û�з��ʹ� �����
					System.out.print(getValueOfVertex(neighbor)+" ");
					isVisited[neighbor]=true;               //�����ʱ�� ���������ѭ��
					queue.addLast(neighbor);
				}else {          //���ʹ� ���Ҷ���ͷ�ڵ�ĵ�ǰ�ڽӽڵ����һ���ڽӽڵ�����ж�
					neighbor=getSecondNeighbor(queueHead, neighbor);
				}
			}
			
		}
		
	}
	
	public void bfs() {
		boolean isVisited[]=new boolean[vertex.size()];
		for (int i = 0; i < getNumOfVertex(); i++) {
			if(isVisited[i]==false) {
				bfs(isVisited,i);
			}
		}
	}
}