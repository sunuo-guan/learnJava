package com.algorithm.dac;

public class HanoiTowerDemo {
	public static int count;
	
	public static void main(String[] args) {
		int num=10;
		hanoiTower(num, "a", "b", "c");
		System.out.println("�ƶ�������"+count);
	}
	
	/**
	 * 
	 * @param num  �ƶ�num����
	 * @param a �����
	 * @param b ������
	 * @param c �յ���
	 */
	public static void hanoiTower(int num, String a,String b, String c) {
		if(num==1) {
			System.out.println("��1���̴�"+a+"->"+c);
			count++;
		}else {
			//�������ϵ������̽���c�ƶ���b
			hanoiTower(num-1,a,c,b);
			//�������ƶ���c
			System.out.println("��"+num+"���̴�"+a+"->"+c);
			count++;
			//����b�������̽���a�ƶ���c
			hanoiTower(num-1,b,a,c);
		}
	}
}
