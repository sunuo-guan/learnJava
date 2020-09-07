package com.datastructrue.sort;

import java.util.Arrays;

public class HeapSortDemo {
	public static void main(String[] args) {
		int arr[]= {1,3,-2,4,98,-43,0,4};
		System.out.println("����ǰ��");
		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println("�����");
		System.out.println(Arrays.toString(arr));
	}

	// ������
	/**
	 * 
	 * @param arr
	 * 1.�ȹ���󶥶�
	 * 2.�󶥶Ѷ��������һ��������
	 * 3.�����һ������ �ٹ���󶥶� ѭ��2.3
	 */
	public static void heapSort(int[] arr) {
		//�Ӻ���ǰ����󶥶� �����һ�����ڵ㿪ʼ ���i = arr.length/2-1
		for (int i = arr.length/2-1; i >= 0; i--) {
			heap(arr,i,arr.length);
		}
		
		int temp=0;
		for (int i = arr.length-1; i > 0; i--) {
			//����
			temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			//�����´󶥶� ʼ���Ե�һ��Ԫ��Ϊ�� ���ȵݼ�
			heap(arr,0,i);
		}
		
	}

	// �����
	/**
	 * ����������һ����ȫ����������˳��洢������
	 * 
	 * @param arr    Ҫ����ѵ�����
	 * @param i      ��i��Ϊ�������
	 * @param length ��ʱҪ����ѵĳ���
	 */
	public static void heap(int arr[], int i, int length) {
		int temp = arr[i]; // ����Ѷ�Ԫ�� ���ڽ���

		for (int j = 2 * i + 1; j < length; j = 2 * i + 1) { // ѭ���ҵ��������
			if (j+1<length&&arr[j] < arr[j + 1]) { // �ҵ������ӽڵ�������һ�� �õ����±�j ��Ҫ��ֹ���
				j++;
			}

			if (arr[j] > temp) { // �������ӽڵ���һ���ȶ��ڵ�� �򶥽ڵ�������
				arr[i] = arr[j];
				i = j;           //����������
			}else {
				break;           
			}
			//���ݴ󶥶����� ���ڵ�һ�����ӽڵ�� ��˵��ҵ��ɽ������ӽڵ㽻����
			//��Ҫ���������Ҵ��ӽڵ���ӽڵ��Ƿ�ȶѶ����ҵ���������
			//Ҳ��Ϊ�󶥶����� ���ڵ�һ�����ӽڵ�� ����ӽڵ�ȶѶ�С�� ���ӽڵ��������ж��ȶѶ�С ����ֱ��break
		}
		arr[i]=temp;

	}

}
