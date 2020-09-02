package com.datastructrue.sort;

import java.util.Arrays;

public class HeapSortDemo {
	public static void main(String[] args) {
		int arr[]= {1,3,-2,4,98,-43,0,4};
		System.out.println("排序前：");
		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println("排序后：");
		System.out.println(Arrays.toString(arr));
	}

	// 堆排序
	/**
	 * 
	 * @param arr
	 * 1.先构造大顶堆
	 * 2.大顶堆顶点与最后一个数交换
	 * 3.除最后一个数外 再构造大顶堆 循环2.3
	 */
	public static void heapSort(int[] arr) {
		//从后向前构造大顶堆 从最后一个父节点开始 因此i = arr.length/2-1
		for (int i = arr.length/2-1; i >= 0; i--) {
			heap(arr,i,arr.length);
		}
		
		int temp=0;
		for (int i = arr.length-1; i > 0; i--) {
			//交换
			temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			//构造新大顶堆 始终以第一个元素为顶 长度递减
			heap(arr,0,i);
		}
		
	}

	// 构造堆
	/**
	 * 将数组视作一个完全二叉树，即顺序存储二叉树
	 * 
	 * @param arr    要构造堆的数组
	 * @param i      以i点为顶构造堆
	 * @param length 此时要构造堆的长度
	 */
	public static void heap(int arr[], int i, int length) {
		int temp = arr[i]; // 保存堆顶元素 用于交换

		for (int j = 2 * i + 1; j < length; j = 2 * i + 1) { // 循环找点的左子树
			if (j+1<length&&arr[j] < arr[j + 1]) { // 找到左右子节点中最大的一个 得到其下标j 且要防止溢出
				j++;
			}

			if (arr[j] > temp) { // 若左右子节点有一个比顶节点大 则顶节点等于最大
				arr[i] = arr[j];
				i = j;           //继续往下找
			}else {
				break;           
			}
			//根据大顶堆性质 父节点一定比子节点大 因此当找到可交换的子节点交换后，
			//还要继续往下找此子节点的子节点是否比堆顶大，找到继续交换
			//也因为大顶堆性质 父节点一定比子节点大 因此子节点比堆顶小后 此子节点后面的所有都比堆顶小 可以直接break
		}
		arr[i]=temp;

	}

}
