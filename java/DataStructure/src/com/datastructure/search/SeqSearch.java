package com.datastructure.search;

public class SeqSearch {
	public static void main(String[] args) {
		int[] array= {409, 323, 37, 3554, 13, 8, 543, 26, 1};
		int index=seqSearch(array, 409);
		if(index!=-1) {
			System.out.println("待查值在第"+index+"位");
		}else {
			System.out.println("没有找到");
		}
	}
	
	//查找数组内某值下标 没有则返回-1
	public static int seqSearch(int arr[],int value) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==value) {
				return i;
			}
		}
		return -1;
	}
}
