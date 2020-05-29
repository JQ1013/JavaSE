package com.jqlmh.exercise.practice;

public class TriAngleTest {
	
	public static void main(String[] args) {
		
		//无参构造方法
		TriAngle t1=new TriAngle();
		t1.setBase(5.0);
		t1.setHeight(50);
		System.out.println("面积是"+t1.area());
		
		//有参构造方法
		TriAngle t=new TriAngle(5, 10);
		System.out.println("面积是"+t.area());
	}
	
}
