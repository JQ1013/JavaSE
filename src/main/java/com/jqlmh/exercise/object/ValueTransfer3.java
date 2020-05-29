package com.jqlmh.exercise.object;

import java.lang.reflect.Method;

/*
 * 网红题目
 */
public class ValueTransfer3 {
	public static void main(String[] args) {
		int a=10;
		int b=10;
		method(a,b);  //需要在method方法调用后，仅打印出a=100，b=200；请写出method方法的
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	
	public static void method(int a,int b) {
		a*=10;
		b*=20;
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.exit(0);
	}

}
