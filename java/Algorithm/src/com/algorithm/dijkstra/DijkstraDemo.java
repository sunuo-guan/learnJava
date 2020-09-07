package com.algorithm.dijkstra;

/**
 * �Ͻ�˹�������ֱ������һ��������������������С·��
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
	//��Ӧ�Ƿ񱻷��ʹ�
	public boolean[] visited;
	//��¼�������㵽�������ж���ľ���
	public int[] distance;
	//��¼ÿ���±궥���ǰһ��������±�
	public int[] prePoint;
	
	private static final int maxValue=10000;
	
	//��ʼ��
	public VisitedVertex(int length,int index) {
		visited=new boolean[length];
		prePoint=new int[length];
		distance=new int[length];
		//visited[index]=true;
		for (int i = 0; i < length; i++) {
			distance[i]=maxValue;
		}
		distance[index]=0;    //��������ľ���Ϊ0
	}
	
	//�Ƿ񱻷���
	public boolean isVisited(int index) {
		return visited[index];
	}
	
	//������С����
	public void setDistance(int dis,int index) {
		distance[index]=dis;
	}
	
	//��pre�ڵ��ǰ���ڵ�����Ϊindex
	public void setPrepoint(int pre,int index) {
		prePoint[pre]=index;
	}
	
	//���ؾ���
	public int getDistance(int index) {
		return distance[index];
	}
	
	//ѡ����ǰdistance����С�ģ�������һ�ζ����ж�
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
	
		// ��ֵ
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
	
	//������ʼ�ڵ㣬����ʼ�ڵ�����ڵ�����·��
	public void dij(int index) {
		vv=new VisitedVertex(vertex.length, index);
		update(index);   //��һ�����update
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
	
	//ѡ����ǰ�ڵ�󣬸���vv�е��������� vv����ָ���Ǵ˽ڵ㵽��һ���ڵ��·������
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
	
	//��������ڵ㵽ָ���ڵ�����·��
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