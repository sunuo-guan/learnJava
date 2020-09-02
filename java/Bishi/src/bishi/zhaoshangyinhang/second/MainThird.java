package bishi.zhaoshangyinhang.second;

import java.util.Arrays;
import java.util.Scanner;

public class MainThird {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		int len;
		int res[]=new int[num];
		int index=0;
		while(num>0) {
			len=scanner.nextInt();
			int a[]=new int[len];
			int b[]=new int[len];
			node[] h=new node[len];
			for (int i = 0; i < len; i++) {
				a[i]=scanner.nextInt();
			}
			for (int i = 0; i < len; i++) {
				b[i]=scanner.nextInt();
			}
			for (int i = 0; i < len; i++) {
				h[i]=new node(a[i],b[i]);
			}
			Arrays.sort(h);
			int ans=0,j=0;
			while(j<len) {
				ans++;
				int tempx=0,tempy=0;
				for(int i=0;i<len;i++) {
					if(h[i].a>=tempx&&h[i].b>=tempy&&h[i].flag) {
						h[i].flag=false;
						j++;
						tempx=h[i].a;
						tempy=h[i].b;
					}
				}
			}
			res[index]=ans;
			index++;
			num--;
		}
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	
	public static class node implements Comparable<node>{
		int a,b;
		boolean flag;
		public node(int a,int b) {
			this.a=a;
			this.b=b;
			this.flag=true;
		}
		public int compareTo(node temp) {
			if(this.a>temp.a||(this.a==temp.a&&this.b>temp.b)) {
				return 1;
			}else if(this.a==temp.a&&this.b==temp.b){
				return 0;
			}else {
				return -1;
			}
		}
	}
}
