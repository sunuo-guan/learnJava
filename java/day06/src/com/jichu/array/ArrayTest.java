package com.jichu.array;
/**
 * 一维数组
 * @author Administrator
 *
 */
public class ArrayTest {
	public static void main(String[] args) {
		
		//1、一维数组的初始化和声明
		
		int[] ids;   //声明
		//静态初始化：数组初始化和赋值同时进行
		ids = new int[] {1001,1002};
		
		//动态初始化：数组初始化和赋值分开进行 	
		String[] name = new String[5];
		
		//2、调用数组指定位置元素：角标调用
		name[0]="hh";
		name[1]="ggg";
		name[2]="hh";
		name[3]="ggg";
		name[4]="gggg";
		
		//3、获取数组长度 属性：length
		System.out.println(name.length);
		System.out.println(ids.length);
		
		//4、遍历数组元素
		for(int i=0;i<name.length;i++) {
			System.out.println(name[i]);
		}
		
		//5、默认初始化值
		int[] arry = new int[5];
		for(int i=0;i<arry.length;i++) {
			System.out.println(arry[i]);   //整型都为0
		}
		
		System.out.println("*******");
		double[] arry1 = new double[5];
		for(int i=0;i<arry1.length;i++) {
			System.out.println(arry1[i]);   //浮点型都为0
		}
		
		System.out.println("*******");
		char[] arry2 = new char[5];
		for(int i=0;i<arry2.length;i++) {
			System.out.println(arry2[i]);   //char都为0或'\u0000',而非'0'
		}
		if(arry2[0]==0) {
			System.out.println("true");
		}
		
		System.out.println("*******");
		boolean[] arry3 = new boolean[4];  //布尔型为false
		System.out.println(arry3[0]);
		
		System.out.println("*******");
		String[]  arry4 = new String[4];   //引用数据类型：null
		if(arry4[0]==null) {
			System.out.println("true");
		}
		if(arry4[0]=="null") {
			System.out.println("false");
		}
		
	}
}
