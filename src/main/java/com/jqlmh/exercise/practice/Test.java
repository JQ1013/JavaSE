package com.jqlmh.exercise.practice;

public class Test {
	public static void main(String[] args) {
		int a=10;
		int b=10;
		method(a, b);
		System.out.println("a="+a);
		System.out.println("b="+a);
		
	}
	
	public static int method(int x,int y){
		x*=10;
		y*=20;
		return 0;
	}

}
