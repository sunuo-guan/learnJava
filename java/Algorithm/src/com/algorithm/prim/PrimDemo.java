package com.algorithm.prim;

public class PrimDemo {
	private static int maxValue=10000;
	
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
		char[] data= {'a','b','c','d','e','f','g'};
		MGraph graph=new MGraph(data.length);
		Mintree tree=new Mintree();
		tree.createMGraph(graph, data, edge);
		tree.prim(graph, 1);
	}
}

class Mintree{
	private static int maxValue=10000;
	
	//����
	public void createMGraph(MGraph graph,char[] data,int[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			graph.data[i]=data[i];
			for (int j = 0; j < edges.length; j++) {
				graph.edges[i][j]=edges[i][j];
			}
		}
	}
	
	//��ʾ
	public void show(MGraph graph) {
		for (int i = 0; i < graph.vertexs; i++) {
			for (int j = 0; j < graph.vertexs; j++) {
				System.out.print(graph.edges[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//��С������
	/**
	 * index��ʾ���ĸ����㿪ʼ
	 */
	public void prim(MGraph graph,int index) {
		int row=0,column=0; //�±�
		int size=graph.data.length;
		//�ж��Ƿ񱻷��ʹ�
		boolean visited[]=new boolean[size];   
		//������С��·����Ȩֵ
		int minWeight=maxValue;
		//�ȷ��ʳ�ʼ��
		visited[index]=true;
		
		for(int k=0;k<size-1;k++) {     //k��ʾҪ���ɵıߵ���������size-1
			
			for (int i = 0; i < size; i++) {   //ͨ��if�Ŀ��ƣ�i��ʾ�Ѿ����ʵĽڵ�
				for (int j = 0; j < size; j++) {   //j��ʾ��δ���ʵĽڵ�
					if(visited[i]==true&&visited[j]==false&&graph.edges[i][j]<minWeight) {
						//���������ѷ��ʽڵ�������ڽ�δ���ʽڵ㣬�ҵ�Ȩֵ��С���Ǹ�
						row=i;
						column=j;
						minWeight=graph.edges[i][j];
					}
				}
			}
			visited[column]=true;
			System.out.println("��"+(k+1)+"����Ϊ��<"+graph.data[row]+","+graph.data[column]+"> ȨΪ��"+graph.edges[row][column]);
			minWeight=maxValue;    //�������ָ����ֵ
		}
		
		
	}
}

class MGraph{
	int vertexs;    //�������
	char[] data;    //��������
	int[][] edges;   //�ڽӾ���
	
	public MGraph(int vertexs) {
		this.vertexs=vertexs;
		data=new char[vertexs];
		edges=new int[vertexs][vertexs];
	}
	
	
}