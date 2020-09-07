package bishi.meituan.first;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println(Integer.MAX_VALUE<Math.pow(10, 1000));
		String input=scanner.nextLine();
		String arr[]=scanner.nextLine().split(" ");
		System.out.println(zhihuan(input,arr));
	}
	
	public static String zhihuan(String input,String arr[]) {
		boolean isFu=false;
		int indexInput=0;
		if(input.charAt(0)=='-') {
			isFu=true;
			indexInput=1;
		}
		
		//key是目标数字，value是待替换的数字
		HashMap<Character, Character>map= new HashMap<Character, Character>();
		for (int i = 0; i < arr.length; i++) {
			char temp=(char)(i+1+'0');
			map.put(temp, arr[i].charAt(0));
		}
		
		
		StringBuilder sb=new StringBuilder();
		if(isFu) {
			sb.append('-');
		}
		
		for (int i = indexInput; i < input.length(); i++) {
			char temp=map.get(input.charAt(i));
			sb.append(temp);
		}
		
		return sb.toString();
		
		
	}
	
}
