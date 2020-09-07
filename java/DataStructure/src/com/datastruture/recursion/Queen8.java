package com.datastruture.recursion;

public class Queen8 {
	static int count=0;
	int max=8;
	int[] array=new int[max];    //һά�����Žⷨ �±������ Ԫ�ش�����
	public static void main(String[] args) {
		Queen8 queen=new Queen8();
		queen.check(0);
		System.out.println("�ⷨ�У�"+count);
	}
	
	//�ҵ����нⷨ n��ʾ�ڼ����ʺ�
	private void check(int n) {
		if(n==max) {
			print();
			return;
		}
		else {
			for (int i = 0; i < array.length; i++) {
				array[n]=i;         //�ȸ�һ��ֵ
				if(judge(n)) {      
					//�������ֵ���Գɹ� ������һ��ֵ
					check(n+1);
				}
				//�������ֵ���ܳɹ� ��ѭ����һ���µ�ֵ
			}
		}
	}
	
	
	//�жϻʺ��Ƿ��ܰڷ��ڵ�ǰλ�� ע������Ϊ��n�� ����б�������ж�
	private boolean judge(int n) {
		
		for (int i = 0; i < n; i++) {
			//�ж��Ƿ�ͬ��
			//�ж��Ƿ���б���� ���������� �о�����о�
			if(array[n]==array[i]||Math.abs(i-n)==Math.abs(array[n]-array[i])){
				return false;
			}
		}
		
		return true;
	}
	
	//�ҵ���ȷ�ⷨʱ��ӡ�ⷨ
	private void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
