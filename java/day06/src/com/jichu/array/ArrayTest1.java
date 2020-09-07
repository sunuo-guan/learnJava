package com.jichu.array;

/**
 * 二维数组
 * 
 * @author Administrator
 *
 */
public class ArrayTest1 {
	public static void main(String[] args) {
		// 静态初始化：数组初始化和赋值同时进行
		int[][] ids = new int[][] { { 1001, 1002 }, { 3, 4,4,4,3 }, { 5, 6 } };
		// 动态初始化1
		int[][] ids2 = new int[2][3];
		// 动态初始化2
		String[][] ids3 = new String[2][];
		
		//System.out.println(ids3[0][1]);  报错
		ids3[0]=new String[3];
		System.out.println(ids3[0][1]);
		
		//获取长度
		System.out.println(ids.length);
		System.out.println(ids[0].length);
		System.out.println(ids[1].length);
		
		//遍历
		for(int i=0;i<ids.length;i++) {
			for(int j =0;j<ids[i].length;j++) {
				System.out.println(ids[i][j]+" ");
			}
		}
		
		//默认值
		int[][] arr = new int[3][4];
		System.out.println(arr[0]); //外层 ：地址
		System.out.println(arr[0][2]); //内层
		System.out.println(arr); //二维数组，地址
		
		int[][] arr1 = new int[3][];
		System.out.println(arr1[0]); //外层 ：引用类型 null
		System.out.println(arr1[0][2]); //报错 空指针
	}
}
