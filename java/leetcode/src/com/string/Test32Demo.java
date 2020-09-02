package com.string;

import java.util.Stack;

public class Test32Demo {
	public static void main(String[] args) {
		String s="(()";
		System.out.println(longestValidParentheses(s));
	}
	
	public static int longestValidParenthesesWithStack(String s) {
        //栈方法(找不到最大字串，只能找到长度)：
		//对于遇到的每个(，我们将它的下标放入栈中。
		//对于遇到的每个) ，我们弹出栈顶的元素:
		//1.若栈内仍有元素，则将当前元素的下标与弹出元素下标作差，得出当前有效括号字符串的长度；
		//2.若栈为空，则将当前下标压入栈
        if(s==null||s.length()==0){
            return 0;
        }

        Stack<Integer> stack=new Stack<Integer>();
        stack.push(-1);
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                	max=Math.max(max,i-stack.peek());
                }               
            }
        }

        return max;
    }

	/**
	 * 动态规划：dp保存以i为结尾的最长合法括号
	 * 1、“......()”:dp[i]=dp[i-1]+2
	 * 2、“......))”:若：“...)(...))”dp[i]=0
	 * 				若：“...((...))”dp[i]=2+dp[i-1]+dp[i-dp[i-1]-2],dp[i-dp[i-1]-2]指当前的'('与之前的'('配对后，'('前的合法括号串也合并在一起了
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int len = s.length(), max = 0;
		int[] dp = new int[len];

		for (int i = 1; i < len; i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = i == 1 ? 2 : dp[i - 2] + 2;
				} else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - 1) == ')' && s.charAt(i - dp[i - 1] - 1) == '(') {
					if (i - dp[i - 1] - 2 >= 0) {
						dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
					} else {
						dp[i] = dp[i - 1] + 2;
					}
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}
