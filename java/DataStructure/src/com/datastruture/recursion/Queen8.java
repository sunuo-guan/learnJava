package com.datastruture.recursion;

public class Queen8 {
	static int count=0;
	int max=8;
	int[] array=new int[max];    //一维数组存放解法 下标代表行 元素代表列
	public static void main(String[] args) {
		Queen8 queen=new Queen8();
		queen.check(0);
		System.out.println("解法有："+count);
	}
	
	//找到所有解法 n表示第几个皇后
	private void check(int n) {
		if(n==max) {
			print();
			return;
		}
		else {
			for (int i = 0; i < array.length; i++) {
				array[n]=i;         //先给一个值
				if(judge(n)) {      
					//如果给的值可以成功 则检查下一个值
					check(n+1);
				}
				//如果给的值不能成功 则循环给一个新的值
			}
		}
	}
	
	
	//判断皇后是否能摆放在当前位置 注意输入为第n个 否则斜线难以判断
	private boolean judge(int n) {
		
		for (int i = 0; i < n; i++) {
			//判断是否同列
			//判断是否在斜线上 等腰三角形 行距等于列距
			if(array[n]==array[i]||Math.abs(i-n)==Math.abs(array[n]-array[i])){
				return false;
			}
		}
		
		return true;
	}
	
	//找到正确解法时打印解法
	private void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
