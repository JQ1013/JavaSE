package com.jqlmh.baozhuanglei.practice;

public class Test {
	public static void main(String[] args) {
		Circle c1=new Circle(5, "white", 1.0);
		Circle c2=new Circle(5, "white", 1.0);
		Circle c3=new Circle(6, "red", 1.0);
		
		System.out.println(c1.color==c2.color);
		System.out.println(c1.color==c3.color);
		
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		
		System.out.println(c1.toString());
		System.out.println(c3.toString());
		
	}

}
