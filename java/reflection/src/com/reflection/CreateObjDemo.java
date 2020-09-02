package com.reflection;



public class CreateObjDemo {
	
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		Class<Person> clazz=Person.class;
		
		//newInstance:��������ʱ��Ķ��󣻵���������ʱ��Ŀղι�����
		//1.����ʱ������ṩ�ղι�����2.����Ȩ�ޱ��빻��ͨ��Ϊpublic
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
