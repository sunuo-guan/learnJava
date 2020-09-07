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
	
	//创建
	public void createMGraph(MGraph graph,char[] data,int[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			graph.data[i]=data[i];
			for (int j = 0; j < edges.length; j++) {
				graph.edges[i][j]=edges[i][j];
			}
		}
	}
	
	//显示
	public void show(MGraph graph) {
		for (int i = 0; i < graph.vertexs; i++) {
			for (int j = 0; j < graph.vertexs; j++) {
				System.out.print(graph.edges[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//最小生成树
	/**
	 * index表示从哪个顶点开始
	 */
	public void prim(MGraph graph,int index) {
		int row=0,column=0; //下标
		int size=graph.data.length;
		//判断是否被访问过
		boolean visited[]=new boolean[size];   
		//保存最小的路径的权值
		int minWeight=maxValue;
		//先访问初始点
		visited[index]=true;
		
		for(int k=0;k<size-1;k++) {     //k表示要生成的边的数量，即size-1
			
			for (int i = 0; i < size; i++) {   //通过if的控制，i表示已经访问的节点
				for (int j = 0; j < size; j++) {   //j表示仍未访问的节点
					if(visited[i]==true&&visited[j]==false&&graph.edges[i][j]<minWeight) {
						//遍历所有已访问节点的所有邻接未访问节点，找到权值最小的那个
						row=i;
						column=j;
						minWeight=graph.edges[i][j];
					}
				}
			}
			visited[column]=true;
			System.out.println("第"+(k+1)+"条边为：<"+graph.data[row]+","+graph.data[column]+"> 权为："+graph.edges[row][column]);
			minWeight=maxValue;    //！！！恢复最大值
		}
		
		
	}
}

class MGraph{
	int vertexs;    //顶点个数
	char[] data;    //顶点名字
	int[][] edges;   //邻接矩阵
	
	public MGraph(int vertexs) {
		this.vertexs=vertexs;
		data=new char[vertexs];
		edges=new int[vertexs][vertexs];
	}
	
	
}