package com.datastruture.recursion;

public class QueenDemo {
	int max=8;
	int[] array =new int[max];   //һά���� �±��ʾ�� �����Ԫ��ֵ��ʾ��
	static int count=0;         //��̬ ��¼�ɹ�����
	public static void main(String[] args) {
		QueenDemo queen=new QueenDemo();
		queen.check(0);
		System.out.println("�ܹ��Ľ�ĸ����У�"+count);
	}
	
	//�鿴��n���������ȷ��
	private void check(int n) {
		if(n==max) {    //�ݹ��˳�����
			print();
			return;
		}
		for (int i = 0; i < max; i++) {
			array[n]=i;      //������ѡһ��λ��
			if(judge(n)) {   //������λ�÷��� ��������ӵ���һ�� �������� ��������Ӹ�һ����ֵ
				check(n+1);
			}
		}
		
	}
	
	//�жϵ�n���������º��Ƿ���ǰ���ͻ
	private boolean judge(int n) {
		boolean res=true;
		for (int i = 0; i < n; i++) {     //nǰ����������Ӳ����ж�
			//�Ƿ���ͬһ�� ������Ԫ���Ƿ����
			//�Ƿ���ͬһб�� ���������� �������о���о��Ƿ����
			if(array[i]==array[n]||Math.abs(array[i]-array[n])==Math.abs(i-n)){
				res=false;
			}
		}
		return res;
	}
	
	//�ҵ�һ����ʱ �����ȷ�Ľ�
	private void print() {
		count++;
		for (int i = 0; i < max; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("");
	}
	
}
