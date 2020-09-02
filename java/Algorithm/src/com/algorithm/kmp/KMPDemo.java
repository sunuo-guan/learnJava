package com.algorithm.kmp;

public class KMPDemo {
	public static void main(String[] args) {
		String a = "ababa";
        String b = "ssdfgasdbababa";
        int[] next = getNext(a);
        int res = kmp(b, a,next);
        System.out.println("���±�Ϊ"+res+"��ʼƥ��");
        for(int i = 0; i < next.length; i++){
            System.out.print(next[i]+" ");            
        }
	}

	public static int kmp(String str1, String str2, int[] next) {
		int str1Len = str1.length();
		int str2Len = str2.length();

		for (int i = 0, j = 0; i < str1Len; i++) {
			while (j > 0 && str1.charAt(i) != str2.charAt(j)) {             
				//��ƥ�䵱ƥ��ʧ��ʱ��ģʽ�������ƶ���λ��Ϊ��
				//ʧ���ַ�����λ�� - ʧ���ַ���ǰһ���ַ���Ӧ��next ֵ��
				//���ƶ���ʵ��λ��Ϊ��j - next[j-1]���Ҵ�ֵ���ڵ���1
				//����õ�j = next[j - 1]; 
				j = next[j - 1]; 
			}
			if (str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if (j == str2Len) {
				return i - j + 1; // �ǵü�һ����Ϊ��ʱi++δִ��
			}
		}
		return -1;
	}

	public static int[] getNext(String str) {
		int[] next = new int[str.length()];
		next[0] = 0;
		for (int i = 1, j = 0; i < str.length(); i++) {
			while (j > 0 && str.charAt(i) != str.charAt(j)) {
				j = next[j - 1];
			}
			if (str.charAt(i) == str.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}

}
