package com.reflection;



public class CreateObjDemo {
	
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		Class<Person> clazz=Person.class;
		
		//newInstance:创建运行时类的对象；调用了运行时类的空参构造器
		//1.运行时类必须提供空参构造器2.访问权限必须够，通常为public
		Person obj=null;
		try {
			obj = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj);
		
	}
}
