package bishi.meituan.forth;

import java.util.Scanner;

public class Test {
    static int maxn = 10000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[maxn];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        int mod = 998244353;
        long[] f = new long[maxn];
        int[] mark = new int[maxn];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (mark[a[i]] == 0)
                f[i] = (2 * f[i - 1]) % mod;
            else {
                f[i] = (2 * f[i - 1] - f[mark[a[i]] - 1] + mod) % mod;
            }
            //利用hash原理，保存上一次重复元素的位置
            mark[a[i]] = i;
        }
        System.out.println(f[n] - 1);
    }
 
}