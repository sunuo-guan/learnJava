package com.datastruture.recursion;

public class QueenDemo {
	int max=8;
	int[] array =new int[max];   //一维数组 下标表示行 里面的元素值表示列
	static int count=0;         //静态 记录成功次数
	public static void main(String[] args) {
		QueenDemo queen=new QueenDemo();
		queen.check(0);
		System.out.println("总共的解的个数有："+count);
	}
	
	//查看第n个后面的正确解
	private void check(int n) {
		if(n==max) {    //递归退出条件
			print();
			return;
		}
		for (int i = 0; i < max; i++) {
			array[n]=i;      //给棋子选一个位置
			if(judge(n)) {   //若棋子位置符合 则检查该棋子的下一个 若不符合 则给该棋子赋一个新值
				check(n+1);
			}
		}
		
	}
	
	//判断第n个棋子落下后是否与前面冲突
	private boolean judge(int n) {
		boolean res=true;
		for (int i = 0; i < n; i++) {     //n前面的所有棋子参与判断
			//是否在同一列 数组内元素是否相等
			//是否在同一斜线 等腰三角形 两棋子行距和列距是否相等
			if(array[i]==array[n]||Math.abs(array[i]-array[n])==Math.abs(i-n)){
				res=false;
			}
		}
		return res;
	}
	
	//找到一个解时 输出正确的解
	private void print() {
		count++;
		for (int i = 0; i < max; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("");
	}
	
}
