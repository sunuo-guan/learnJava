package com.datastructrue.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSortDemo {
	public static void main(String[] args) {
		int array[] = { 4, -3, 7, 3, -1, 8, -5, 2, 1 };

		System.out.println("����ǰ��" + Arrays.toString(array));
		shellSortImprove(array);
		System.out.println("�����" + Arrays.toString(array));

		// ����ʱ��
		int length = 100000;
		int arr[] = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = (int) (Math.random() * length);
		}

		Date date1 = new Date();
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDataFormat.format(date1);
		System.out.println("����ǰʱ��" + date1Str);

		shellSortImprove(arr);
		//shellSort(arr);
		Date date2 = new Date();
		String date2Str = simpleDataFormat.format(date2);
		System.out.println("�����ʱ��" + date2Str);
	}

	// ����ʽ
	public static void shellSort(int arr[]) {
		int temp = 0;
		int count = 0;
		for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
			// ѡ������ ����һ�η��������
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j = j - gap) {
					// ��ѡ��Ԫ�����������Ԫ�رȽϺͽ��� �����ʼ��Ϊi-gap
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}

			//System.out.println((++count) + "��������Ϊ" + Arrays.toString(arr));
		}
	}

	// ��������ʱ ʹ��ֱ�Ӳ�������
	public static void shellSortImprove(int[] arr) {
		// ����
		int count = 0;
		int index = 0;
		int value = 0;
		for (int gap = arr.length / 2; gap > 0; gap = gap / 2) { // ѡ������ ����һ�η��������

			for (int i = gap; i < arr.length; i++) { // ÿ�����鶼Ҫ�������� �����Ҫi++,��Ҫ����������ĩβ
				index = i - gap; // �������Ԫ�ص�ǰһ��Ԫ��
				value = arr[i]; // �������ֵ
				while (index >= 0 && arr[index] > value) {
					arr[index + gap] = arr[index];
					index = index - gap;
				}
				arr[index + gap] = value;
			}
			//System.out.println((++count) + "��������Ϊ" + Arrays.toString(arr));
		}
	}
}
