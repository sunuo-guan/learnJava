package com.datastructure.stack;

public class CalculateDemo {
	public static void main(String[] args) {
		// 中缀表达式
		String target = "1+1076";
		// 数栈 符号栈
		ArrayStack2 opperStack = new ArrayStack2(100);
		ArrayStack2 numStack = new ArrayStack2(100);
		int opper = 0;
		int num1 = 0;
		int num2 = 0;
		int index = 0;
		char ch = ' ';
		int res = 0;
		boolean loop = true;
		
		String keepNum="";

		while (loop) {
			ch = target.substring(index, index + 1).charAt(0); // 取一个数或符号
			if (!opperStack.isOpper(ch)) { // 如果是一个数
				//numStack.push(ch - 48); // ascaii表里面 的转换关系
				//多位数 判断后面是否是符号 若是则入栈 若否则继续
				
				keepNum+=ch;     //先拼接
				
				//先判断是否为最后一个数!!!
				if(index==target.length()-1) {
					//直接入栈
					numStack.push(Integer.parseInt(keepNum));
				}else {
					if(opperStack.isOpper(target.substring(index+1, index+2).charAt(0))) {
						//如果是符号 则入栈
						numStack.push(Integer.parseInt(keepNum));
						//记得入栈后要清空keepNum!!!
						keepNum="";
					}
				}
			} else { // 如果是一个符号
				if (opperStack.isEmpty()) {
					opperStack.push(ch); // 如果符号栈是空 则直接入栈
				} else {
					if (opperStack.pirority(ch) <= opperStack.pirority(opperStack.peek())) { // 运算符小于或等于前面的运算符 则弹出两个数和一个运算符进行运算
						num1 = numStack.pop();
						num2 = numStack.pop();
						opper = opperStack.pop();
						res = opperStack.cal(num1, num2, opper);
						numStack.push(res);     //结果入栈
						opperStack.push(ch);    //当前运算符也要入栈
					} else {
						// 直接入栈
						opperStack.push(ch);
					}
				}
			}
			index++;
			if (index >= target.length()) {
				break;
			}
		}

		while (true) {
			if (opperStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			opper = opperStack.pop();
			res = opperStack.cal(num1, num2, opper);
			numStack.push(res);
		}
		res=numStack.pop();
		System.out.println(target + "=" + res);
	}
}

class ArrayStack2 {
	private int maxSize;
	private int top;
	private int[] stack;

	// 构造器
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
		top = -1;
	}

	// 判断栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// 判断栈空
	public boolean isEmpty() {
		return top == -1;
	}

	// 入栈
	public void push(int value) {
		// 检验 先判断
		if (isFull()) {
			System.out.println("栈满，无法入栈");
			return;
		}
		top++;
		stack[top] = value;
	}

	// 出栈
	public int pop() {
		// 先检验异常
		if (isEmpty()) {
			throw new RuntimeException("栈已空");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// 遍历 从栈顶到栈底
	public void showStack() {
		// 先检验
		if (isEmpty()) {
			System.out.println("栈已空");
			return;
		}

		for (int i = top; i >= 0; i--) {
			System.out.println("stack[" + i + "]=" + stack[i]);
		}
	}

	// 查看栈顶元素但不弹出
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		return stack[top];
	}

	// 返回运算符优先值 用数字表示 数字越大 优先级越高 现在只含加减乘除
	public int pirority(int op) {
		if (op == '*' || op == '/') {
			return 1;
		} else if (op == '+' || op == '-') {
			return 0;
		} else
			return -1;
	}

	// 判断是不是运算符
	public boolean isOpper(int op) {
		if (op == '*' || op == '/' || op == '+' || op == '-') {
			return true;
		} else {
			return false;
		}
	}

	// 计算方法
	public int cal(int num1, int num2, int op) {
		int res = 0;
		switch (op) {
		case '+':
			res = num1 + num2;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}

}