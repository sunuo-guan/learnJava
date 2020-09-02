package com.string;

import java.util.Stack;

public class Test32Demo {
	public static void main(String[] args) {
		String s="(()";
		System.out.println(longestValidParentheses(s));
	}
	
	public static int longestValidParenthesesWithStack(String s) {
        //ջ����(�Ҳ�������ִ���ֻ���ҵ�����)��
		//����������ÿ��(�����ǽ������±����ջ�С�
		//����������ÿ��) �����ǵ���ջ����Ԫ��:
		//1.��ջ������Ԫ�أ��򽫵�ǰԪ�ص��±��뵯��Ԫ���±�����ó���ǰ��Ч�����ַ����ĳ��ȣ�
		//2.��ջΪ�գ��򽫵�ǰ�±�ѹ��ջ
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
	 * ��̬�滮��dp������iΪ��β����Ϸ�����
	 * 1����......()��:dp[i]=dp[i-1]+2
	 * 2����......))��:������...)(...))��dp[i]=0
	 * 				������...((...))��dp[i]=2+dp[i-1]+dp[i-dp[i-1]-2],dp[i-dp[i-1]-2]ָ��ǰ��'('��֮ǰ��'('��Ժ�'('ǰ�ĺϷ����Ŵ�Ҳ�ϲ���һ����
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
