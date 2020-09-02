package com.datastructrue.sort;

import java.util.Arrays;

public class RadixSortDemo {
	public static void main(String[] args) {
		int array[] = { 409, 323, 37, 3554, 13, 8, 543, 26, 1 };      //������ʧЧ
		System.out.println("����ǰ��" + Arrays.toString(array));
		radixSort(array);
		System.out.println("�����" + Arrays.toString(array));
	}

	// Ͱ���� 10��Ͱ����ά���飩 һ��һά�����¼ÿ��Ͱÿ�δ��˶��ٸ���
	public static void radixSort(int[] arr) {
		// ���ҵ�����λ�� ��õ���Ҫ������ٴ�
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		// ���λ��
		int maxLength = (max + "").length();

		// ����ʮ��Ͱ����ά���飩
		int bucket[][] = new int[10][arr.length];
		// ��¼Ͱ�ڶ��ٸ���
		int bucketRecord[] = new int[10];

		// ���λ���Ĵ�����ѭ��
		int n = 1; // ����ÿ�������ȡλ
		for (int i = 0; i < maxLength; i++) {
			// �ֱ�Ž�Ͱ��
			// for (int j = 0, n = 1; j < arr.length; j++, n = n * 10) {�������� ����ÿ�ŵ�Ͱ��һ�ξ���һ��λ
			for (int j = 0; j < arr.length; j++) {
				int temp = arr[j] / n % 10; // ȡ��Ӧ��λ��
				bucket[temp][bucketRecord[temp]] = arr[j]; // �ŵ�Ͱ����
				bucketRecord[temp]++; // ��¼����
			}

			// ������󣬰�Ͱ��˳�����
			int index = 0;
			for (int j = 0; j < bucketRecord.length; j++) {
				if (bucketRecord[j] != 0) { // ������0 ��ʾͰ��������
					for (int j2 = 0; j2 < bucketRecord[j]; j2++) {
						arr[index] = bucket[j][j2]; // ��Ͱ��˳�������������
						index++;
					}
				}
			}

			// һ�н����󣬻�Ҫ���������
			for (int j = 0; j < bucketRecord.length; j++) {
				bucketRecord[j] = 0;
			}
			n = n * 10; // ������������
		}

	}
}
