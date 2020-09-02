package com.webank.two;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		String theNull=scanner.nextLine();
		String strs[]=new String[num];
		for (int i = 0; i < num ;i++) {
			strs[i]=scanner.nextLine();
		}
		
		win(strs);
		
	}
	
	public static void win(String strs[]) {
		String first="Cassidy";
		String last="Eleanore";
		
		for (int i = 0; i < strs.length; i++) {
			int charArr[]=new int[26];
			char temp[]=strs[i].toCharArray();
			for(char key:temp) {
				charArr[key-'a']++;
			}
			int count=0;
			for(int j=0;j<charArr.length;j++) {
				if(charArr[j]%2==1) {
					count++;
				}
			}
			if(count==1||count==0) {
				System.out.println(first);
			}else {
				if(count%2==0) {
					System.out.println(last);
				}else {
					System.out.println(first);
				}
			}
		}
	}
}
