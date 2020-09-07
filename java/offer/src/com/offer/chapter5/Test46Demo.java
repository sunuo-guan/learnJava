package com.offer.chapter5;

public class Test46Demo {
	public static void main(String[] args) {
		System.out.println(translateNum(12258));
	}
	
	/**
	 * ��̬�滮��dp�洢���Ǵ��ַ���β���ַ���ͷ���ӵ�i���ַ���ʼ���ж����ֻ��ַ���
	 * @param num
	 * @return
	 */
	public static int translateNum(int num) {
		if(num<0) {
			return 0;
		}
		
		String str=num+"";
		int len=str.length();
		if(len==1) {
			//�˴��������÷�ֹ����
			return 1;
		}
		
		int dp[]=new int[len];
		dp[len-1]=1;
		int test=num%100;
		if(test>=10&&test<=25) {
			dp[len-2]=2;
		}else {
			dp[len-2]=1;
		}
		
		for(int i=len-3;i>=0;i--) {
			int digital1=str.charAt(i)-'0';
			int digital2=str.charAt(i+1)-'0';
			int conver=digital1*10+digital2;
			if(conver>=10&&conver<=25) {
				dp[i]=dp[i+1]+dp[i+2];
			}else {
				dp[i]=dp[i+1];
			}
		}
		
		return dp[0];
    }
}
