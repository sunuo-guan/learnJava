package com.jichu.enumtest;

public class EnumTest {

}

interface info{
	public void show();
}

enum Person implements info{
	MAN("ÄÐÈË"){
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("nan");
		}
	},
	WOMAN("Å®ÈË"){
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("nv");
		}
	};
	
	private final String sex;
	
	private Person(String sex) {
		this.sex=sex;
	}
}
