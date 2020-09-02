package com.algorithm.dac;

public class HanoiTowerDemo {
	public static int count;
	
	public static void main(String[] args) {
		int num=10;
		hanoiTower(num, "a", "b", "c");
		System.out.println("移动次数："+count);
	}
	
	/**
	 * 
	 * @param num  移动num个盘
	 * @param a 起点柱
	 * @param b 辅助柱
	 * @param c 终点柱
	 */
	public static void hanoiTower(int num, String a,String b, String c) {
		if(num==1) {
			System.out.println("第1个盘从"+a+"->"+c);
			count++;
		}else {
			//将底盘上的所有盘借助c移动到b
			hanoiTower(num-1,a,c,b);
			//将底盘移动到c
			System.out.println("第"+num+"个盘从"+a+"->"+c);
			count++;
			//将在b的所有盘借助a移动到c
			hanoiTower(num-1,b,a,c);
		}
	}
}
