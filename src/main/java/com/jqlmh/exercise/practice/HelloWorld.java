package com.jqlmh.exercise.practice;

import java.util.Scanner;

/**
 * 
* @Description 第一个程序
* @author Luminghao Email:13142187714@163.com
* @version v1.0
* @date 2019年5月14日下午9:56:22
*
 */

public class HelloWorld {
	
	public static void main(String[] args) {
		System.out.println("HelloWorld!!");
		int[] a=new int[5];
		
		
		int max=0;
		Scanner s=new Scanner(System.in);
		System.out.print("请输入学生人数：");
		int stdNum=s.nextInt();
		System.out.print("请输入"+stdNum+"个成绩：");
		int[] score=new int[stdNum];
		for (int i = 0; i < score.length; i++) {
			
				score[i]=s.nextInt();	
			
		}
		for (int i = 0; i < score.length; i++) {
			if (score[i]>max) {
				max=score[i];
			}
		}
		System.out.println("最高分是："+max);
		;
		for (int i = 0; i < score.length; i++) {
			String s1;
			if (score[i]>=max-10) {
				s1="等级是A";
			} else if(score[i]>=max-20){
				s1="等级是B";
			}else if (score[i]>=max-30) {
				s1="等级是C";
			} else {
				s1="等级是D";
			}
			System.out.println("学生"+i+"的成绩是："+score[i]+s1);
		}
		
		
		
		
		
		
		
	}
	

}
