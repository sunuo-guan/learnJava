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
	 * 自然排序compareable 
	 * 1.String、包装类等都实现了compareable接口，重写了compareTo方法
	 * 2.重写compareTo方法的规则：（升序） 
	 * 如果当前对象this大于形参对象obj，返回正整数
	 *  如果当前对象this小于形参对象obj，返回负整数
	 * 如果当前对象this等于形参对象obj，返回零
	 */
	public static void test1() {
		String arr[] = { "aa", "bb", "cc", "dd" };

		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 对自定义类来说，若想实现排序，可以让自定义类实现compareable接口，重写compareTo方法 在方法中指明如何排序
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
	 * 定制排序 当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
	 * 或者实现了java.lang.Comparable接口的排序规则不适合当前的操作， 那么可以考虑使用 Comparator 的对象来排序，
	 * 强行对多个对象进行整体排序的比较。
	 * 
	 * 重写compare(Object o1,Object o2)方法，比较o1和o2的大小： 
	 * 如果方法返回正整数，则表示o1大于o2；
	 * 如果返回0，表示相等；
	 * 返回负整数，表示o1小于o2。
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
				throw new RuntimeException("类型不正确");
			}
		});
		
		System.out.println(Arrays.toString(arr));
	}
}
