package com.Compare;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		Integer in1=1;
		Integer in2=1;
		System.out.println(in1==in2);
	}

	/**
	 * ��Ȼ����compareable 
	 * 1.String����װ��ȶ�ʵ����compareable�ӿڣ���д��compareTo����
	 * 2.��дcompareTo�����Ĺ��򣺣����� 
	 * �����ǰ����this�����βζ���obj������������
	 *  �����ǰ����thisС���βζ���obj�����ظ�����
	 * �����ǰ����this�����βζ���obj��������
	 */
	public static void test1() {
		String arr[] = { "aa", "bb", "cc", "dd" };

		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));
	}

	/**
	 * ���Զ�������˵������ʵ�����򣬿������Զ�����ʵ��compareable�ӿڣ���дcompareTo���� �ڷ�����ָ���������
	 */
	public static void test2() {
		Goods arr[] = new Goods[4];
		arr[0] = new Goods(1, "a");
		arr[1] = new Goods(2, "b");
		arr[2] = new Goods(3, "f");
		arr[3] = new Goods(0, "z");

		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));
	}

	/**
	 * �������� ��Ԫ�ص�����û��ʵ��java.lang.Comparable�ӿڶ��ֲ������޸Ĵ��룬
	 * ����ʵ����java.lang.Comparable�ӿڵ���������ʺϵ�ǰ�Ĳ����� ��ô���Կ���ʹ�� Comparator �Ķ���������
	 * ǿ�жԶ�����������������ıȽϡ�
	 * 
	 * ��дcompare(Object o1,Object o2)�������Ƚ�o1��o2�Ĵ�С�� 
	 * ����������������������ʾo1����o2��
	 * �������0����ʾ��ȣ�
	 * ���ظ���������ʾo1С��o2��
	 */
	public static void test3() {
		String arr[] = { "aa", "bb", "cc", "dd" };

		Arrays.sort(arr,new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				if(o1 instanceof String&&o2 instanceof String) {
					String str1=(String)o1;
					String str2=(String)o2;
					return -str1.compareTo(str2);
				}
				throw new RuntimeException("���Ͳ���ȷ");
			}
		});
		
		System.out.println(Arrays.toString(arr));
	}
}
