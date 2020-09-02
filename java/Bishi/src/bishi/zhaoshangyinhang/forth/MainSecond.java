package bishi.zhaoshangyinhang.forth;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSecond {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		ArrayList<Integer> length=new ArrayList<Integer>();
		ArrayList<Integer> weight=new ArrayList<Integer>();
		int res[]=new int[num];
		for(int i=0;i<num;i++) {
			int len=scanner.nextInt();
			for(int j=0;j<len;j++) {
				int temp=scanner.nextInt();
				length.add(temp);
			}
			for(int j=0;j<len;j++) {
				int temp=scanner.nextInt();
				weight.add(temp);
			}
			res[i]=lestTime(len,length,weight);
			length.clear();
			weight.clear();
		}
		
		for(int k=0;k<num;k++) {
			System.out.println(res[k]);
		}
	}
	
	public static int lestTime(int len,ArrayList<Integer> length,ArrayList<Integer> weight) {
		int ans=1;
		int w[]=new int[len];
		int l[]=new int[len];
		boolean addOneMin=true;
		w[0]=weight.get(0);
		l[0]=length.get(0);
		
		for(int i=1;i<len;i++) {
			addOneMin=true;
			for(int j=0;j<ans&&addOneMin;j++) {
				if(w[j]>weight.get(i)&&l[j]>length.get(i)) {
					addOneMin=false;
				}
				
				if(w[j]<=weight.get(i)&&l[j]<=length.get(i)) {
					w[j]=weight.get(i);
					l[j]=length.get(i);
					addOneMin=false;
				}
			}
			
			if(addOneMin) {
				w[ans]=weight.get(i);
				l[ans]=length.get(i);
				ans++;
			}
		}
		
		return ans;
		
	}
}
