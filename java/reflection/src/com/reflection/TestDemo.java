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
	
	//获取class实例的方法
	public static void test1() throws ClassNotFoundException {
		//方式一：调用运行时类的属性：.class（写死了类）
		Class<Person> clazz1=Person.class;   //加泛型不用强转
		System.out.println(clazz1);
		
		//方式二：通过运行时类的对象，调用getClass
		Person p1=new Person();
		Class clazz2=p1.getClass();
		System.out.println(clazz2);
		
		//方式三：调用class的静态方法：forname（String classPath）(此方法更好体现动态性）
		//Class clazz3 = Class.forName("com.reflection.Person"); 
		Class clazz3 = Class.forName("java.lang.String"); 
		System.out.println(clazz3);
		
		System.out.println(clazz1==clazz2);
		System.out.println(clazz1==clazz3);
		
		//方式四：使用类的加载器classloader
		ClassLoader classLoader = TestDemo.class.getClassLoader();
		Class clazz4=classLoader.loadClass("com.reflection.Person");
		System.out.println(clazz4);
		System.out.println(clazz1==clazz4);
	}
}
