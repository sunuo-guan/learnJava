package bishi.zhaoshangyinhang.first;

import java.util.ArrayList;
import java.util.Scanner;

public class MainFirst {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		ArrayList<Integer> tempList=new ArrayList<Integer>();
		int res[]=new int[num];
		for(int i=0;i<num;i++) {
			int len=scanner.nextInt();
			if(len==0) {
				continue;
			}
			for(int j=0;j<len;j++) {
				int temp=scanner.nextInt();
				tempList.add(temp);
			}
			res[i]=least(tempList);
			tempList.clear();
		}
		
		for(int k=0;k<num;k++) {
			System.out.println(res[k]);
		}
	}
	
	public static int least(ArrayList<Integer> list) {
		int len=list.size();
		boolean isTwo=false;
		int temp=0;
		for(int i=0;i<len;i++) {
			if(list.get(i)>=2) {
				isTwo=true;
			}
			if(list.get(i)==0) {
				temp++;
			}
		}
		if(isTwo==false) {
			return -1;
		}else {
			return len+1-temp;
		}
		
	}
	
}
