package com.offer.chapter5;

public class Test51Demo {
	public static void main(String[] args) {
		Solution51 solution51 = new Solution51();
		int nums[] = { 4,5,6,7};
		System.out.println(solution51.reversePairs(nums));
	}

}

class Solution51 {
	private long count = 0;
	private int[] temp;

	public int reversePairs(int[] nums) {
		temp = new int[nums.length];
		mergeSort(0, nums.length - 1, nums);
		return (int) count;
	}

	private void mergeSort(int left, int right, int nums[]) {
		if (right <= left) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(left, mid, nums);
		mergeSort(mid + 1, right, nums);
		merge(left, right, mid, nums);
	}

	private void merge(int left, int right, int mid, int nums[]) {
		int l = mid; // ָ�����
		int r = right;
		int t = right; // ��������ָ��

		while (l >= left && r >= mid + 1) {
			if (nums[l] > nums[r]) {
				temp[t] = nums[l];
				//ͳ��������������������ĵ�ǰ�������ұ����鵱ǰ����
				//��ô���ұ����鵱ǰ��һֱ���ұ��������߽綼�������
				count = count + r - mid;   
				l--;
				t--;
			} else {
				temp[t] = nums[r];
				r--;
				t--;
			}
		}

		// ������һ������ʣ�����ȫ������������������
		while (l >= left) {
			temp[t] = nums[l];
			l--;
			t--;
		}

		while (r >= mid + 1) {
			temp[t] = nums[r];
			r--;
			t--;
		}

		//�������������������ԭ�����У��Ӻ�ǰ
		int tempStart = right; // ���������Ӧ��ԭ�����λ��
		t = right;
		while (tempStart >= left) {
			// ���������Ӧ��λ��
			nums[tempStart] = temp[t];
			tempStart--;
			t--;
		}

	}
}
