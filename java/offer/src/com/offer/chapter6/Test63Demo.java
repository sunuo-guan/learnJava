package com.offer.chapter6;

public class Test63Demo {
	public static void main(String[] args) {
		int prices[]= {3,4,3,2,5,1,3,4,5,3};
		System.out.println(maxProfit(prices));
	}
	
	/**
	 * �������飬�����۹̶�����¼ǰ�����С�����
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		if(prices==null||prices.length<=0) {
			return 0;
		}
		
		int minBuy=prices[0];
		int max=0;
		
		for (int i = 1; i < prices.length; i++) {
			if(max<prices[i]-minBuy) {
				max=prices[i]-minBuy;
			}
			
			if(prices[i]<minBuy) {
				minBuy=prices[i];
			}
		}
		
		return max;
    }
}
