package com.algorithm.dijkstra;

/**
 * 迪杰斯特拉：分别求出从一个顶点出发到各个点的最小路径
 * @author Administrator
 *
 */
public class DijkstraDemo {
	private static final int maxValue=10000;
	public static void main(String[] args) {
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
		int index=6;
		graph.dij(index);
	
		
	}
}

class VisitedVertex{
	//对应是否被访问过
	public boolean[] visited;
	//记录出发顶点到其他所有顶点的距离
	public int[] distance;
	//记录每个下标顶点的前一个顶点的下标
	public int[] prePoint;
	
	private static final int maxValue=10000;
	
	//初始化
	public VisitedVertex(int length,int index) {
		visited=new boolean[length];
		prePoint=new int[length];
		distance=new int[length];
		//visited[index]=true;
		for (int i = 0; i < length; i++) {
			distance[i]=maxValue;
		}
		distance[index]=0;    //出发顶点的距离为0
	}
	
	//是否被访问
	public boolean isVisited(int index) {
		return visited[index];
	}
	
	//设置最小距离
	public void setDistance(int dis,int index) {
		distance[index]=dis;
	}
	
	//将pre节点的前驱节点设置为index
	public void setPrepoint(int pre,int index) {
		prePoint[pre]=index;
	}
	
	//返回距离
	public int getDistance(int index) {
		return distance[index];
	}
	
	//选定当前distance里最小的，用作下一次顶点判断
	public int nextPoint() {
		int min=maxValue;
		int index=-1;
		for (int i = 0; i < distance.length; i++) {
			if(visited[i]==false&&distance[i]<min) {
				min=distance[i];
				index=i;
			}
		}
		return index;
		
	}
	
	public void showAll() {
		for (int i = 0; i < distance.length; i++) {
			System.out.print(visited[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < distance.length; i++) {
			System.out.print(distance[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < distance.length; i++) {
			System.out.print(prePoint[i]+" ");
		}
		System.out.println();
	}
	
	
}

class Graph {
	private int vertexsNum;
	private char[] vertex;
	private int[][] edges;
	private VisitedVertex vv;

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
			}
		}
		

	}

	public void showGraph() {
		for (int i = 0; i < vertexsNum; i++) {
			for (int j = 0; j < vertexsNum; j++) {
				System.out.print(edges[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//给定起始节点，找起始节到其余节点的最短路径
	public void dij(int index) {
		vv=new VisitedVertex(vertex.length, index);
		update(index);   //第一个点的update
		int first=index;
		for (int i = 1; i < vertexsNum; i++) {			
			index=vv.nextPoint();
			update(index);
		}
		vv.showAll();
		for (int i = 0; i < edges.length; i++) {
			getRoad(i,first);
			System.out.println();
		}
	}
	
	//选定当前节点后，更新vv中的三个数组 vv数组指的是此节点到下一批节点的路径数据
	public void update(int index) {
		
		for (int i = 0; i < vertexsNum; i++) {
			if(vv.isVisited(i)==false&&vv.getDistance(index)+edges[index][i]<vv.getDistance(i)) {
				int newLen=vv.getDistance(index)+edges[index][i];
				vv.setDistance(newLen, i);
				vv.setPrepoint(i, index);
			}
		}
		vv.visited[index]=true;
		
	}
	
	//输出出发节点到指定节点的最短路径
	public void getRoad(int endPoint,int index) {
		char road[]=new char[vertexsNum];
		int i=endPoint;
		int j=0;
		road[j]=vertex[i];
		while(i!=index) {
			i=vv.prePoint[i];
			j++;
			road[j]=vertex[i];
		}
		for (int k = j; k >= 0; k--) {
			System.out.print(road[k]+"->");
		}
	}
}