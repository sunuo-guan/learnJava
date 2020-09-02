package com.algorithm.horse;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessDemo {
	
	private static int X;   //列数
	private static int Y;   //行数
	private static boolean[] visited;
	private static boolean finish;   //判断是否完成任务
	
	public static void main(String[] args) {
		X=8;
		Y=8;
		visited=new boolean[X*Y];
		int board[][]=new int[X][Y];
		int column=0;
		int row=0;
		int step=1;
		horseChess(board, column, row, step);
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void horseChess(int[][] board,int column,int row,int step) {
		//棋盘赋予第几步
		board[row][column]=step;
		//将该处置为已访问
		visited[row*X+column]=true;
		//获取能访问的所有点
		ArrayList<Point> p=next(new Point(column,row));
		//排序 选可能性最小的先尝试
		sort(p);
		//当仍存在能访问的点时，不断访问
		while(!p.isEmpty()) {
			Point pnext=p.remove(0);
			if(visited[pnext.y*X+pnext.x]==false) {
				horseChess(board,pnext.x,pnext.y,step+1);
			}
			
		}
		
		if(step<X*Y&&finish==false) {
			board[row][column]=0;
			visited[row*X+column]=false;   //访问失败回溯时，记得要设置未访问！！！
		}else {
			finish=true;
		}
	}
	
	/**
	 * 返回当前位置下一步能走的位置，最多有八个位置
	 * @param curPoint
	 * @return
	 */
	public static ArrayList<Point> next(Point curPoint){
		ArrayList<Point> ps=new ArrayList<Point>();
		Point p1=new Point();
		
		//分别判断八个位置
		if((p1.x=curPoint.x-2)>=0&&(p1.y=curPoint.y-1)>=0) {
			ps.add(new Point(p1));
		}
		
		if((p1.x=curPoint.x-2)>=0&&(p1.y=curPoint.y+1)<Y) {
			ps.add(new Point(p1));
		}
		
		if((p1.x=curPoint.x-1)>=0&&(p1.y=curPoint.y-2)>=0) {
			ps.add(new Point(p1));
		}
		
		if((p1.x=curPoint.x-1)>=0&&(p1.y=curPoint.y+2)<Y) {
			ps.add(new Point(p1));
		}
		
		if((p1.x=curPoint.x+1)<X&&(p1.y=curPoint.y-2)>=0) {
			ps.add(new Point(p1));
		}
		
		if((p1.x=curPoint.x+1)<X&&(p1.y=curPoint.y+2)<Y) {
			ps.add(new Point(p1));
		}
		
		if((p1.x=curPoint.x+2)<X&&(p1.y=curPoint.y-1)>=0) {
			ps.add(new Point(p1));
		}
		
		if((p1.x=curPoint.x+2)<X&&(p1.y=curPoint.y+2)<Y) {
			ps.add(new Point(p1));
		}
		
		return ps;
	}
	
	//跟据当前点的所有下一个点的下一个点进行排序 选择数量最少的进行回溯
	public static void sort(ArrayList<Point> ps) {
		ps.sort(new Comparator<Point>() {
			public int compare(Point o1,Point o2) {
				int count1=next(o1).size();
				int count2=next(o2).size();
				if(count1<count2) {
					return -1;
				}else if(count1==count2) {
					return 0;
				}else {
					return 1;
				}
			}
		});
	}
}
