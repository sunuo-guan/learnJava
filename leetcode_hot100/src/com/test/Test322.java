package com.test;

import java.util.*;

public class Test322 {
	public static void main(String[] args) {
		int arr[] = {2};
		int amount = 3;
		System.out.println(coinChange(arr, amount));
	}
	
    public static int coinChange(int[] coins, int amount) {
    	int minCoin[] = new int[amount+1];
    	Arrays.fill(minCoin, amount+1);
    	minCoin[0] = 0;
    	for(int i = 1;i <amount + 1;i++) {
    		for(int j =0;j<coins.length;j++) {
    			if(i - coins[j] >=0) {
    				minCoin[i] = Math.min(minCoin[i], minCoin[i - coins[j]]+1);
    			}
    		}
    	}
    	return minCoin[amount] > amount ? -1 : minCoin[amount];
    }
}
