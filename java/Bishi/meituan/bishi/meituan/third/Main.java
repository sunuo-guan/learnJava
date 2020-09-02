package bishi.meituan.third;

import java.util.*;

public class Main {
	private static final int constVal=998244353;
	static int maxn = 10000;
	private static LinkedList<Integer> list;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = scanner.nextInt();
		}
		list=new LinkedList<Integer>();
		modEqualsZero(arr);
		output();
	}
	
	public static void modEqualsZero(int arr[]) {
		int len=arr.length;
		for (int i = 0; i < len; i++) {
			if(i%arr[i]==0) {
				list.add(arr[i]);
			}
		}
	}
	
	public static void output() {
		long[] dp = new long[list.size()+1];
        HashMap<Integer,Integer> mark=new HashMap<Integer, Integer>();
        dp[0] = 1;
        for (int i = 0,j=1; i < list.size(); i++,j++) {
            if (!mark.containsKey(list.get(i)))
                dp[j] = (2 * dp[j - 1]) % constVal;
            else {
                dp[j] = (2 * dp[j - 1] - dp[mark.get(list.get(i)) - 1] + constVal) % constVal;
            }

            mark.put(list.get(i), i);
        }
        System.out.println(dp[list.size()]-1);
	}
	
}
