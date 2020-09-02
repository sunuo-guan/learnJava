package com.algorithm.horse;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessDemo {
	
	private static int X;   //����
	private static int Y;   //����
	private static boolean[] visited;
	private static boolean finish;   //�ж��Ƿ��������
	
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
		//���̸���ڼ���
		board[row][column]=step;
		//���ô���Ϊ�ѷ���
		visited[row*X+column]=true;
		//��ȡ�ܷ��ʵ����е�
		ArrayList<Point> p=next(new Point(column,row));
		//���� ѡ��������С���ȳ���
		sort(p);
		//���Դ����ܷ��ʵĵ�ʱ�����Ϸ���
		while(!p.isEmpty()) {
			Point pnext=p.remove(0);
			if(visited[pnext.y*X+pnext.x]==false) {
				horseChess(board,pnext.x,pnext.y,step+1);
			}
			
		}
		
		if(step<X*Y&&finish==false) {
			board[row][column]=0;
			visited[row*X+column]=false;   //����ʧ�ܻ���ʱ���ǵ�Ҫ����δ���ʣ�����
		}else {
			finish=true;
		}
	}
	
	/**
	 * ���ص�ǰλ����һ�����ߵ�λ�ã�����а˸�λ��
	 * @param curPoint
	 * @return
	 */
	public static ArrayList<Point> next(Point curPoint){
		ArrayList<Point> ps=new ArrayList<Point>();
		Point p1=new Point();
		
		//�ֱ��жϰ˸�λ��
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
	
	//���ݵ�ǰ���������һ�������һ����������� ѡ���������ٵĽ��л���
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
