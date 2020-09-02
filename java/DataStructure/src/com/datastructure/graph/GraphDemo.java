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

	//显示图
	public void showGraph() {
		for(int i=0;i<edges.length;i++) {
			for (int j = 0; j < edges.length; j++) {
				System.out.print(edges[i][j]+", ");
			}
			System.out.println();
		}
	}
	
	
	// 添加节点值
	public void addVertex(String value) {
		vertex.add(value);
		numOfVertex++;
	}
	
	//返回边数
	public int getNumOfEdges() {
		return numOfEdges;
	}

	//返回节点数
	public int getNumOfVertex() {
		return numOfVertex;
	}

	//返回下标对应的节点值
	public String getValueOfVertex(int i) {
		return vertex.get(i);
	}
	
	//返回v1 v2权值
	public int getWeightOfEdges(int v1,int v2) {
		return edges[v1][v2];
	}

	//添加边
	/**
	 * 
	 * @param v1   第一个节点下标
	 * @param v2 第二个节点下标
	 * @param weight 边的权值
	 */
	public void addEdge(int v1,int v2,int weight) {
		edges[v1][v2]=weight;
		edges[v2][v1]=weight;
		numOfEdges++;
	}
	
	//根据此时节点下标获取第一个邻接节点的下标
	public int getFirtstNeighbor(int v1) {
		for (int i = 0; i < edges.length; i++) {    //?
			if(edges[v1][i]==1) {  
				return i;
			}
		}
		return -1;
	}
	
	//根据此时节点下标和第一个邻接节点的下标来获取第二个邻接节点下标
	public int getSecondNeighbor(int v1,int v2) {
		for (int i = v2+1; i < edges.length; i++) {
			if(edges[v1][i]==1) {
				return i;
			}
		}
		return -1;
	}
	
	//深度遍历优先
	private void dfs(boolean isVisited[], int index) {
		System.out.print(vertex.get(index)+" ");
		isVisited[index]=true;
		//找邻接节点
		int neighbor=getFirtstNeighbor(index);
		while(neighbor!=-1) {   //存在邻接，则分是否访问过两种情况 不存在则直接返回
			if(isVisited[neighbor]==false) {   //未访问过，则对其进行深度优先访问
				dfs(isVisited,neighbor);
			}else {                          //被访问过，则看第二个邻接节点
				neighbor=getSecondNeighbor(index, neighbor);
			}
			
		}
	}
	
	//对外接口：循环图中所有元素进行深度遍历，可能存在非连通图的情况
	public void dfs() {
		boolean isVisited[]=new boolean[vertex.size()];
		for (int i = 0; i < getNumOfVertex(); i++) {
			if(isVisited[i]==false) {
				dfs(isVisited,i);
			}		
		}
		
	}
	
	//广度优先
	/**
	 * 用到队列
	 * 遍历到一个点 则输出并进队列
	 * 当前点无法遍历后 则出队列 并找下一个队列的遍历
	 * @param isVisited
	 * @param index
	 */
	private void bfs(boolean[] isVisited,int index) {
		int queueHead;
		int neighbor;
		LinkedList<Integer> queue=new LinkedList<Integer>();
		//起始点处理
		System.out.print(getValueOfVertex(index)+" ");
		isVisited[index]=true;
		queue.addLast(index);
		
		while(queue.isEmpty()!=true) {
			queueHead=(Integer)queue.removeFirst();            //队列第一个出列
			neighbor=getFirtstNeighbor(queueHead);
			while(neighbor!=-1) {
				if(isVisited[neighbor]==false) {          //没有访问过 则访问
					System.out.print(getValueOfVertex(neighbor)+" ");
					isVisited[neighbor]=true;               //！访问标记 否则进入死循环
					queue.addLast(neighbor);
				}else {          //访问过 则找队列头节点的当前邻接节点的下一个邻接节点进行判断
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