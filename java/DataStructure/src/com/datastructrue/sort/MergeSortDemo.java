package com.datastructrue.sort;

import java.util.Arrays;

public class MergeSortDemo {
	public static void main(String[] args) {
		int array[] = { 4, -3, 7, 3, -1, 8, -5, 2, 1 };
		int temp[]=new int[array.length];
		System.out.println("����ǰ��" + Arrays.toString(array));
		mergeSort(array, 0, array.length - 1,temp);
		System.out.println("�����" + Arrays.toString(array));
	}
	
	
	/**
	 * �鲢�����ȷֳ�С�ֺ�ϲ��ɴ��
	 */

	public static void mergeSort(int arr[],int left,int right, int temp[]) {
		if(left<right) {       //�˳��ݹ������ ��left>=rightʱ��ֻʣ��һ��
			int mid=(left+right)/2;     //�ֽ�ʵ�����ǽ�left��right��mid���費ͬ���±�ֵ
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid+1, right, temp);
			merge(arr, left, right, mid, temp);
		}
		//�����ڶ���ݹ�:left=0 right=1 mid=0 ���ε��õ�������һ��mergeSort��ֱ���˳� Ȼ��ִ��merge 
		
	}
	
	public static void merge(int arr[], int left, int right, int mid, int temp[]) {

		int l = left;
		int r = mid + 1;
		int t = 0; // ��������ָ��

		// 1���Ƚ��������ϲ������ֵ��С�ľ����Ƶ�һ������������
		// ֱ������һ�����ϲ�����ȫ���ƶ�����
		while (l <= mid && r <= right) {
			if (arr[l] <= arr[r]) {
				temp[t] = arr[l];
				l++;
				t++;
			} else {
				temp[t]=arr[r];
				r++;
				t++;
			}
		}
		
		//2.������һ������ʣ�����ȫ������������������
		while(l<=mid) {
			temp[t] = arr[l];
			l++;
			t++;
		}
		
		while(r<=right) {
			temp[t]=arr[r];
			r++;
			t++;
		}
		
		//3.�������������������ԭ������
		int tempStart=left;   //���������Ӧ��ԭ�����λ��
		t=0;
		while(tempStart<=right) {
			//���������Ӧ��λ��
			arr[tempStart]=temp[t];
			tempStart++;
			t++;
		}
		
	}
}
