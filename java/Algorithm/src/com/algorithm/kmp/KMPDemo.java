package com.algorithm.kmp;

public class KMPDemo {
	public static void main(String[] args) {
		String a = "ababa";
        String b = "ssdfgasdbababa";
        int[] next = getNext(a);
        int res = kmp(b, a,next);
        System.out.println("从下标为"+res+"开始匹配");
        for(int i = 0; i < next.length; i++){
            System.out.print(next[i]+" ");            
        }
	}

	public static int kmp(String str1, String str2, int[] next) {
		int str1Len = str1.length();
		int str2Len = str2.length();

		for (int i = 0, j = 0; i < str1Len; i++) {
			while (j > 0 && str1.charAt(i) != str2.charAt(j)) {             
				//不匹配当匹配失败时，模式串向右移动的位数为：
				//失配字符所在位置 - 失配字符的前一个字符对应的next 值，
				//即移动的实际位数为：j - next[j-1]，且此值大于等于1
				//化简得到j = next[j - 1]; 
				j = next[j - 1]; 
			}
			if (str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if (j == str2Len) {
				return i - j + 1; // 记得加一，因为此时i++未执行
			}
		}
		return -1;
	}

	public static int[] getNext(String str) {
		int[] next = new int[str.length()];
		next[0] = 0;
		for (int i = 1, j = 0; i < str.length(); i++) {
			while (j > 0 && str.charAt(i) != str.charAt(j)) {
				j = next[j - 1];
			}
			if (str.charAt(i) == str.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}

}
