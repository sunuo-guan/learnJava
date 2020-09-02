package com.datastructrue.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSortDemo {
	public static void main(String[] args) {
		int array[] = { 4, -3, -1, 3, 7 };

		System.out.println("����ǰ��");
		System.out.println(Arrays.toString(array));

		BubbleSortImprove(array);

		System.out.println("�����");
		System.out.println(Arrays.toString(array));
		
		//����ʱ��
		int length=100000;
		int arr[]=new int[length];
		for(int i=0;i<length;i++) {
			arr[i]=(int)(Math.random()*length);
		}
		
		Date date1=new Date();
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str=simpleDataFormat.format(date1);
		System.out.println("����ǰʱ��"+date1Str);
		
		BubbleSortImprove(arr);
		Date date2=new Date();
		String date2Str=simpleDataFormat.format(date2);
		System.out.println("����ǰʱ��"+date2Str);
		

	}

	public static void BubbleSort(int[] array) {

		int temp;

		for (int i = 0; i < array.length - 1; i++) {   //i���� jԪ����

			// for(int j=0;j<array.length-1;j++) { //һֱ�� ���ܵ�������һ���źõ�����
			for (int j = 0; j < array.length - 1 - i; j++) { // ��������һ���źõ�����֮����ֹͣ ������һ��ѭ��
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}

			System.out.println("��" + (i + 1) + "��������Ϊ��");
			System.out.println(Arrays.toString(array));
		}
	}

	public static void BubbleSortImprove(int[] array) {

		int temp;
		boolean flag = false; // ��һ������û�н��� ��ֱ���˳�

		for (int i = 0; i < array.length - 1; i++) {

			// for(int j=0;j<array.length-1;j++) { //һֱ�� ���ܵ�������һ���źõ�����
			for (int j = 0; j < array.length - 1 - i; j++) { // ��������һ���źõ�����֮����ֹͣ ������һ��ѭ��
				if (array[j] > array[j + 1]) {
					flag = true;
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			
			//System.out.println("��" + (i + 1) + "��������Ϊ��");
			//System.out.println(Arrays.toString(array));
			
			if (!flag) {
				break;
			} else {
				flag = false;
			}


		}
	}
}
