package com.algorithm.dynamic;

public class KnapsackDemo {
	public static void main(String[] args) {
		int[] weight= {1,4,3};    //货物分别重量
		int[] value= {1500,3000,2000};    //货物分别的价值
		int numOfGoods=weight.length;   //货物种类数量
		
		int capacity=4;        //背包容量
		
		int[][] v=new int[numOfGoods+1][capacity+1];   //表格  行为放入的某个货物 列为重量
		
		int[][] path=new int[numOfGoods+1][capacity+1];
		
		//初始化
		for (int i = 0; i < v.length; i++) {
			v[i][0]=0;
		}
		
		//初始化
		for (int i = 0; i < v[0].length; i++) {
			v[0][i]=0;
		}
		
		for (int i = 1; i < v.length; i++) {
			for (int j = 1; j < v[0].length; j++) {
				//如果待放入货物大于当前的背包磅数
				if(weight[i-1]>j) {
					//则将上一次的方案移至此中方案
					v[i][j]=v[i-1][j];
				}else {
					//如果待放入货物小于等于当前的背包磅数
					//则比较（放入当前货物和剩下容量装入对应的最佳方案之和）与（上一个方案大小比较）
					//取最大值
					if(v[i-1][j]>value[i-1]+v[i-1][j-weight[i-1]]) {
						v[i][j]=v[i-1][j];
					}else {
						v[i][j]=value[i-1]+v[i-1][j-weight[i-1]];
						path[i][j]=1;
					}
				}
			}
		}
		
		//输出表格
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[0].length; j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("*******");
		
		int i=path.length-1;
		int j=path[0].length-1;
		while(i>0&&j>0) {
			if(path[i][j]==1) {
				System.out.println("第"+i+"个货物被装入");
				j=j-weight[i-1];
			}
			i--;
		}
	}
}
