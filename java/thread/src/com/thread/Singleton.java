package com.thread;

public class Singleton {
	public volatile static Singleton singleInstance;
	
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static Singleton getInstance() {
		if(singleInstance==null) {
			synchronized (Singleton.class) {
				if(singleInstance==null) {
					singleInstance=new Singleton();
				}
			}
		}
		
		return singleInstance;
	}
}

//¾²Ì¬ÄÚ²¿Àà
class SingletonDemo3 {
    
    private static class SingletonClassInstance{
        private static final SingletonDemo3 instance=new SingletonDemo3();
    }
     
    private SingletonDemo3(){}
     
    public static SingletonDemo3 getInstance(){
        return SingletonClassInstance.instance;
    }
     
}
