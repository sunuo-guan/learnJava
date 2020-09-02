package com.jingdongyan.one;

import java.util.Scanner;

public class Main{
	 public static int getAns(int[][] num){
	        int ans = 0;
	        for(int i = 0;i < num.length;i++){
	            int tmp = 0,cmp = num[i][1],cmp2 = num[i][0];
	            for(int j = 0;j < num.length;j++){
	                if(i == j)
	                    continue;
	                if(num[j][0] < cmp && num[j][1] >= cmp)
	                    tmp++;
	                else  if(num[j][0] >= cmp2 && num[j][1] <= cmp)
	                    tmp++;
	                else if(num[j][0] <= cmp2 && cmp2 < num[j][1])
	                    tmp++;
	            }
	            ans = Math.max(ans,tmp);
	        }
	        return ans;
	    }

	    public static void sort(int[][] num){
	        //Ã°ÅÝÅÅÐò
	        for(int i = 0;i < num.length;i++){
	            for (int j = i+1;j < num.length;j++){
	                if(num[i][0] > num[j][0]){
	                    int tmp1 = num[i][0],tmp2 = num[i][1];
	                    num[i][0] = num[j][0];
	                    num[i][1] = num[j][1];
	                    num[j][0] = tmp1;
	                    num[j][1] = tmp2;
	                }
	            }
	        }
	    }
	    public static void main(String[] args) {
	        Scanner ac = new Scanner(System.in);
	        int t = ac.nextInt();
	        int[][] num = new int[t][2];
	        for (int i = 0;i < t;i++){
	            num[i][0] = ac.nextInt();
	            num[i][1] = ac.nextInt();
	        }
	        sort(num);
	        int n = getAns(num);
	        System.out.println(n+1);
	    }
	}
