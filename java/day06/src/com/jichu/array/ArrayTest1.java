package com.jichu.array;

/**
 * ��ά����
 * 
 * @author Administrator
 *
 */
public class ArrayTest1 {
	public static void main(String[] args) {
		// ��̬��ʼ���������ʼ���͸�ֵͬʱ����
		int[][] ids = new int[][] { { 1001, 1002 }, { 3, 4,4,4,3 }, { 5, 6 } };
		// ��̬��ʼ��1
		int[][] ids2 = new int[2][3];
		// ��̬��ʼ��2
		String[][] ids3 = new String[2][];
		
		//System.out.println(ids3[0][1]);  ����
		ids3[0]=new String[3];
		System.out.println(ids3[0][1]);
		
		//��ȡ����
		System.out.println(ids.length);
		System.out.println(ids[0].length);
		System.out.println(ids[1].length);
		
		//����
		for(int i=0;i<ids.length;i++) {
			for(int j =0;j<ids[i].length;j++) {
				System.out.println(ids[i][j]+" ");
			}
		}
		
		//Ĭ��ֵ
		int[][] arr = new int[3][4];
		System.out.println(arr[0]); //��� ����ַ
		System.out.println(arr[0][2]); //�ڲ�
		System.out.println(arr); //��ά���飬��ַ
		
		int[][] arr1 = new int[3][];
		System.out.println(arr1[0]); //��� ���������� null
		System.out.println(arr1[0][2]); //���� ��ָ��
	}
}
