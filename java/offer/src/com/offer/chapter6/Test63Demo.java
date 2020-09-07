package com.offer.chapter6;

public class Test63Demo {
	public static void main(String[] args) {
		int prices[]= {3,4,3,2,5,1,3,4,5,3};
		System.out.println(maxProfit(prices));
	}
	
	/**
	 * 遍历数组，卖出价固定，记录前面的最小买入价
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
