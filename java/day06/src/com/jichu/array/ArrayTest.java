package com.jichu.array;
/**
 * һά����
 * @author Administrator
 *
 */
public class ArrayTest {
	public static void main(String[] args) {
		
		//1��һά����ĳ�ʼ��������
		
		int[] ids;   //����
		//��̬��ʼ���������ʼ���͸�ֵͬʱ����
		ids = new int[] {1001,1002};
		
		//��̬��ʼ���������ʼ���͸�ֵ�ֿ����� 	
		String[] name = new String[5];
		
		//2����������ָ��λ��Ԫ�أ��Ǳ����
		name[0]="hh";
		name[1]="ggg";
		name[2]="hh";
		name[3]="ggg";
		name[4]="gggg";
		
		//3����ȡ���鳤�� ���ԣ�length
		System.out.println(name.length);
		System.out.println(ids.length);
		
		//4����������Ԫ��
		for(int i=0;i<name.length;i++) {
			System.out.println(name[i]);
		}
		
		//5��Ĭ�ϳ�ʼ��ֵ
		int[] arry = new int[5];
		for(int i=0;i<arry.length;i++) {
			System.out.println(arry[i]);   //���Ͷ�Ϊ0
		}
		
		System.out.println("*******");
		double[] arry1 = new double[5];
		for(int i=0;i<arry1.length;i++) {
			System.out.println(arry1[i]);   //�����Ͷ�Ϊ0
		}
		
		System.out.println("*******");
		char[] arry2 = new char[5];
		for(int i=0;i<arry2.length;i++) {
			System.out.println(arry2[i]);   //char��Ϊ0��'\u0000',����'0'
		}
		if(arry2[0]==0) {
			System.out.println("true");
		}
		
		System.out.println("*******");
		boolean[] arry3 = new boolean[4];  //������Ϊfalse
		System.out.println(arry3[0]);
		
		System.out.println("*******");
		String[]  arry4 = new String[4];   //�����������ͣ�null
		if(arry4[0]==null) {
			System.out.println("true");
		}
		if(arry4[0]=="null") {
			System.out.println("false");
		}
		
	}
}
