package com.thread;

public class CommunicationTest {
	public static void main(String[] args) {
		Communicate communicate = new Communicate();
		Thread t1 = new Thread(communicate);
		Thread t2 = new Thread(communicate);
		
		t1.start();
		t2.start();
		
	}
}

/**
 * �������̽����ӡ1-100���漰����ͨ��
 * ����������
 * wait����������
 * notify������һ�������ȼ��ߣ�
 * notifyAll�����Ѷ��
 * ֻ�ܷ���ͬ����������ͬ�������
 * ���������ĵ����߱�����ͬ������顢ͬ��������ͬ������������������
 * ����������������Object��
 * @author Administrator
 *
 */
class Communicate implements Runnable{
	private int num=1;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			synchronized (this) {
				
				notify();
				
				if(num<=100) {
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName()+"��ӡ��"+num);
					num++;
					
					try {
						//ʹ���߳̽�������״̬
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					break;
				}
			}		
			
		}
	}
}
