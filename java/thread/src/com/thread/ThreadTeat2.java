package com.thread;


/**
 * 1) �������࣬ʵ��Runnable�ӿڡ�
 * 2) ��������дRunnable�ӿ��е�run������
 * 3) ͨ��Thread�ຬ�ι����������̶߳���
 * 4) ��Runnable�ӿڵ����������Ϊʵ�ʲ������ݸ�Thread��Ĺ������С�
 * 5) ����Thread���start�����������̣߳� ����Runnable����ӿڵ�run������
 * @author Administrator
 *
 */

/**
 * ����:
 * �̳�Thread���̴߳�����Thread����run�����С�
 * ʵ��Runnable���̴߳�����ڽӿڵ������run������
 * ʵ�ַ�ʽ�ĺô�:
 * �����˵��̳еľ�����
 * ����߳̿��Թ���ͬһ���ӿ�ʵ����Ķ��󣬷ǳ��ʺ϶����ͬ�߳�������ͬһ����Դ��
 * @author Administrator
 *
 */
public class ThreadTeat2 {
	public static void main(String[] args) {
		//3) ͨ��Thread�ຬ�ι����������̶߳���
		ThreadMy temp =new ThreadMy();
		//4) ��Runnable�ӿڵ����������Ϊʵ�ʲ������ݸ�Thread��Ĺ������С�
		Thread t1 = new Thread(temp);
		t1.setName("һ");
		//5) ����Thread���start�����������̣߳� ����Runnable����ӿڵ�run������
		t1.start();
		
		//�ٵ���һ���߳�
		Thread t2 = new Thread(temp);
		t2.setName("��");
		t2.start();
	}
}

//1) �������࣬ʵ��Runnable�ӿڡ�
class ThreadMy implements Runnable{
	@Override
//	2) ��������дRunnable�ӿ��е�run������
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
}



