package com.reflection;

public class TestDemo {
	public static void main(String[] args) {
		try {
			test1();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ȡclassʵ���ķ���
	public static void test1() throws ClassNotFoundException {
		//��ʽһ����������ʱ������ԣ�.class��д�����ࣩ
		Class<Person> clazz1=Person.class;   //�ӷ��Ͳ���ǿת
		System.out.println(clazz1);
		
		//��ʽ����ͨ������ʱ��Ķ��󣬵���getClass
		Person p1=new Person();
		Class clazz2=p1.getClass();
		System.out.println(clazz2);
		
		//��ʽ��������class�ľ�̬������forname��String classPath��(�˷����������ֶ�̬�ԣ�
		//Class clazz3 = Class.forName("com.reflection.Person"); 
		Class clazz3 = Class.forName("java.lang.String"); 
		System.out.println(clazz3);
		
		System.out.println(clazz1==clazz2);
		System.out.println(clazz1==clazz3);
		
		//��ʽ�ģ�ʹ����ļ�����classloader
		ClassLoader classLoader = TestDemo.class.getClassLoader();
		Class clazz4=classLoader.loadClass("com.reflection.Person");
		System.out.println(clazz4);
		System.out.println(clazz1==clazz4);
	}
}
