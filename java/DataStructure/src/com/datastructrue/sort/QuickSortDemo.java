package com.datastructrue.sort;

import java.util.Arrays;

public class QuickSortDemo {
	public static void main(String[] args) {
		int array[] = { 4, -3, 7, 3, -1, 8, -5, 2, 1 };

		System.out.println("����ǰ��" + Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println("�����" + Arrays.toString(array));
	}

	// ȡ�м��ֵ��Ϊ�ο���
	public static void quickSort(int arr[], int left, int right) {
		int pivot = arr[(left + right) / 2];
		int l = left;
		int r = right;
		int temp = 0;

		while (l < r) {
			// ����ָ��ֱ�������������ֵ �ҵ����˳�
			while (arr[l] < pivot) {
				l++;
			}
			while (arr[r] > pivot) {
				r--;
			}

			// ��l>=r ��ʱ�������߶��������� �˳�
			if (l >= r) {
				break;
			}

			// ����
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			// ����֮�� ����l r λ�õ�������pivot
			// ���ƶ�һλ
			if (arr[l] == pivot) {
				r--;
			}
			if (arr[r] == pivot) {
				l++;
			}

			// ��ֹջ���
			if (l == r) {
				l++;
				r--;
			}

			if (left < r) {
				quickSort(arr, left, r);

			}
			if (right > l) {
				quickSort(arr, l, right);
			}
		}
	}

	/// ÿ���������һ����Ϊ�ο���
	public static void quickSort2(int[] arr, int left, int right) {
		if (left > right) { // �˳� ������������˳��ж϶����ڵ�һ�䣡��
			return;
		}

		int l = left; // �����ڵ����ƶ�ָ��
		int r = right; // �����ڵ����ƶ�ָ��

		int temp = 0;

		int value = arr[left]; // ������仰��������˳��жϺ��棡�� �ο�ֵ

		while (r > l) {
			// �������һ����Ϊ�ο��� ����ָ���ƶ�����ָ���ƶ�
			// ͬ�������������һ����Ϊ�ο��㣬������ָ���ƶ�����ָ���ƶ�
			while (arr[r] >= value && r > l) {
				r--; // ��ָ����ڲο�ֵ��ָ�����ƣ������ҵ��ҵ�����ʱ�������ƶ�����
			}

			while (arr[l] <= value && r > l) {
				l++; // ��ָ��ֵС�ڲο�ֵ��ָ�����ƣ������ҵ��ҵ�����ʱ�������ƶ�����
			}

			if (l < r) { // ��δ�������㣬�����ҽ���
				temp = arr[r];
				arr[r] = arr[l];
				arr[l] = temp;
			}
		}

		// �ο�ֵ��ֹͣ�㽻��
		arr[left] = arr[l];
		arr[l] = value;

		quickSort2(arr, left, r - 1); // ��ߵݹ�
		quickSort2(arr, r + 1, right); // �ұߵݹ�

	}
}
