package com.datastructure.search;

public class InsertValueSort {
	public static void main(String[] args) {
		int array[] =new int[100];
		for(int i=0;i<array.length;i++) {
			array[i]=i*2;
		}

		int findValue = 99;
		int index = insertValueSort(array, 0, array.length - 1, findValue);
		if (index == -1) {
			System.out.println("����Ԫ�ز�����");
		} else {
			System.out.println("����Ԫ���±�Ϊ��" + index);
		}
	}
	
	//���÷�Χ���ֲ��ȽϾ��� ��������
	public static int insertValueSort(int arr[],int left,int right, int findValue) {
		//��ֹ�����midʹ����Խ�磬�������������������������Դͷ��ɱ��ֱ���˳�
		if(left>right||findValue<arr[0]||findValue>arr[arr.length-1]) {
			return -1;
		}
		System.out.println("����");
		//����Ӧ�ı�
		int mid=left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
		int midValue=arr[mid];
		if(midValue>findValue) {
			return insertValueSort(arr, left, mid-1, findValue);
		}else if(midValue<findValue) {
			return insertValueSort(arr, mid+1, right, findValue);
		}else {
			return mid;
		}
	}
}
