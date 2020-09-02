package com.test;

import java.util.Scanner;

public class Main {
	public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        String input[]=scanner.nextLine().split(" ");
        int value[]=new int[input.length];
        for(int i=0;i<input.length;i++){
            value[i]=Integer.parseInt(input[i]);
        }
        
        System.out.println(maxMoney(value));
        
        System.out.println(998244353<Integer.MAX_VALUE);
    }	
    
    public static int maxMoney(int value[]){
        if(value==null||value.length==0){
            return 0;
        }
        
        int len=value.length;
        int money[]=new int[len];
        int minVal=value[0];
        
        for(int i=0;i<len;i++){
            if(minVal>=value[i]){
                money[i]=0;
                minVal=value[i];
            }else{
                money[i]=value[i]-minVal;
            }
        }
        
        int max=money[0];
        for(int j:money){
            if(j>max){
                max=j;
            }
        }
        
        return max;
        
    }
}
