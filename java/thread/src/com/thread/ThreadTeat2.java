package com.thread;


/**
 * 1) 定义子类，实现Runnable接口。
 * 2) 子类中重写Runnable接口中的run方法。
 * 3) 通过Thread类含参构造器创建线程对象。
 * 4) 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中。
 * 5) 调用Thread类的start方法：开启线程， 调用Runnable子类接口的run方法。
 * @author Administrator
 *
 */

/**
 * 区别:
 * 继承Thread：线程代码存放Thread子类run方法中。
 * 实现Runnable：线程代码存在接口的子类的run方法。
 * 实现方式的好处:
 * 避免了单继承的局限性
 * 多个线程可以共享同一个接口实现类的对象，非常适合多个相同线程来处理同一份资源。
 * @author Administrator
 *
 */
public class ThreadTeat2 {
	public static void main(String[] args) {
		//3) 通过Thread类含参构造器创建线程对象。
		ThreadMy temp =new ThreadMy();
		//4) 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中。
		Thread t1 = new Thread(temp);
		t1.setName("一");
		//5) 调用Thread类的start方法：开启线程， 调用Runnable子类接口的run方法。
		t1.start();
		
		//再调用一次线程
		Thread t2 = new Thread(temp);
		t2.setName("二");
		t2.start();
	}
}

//1) 定义子类，实现Runnable接口。
class ThreadMy implements Runnable{
	@Override
//	2) 子类中重写Runnable接口中的run方法。
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
}



