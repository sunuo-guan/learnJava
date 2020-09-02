package com.datastructure.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int findValue = 5;
		//int index = binarySearch(array, 0, array.length - 1, findValue);
		int index=binarySearchNoRecursion(array, findValue);
		if (index == -1) {
			System.out.println("����Ԫ�ز�����");
		} else {
			System.out.println("����Ԫ���±�Ϊ��" + index);
		}

		System.out.println("*********");
		int[] array2 = { 1, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9 };
		findValue = 9;
		List<Integer> indexList = new ArrayList<Integer>();
		indexList = binarySearchImprove(array2, 0, array2.length, findValue);
		System.out.println(indexList);

	}

	// �ǵݹ�
	public static int binarySearchNoRecursion(int arr[], int key) {
		int left = 0;
		int right = arr.length-1;      //ע��߽�ֵ
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	// ���������������
	public static int binarySearch(int arr[], int left, int right, int findValue) {
		if (left > right) { // �˳��ݹ����������Ҳ�����
			return -1;
		}

		int mid = (left + right) / 2;
		int midValue = arr[mid];

		if (findValue > midValue) {
			return binarySearch(arr, mid + 1, right, findValue);
		} else if (findValue < midValue) {
			return binarySearch(arr, left, mid - 1, findValue);
		} else {
			return mid;
		}
	}

	// �ɲ��Ҷ����ͬ��Ԫ��
	public static List<Integer> binarySearchImprove(int arr[], int left, int right, int findValue) {
		if (left > right) { // �˳��ݹ����������Ҳ�����
			return new ArrayList<Integer>();
		}

		int mid = (left + right) / 2;
		int midValue = arr[mid];

		if (findValue > midValue) {
			return binarySearchImprove(arr, mid + 1, right, findValue);
		} else if (findValue < midValue) {
			return binarySearchImprove(arr, left, mid - 1, findValue);
		} else {
			// �ҵ�ʱ��������������
			List<Integer> resList = new ArrayList<Integer>();
			int midIndex = mid - 1;
			while (true) {
				if (midIndex < 0 || arr[midIndex] != findValue) {
					break;
				}
				resList.add(midIndex);
				midIndex--;
			}
			// �м��ֵҲҪ����
			resList.add(mid);

			// ����
			midIndex = mid + 1;
			while (true) {
				if (midIndex > arr.length - 1 || arr[midIndex] != findValue) {
					break;
				}
				resList.add(midIndex);
				midIndex++;
			}

			return resList;
		}
	}
}
