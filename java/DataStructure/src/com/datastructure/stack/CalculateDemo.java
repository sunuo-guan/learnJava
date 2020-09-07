package com.datastructure.stack;

public class CalculateDemo {
	public static void main(String[] args) {
		// ��׺���ʽ
		String target = "1+1076";
		// ��ջ ����ջ
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
			ch = target.substring(index, index + 1).charAt(0); // ȡһ���������
			if (!opperStack.isOpper(ch)) { // �����һ����
				//numStack.push(ch - 48); // ascaii������ ��ת����ϵ
				//��λ�� �жϺ����Ƿ��Ƿ��� ��������ջ ���������
				
				keepNum+=ch;     //��ƴ��
				
				//���ж��Ƿ�Ϊ���һ����!!!
				if(index==target.length()-1) {
					//ֱ����ջ
					numStack.push(Integer.parseInt(keepNum));
				}else {
					if(opperStack.isOpper(target.substring(index+1, index+2).charAt(0))) {
						//����Ƿ��� ����ջ
						numStack.push(Integer.parseInt(keepNum));
						//�ǵ���ջ��Ҫ���keepNum!!!
						keepNum="";
					}
				}
			} else { // �����һ������
				if (opperStack.isEmpty()) {
					opperStack.push(ch); // �������ջ�ǿ� ��ֱ����ջ
				} else {
					if (opperStack.pirority(ch) <= opperStack.pirority(opperStack.peek())) { // �����С�ڻ����ǰ�������� �򵯳���������һ���������������
						num1 = numStack.pop();
						num2 = numStack.pop();
						opper = opperStack.pop();
						res = opperStack.cal(num1, num2, opper);
						numStack.push(res);     //�����ջ
						opperStack.push(ch);    //��ǰ�����ҲҪ��ջ
					} else {
						// ֱ����ջ
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

	// ������
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
		top = -1;
	}

	// �ж�ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// �ж�ջ��
	public boolean isEmpty() {
		return top == -1;
	}

	// ��ջ
	public void push(int value) {
		// ���� ���ж�
		if (isFull()) {
			System.out.println("ջ�����޷���ջ");
			return;
		}
		top++;
		stack[top] = value;
	}

	// ��ջ
	public int pop() {
		// �ȼ����쳣
		if (isEmpty()) {
			throw new RuntimeException("ջ�ѿ�");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// ���� ��ջ����ջ��
	public void showStack() {
		// �ȼ���
		if (isEmpty()) {
			System.out.println("ջ�ѿ�");
			return;
		}

		for (int i = top; i >= 0; i--) {
			System.out.println("stack[" + i + "]=" + stack[i]);
		}
	}

	// �鿴ջ��Ԫ�ص�������
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("ջΪ��");
		}
		return stack[top];
	}

	// �������������ֵ �����ֱ�ʾ ����Խ�� ���ȼ�Խ�� ����ֻ���Ӽ��˳�
	public int pirority(int op) {
		if (op == '*' || op == '/') {
			return 1;
		} else if (op == '+' || op == '-') {
			return 0;
		} else
			return -1;
	}

	// �ж��ǲ��������
	public boolean isOpper(int op) {
		if (op == '*' || op == '/' || op == '+' || op == '-') {
			return true;
		} else {
			return false;
		}
	}

	// ���㷽��
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