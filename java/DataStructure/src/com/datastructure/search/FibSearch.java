package com.datastructure.search;

public class FibSearch {

	static int maxSize = 20;

	public static void main(String[] args) {
		int array[] =new int[100];
		for(int i=0;i<array.length;i++) {
			array[i]=i;
		}
		int index = fibSearch(array, 99);
		if (index != -1) {
			System.out.println("����ֵ����Ϊ" + index);
		} else {
			System.out.println("û���ҵ�");
		}
	}

	// ���ɲ�����쳲���������
	public static int[] fib(int Size) {
		int[] f = new int[Size];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

	public static int fibSearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		int[] f = fib(maxSize); // ����һ��쳲���������
		int k = 0; // 쳲����������±�
		int mid = 0;
		int temp = 0;

		// �ҵ���ӽ���쳲����������е�����Ϊ�������ݺ󳤶�
		while (arr.length > f[k]) {
			k++;
		}

		// ���������� ���� �����һ��������µ�����
		int[] arrCopy = new int[f[k]];
		for (int i = 0; i < arrCopy.length; i++) {
			if (i < arr.length) {
				arrCopy[i] = arr[i];
			} else {
				arrCopy[i] = arr[arr.length - 1];
			}
		}

		while (left <= right) {
			// midѡȡ�ƽ�ָ��
			mid = left + f[k - 1] - 1;
			temp = arrCopy[mid];

			if (key < temp) { // С��mid ��ǰ���� ��f[k-2]����
				right = mid - 1;
				k--;
			} else if (key > temp) { // ����mid ������ ��f[k-3]����
				left = mid + 1;
				k = k - 2;
			} else { // �ҵ� ��Ҫ�����Ƿ������ݺ������β��
				if (mid >= arr.length) {
					return arr.length - 1;
				} else {
					return mid;
				}
			}
		}

		// û���ҵ�
		return -1;

	}

}
