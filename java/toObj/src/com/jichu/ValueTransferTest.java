package com.jichu;

/**
 *  形参：方法声明时的参数
实参： 方法调用时实际传给形参的参数值

     形参是基本数据类型：将实参基本数据类型变量的“数据值”传递给形参
形参是引用数据类型：将实参引用数据类型变量的“地址值”传递给形参

 * @author Administrator
 *
 */

public class ValueTransferTest {
	public static void main(String[] args) {
		int a=1;
		int b=2;
		int temp;
		ValueTransferTest test=new ValueTransferTest();
//		temp=a;
//		a=b;
//		b=temp;
		test.swap(a,b);
		System.out.println(a+","+b);
		
		
		Data data =new Data();
		data.a=1;
		data.b=2;
		test.swap(data);
		System.out.println(data.a+","+data.b);
		
	}
	public void swap(int a,int b) {
		int temp;
		temp=a;
		a=b;
		b=temp;
	}
	public void swap(Data data) {
		int temp;
		temp=data.a;
		data.a=data.b;
		data.b=temp;
	}
}

class Data{
	int a;
	int b;
}
