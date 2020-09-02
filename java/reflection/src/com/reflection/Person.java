package com.reflection;

class Person {
	private String name;
	public int age;
	
	
	private Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
		System.out.println("person");
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
