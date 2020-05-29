package com.jqlmh.jiekou.jiekoujdk8;
/*
 * Java 8中，你可以为接口添加静态方法和默认方法。
 */
public interface CompareA {
	//静态方法
	public static void method() {
		System.out.println("compare A");
	}
	//默认方法
	public default void method1(){
		System.out.println("compare A的默认方法");
	}
	
	default void method2(){
		System.out.println("compare C");
	}
}
