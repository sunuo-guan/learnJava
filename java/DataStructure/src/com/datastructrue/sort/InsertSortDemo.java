package com.datastructrue.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSortDemo {
	public static void main(String[] args) {
		int array[] = { 4, -3, 7, 3, -1 };

		System.out.println("����ǰ��" + Arrays.toString(array));
		InsertSort(array);
		System.out.println("�����" + Arrays.toString(array));
		
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
		
		InsertSort(arr);
		Date date2=new Date();
		String date2Str=simpleDataFormat.format(date2);
		System.out.println("�����ʱ��"+date2Str);
	}

	public static void InsertSort(int[] arr) {
		// ͬ������ ��Ϊ�������� ������ĵ�һ��Ԫ�ز��뵽���������
		int index = 0;          //�������ǰ���±� �Ӵ�λ��һֱ��ǰ����
		int insertValue = 0;
		for (int i = 1; i < arr.length; i++) {
			index = i-1; // �������ǰ���±�
			insertValue = arr[i]; // �������ֵ
			while(index>=0&&insertValue<arr[index]) {
				arr[index+1]=arr[index];
				index--;
			}
			arr[index+1]=insertValue;
			//System.out.println("��" + i + "��������Ϊ��" + Arrays.toString(arr));

		}
	}
}
