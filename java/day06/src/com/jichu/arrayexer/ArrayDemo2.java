package com.jichu.arrayexer;

import java.util.Scanner;

/**
 * 
 * 2. 从键盘读入学生成绩，找出最高分，并输出学生成绩等级。 成绩>=最高分-10 等级为’A’ 成绩>=最高分-20 等级为’B’
 * 成绩>=最高分-30 等级为’C’ 其余 等级为’D’ 提示：先读入学生人数，根据人数创建int数组， 存放学生成绩。
 *
 */
public class ArrayDemo2 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入学生人数：");
		int number = scanner.nextInt();

		int[] grade = new int[number];

		System.out.println("请输入" + "个学生的成绩：");
		int maxGrade = 0;
		for (int i = 0; i < number; i++) {
			grade[i] = scanner.nextInt();
			if (grade[i] > maxGrade) {
				maxGrade = grade[i];
			}
		}
		System.out.println("最高分是："+maxGrade);
		for (int i = 0; i < number; i++) {
			String dengji;
			if (grade[i] >= maxGrade - 10) {
				dengji = "A";
			} else if (grade[i] >= maxGrade - 20) {
				dengji = "B";
			} else if (grade[i] >= maxGrade - 30) {
				dengji = "C";
			} else {
				dengji = "D";
			}
			System.out.println("student " + i + " score is " + grade[i] + "grade is " + dengji);
		}

	}
}
