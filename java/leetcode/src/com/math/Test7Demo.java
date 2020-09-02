package com.math;

public class Test7Demo {
	public static void main(String[] args) {
		System.out.println(reverse(123));
	}
	
	public static int reverse(int x) {
        String str=x+"";
        int nega=str.charAt(0)=='-'?1:0;
        char arr[]=str.toCharArray();

        for(int i=nega,j=arr.length-1;i<=j;i++,j--){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }

        long res=0;
        for(int i=nega;i<arr.length;i++){
            res=res*10+arr[i]-'0';
        }

        if(nega==1){
            res=-res;
        }

        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)res;
        }
    }
}
