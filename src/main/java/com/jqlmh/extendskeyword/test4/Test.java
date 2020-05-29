package com.jqlmh.extendskeyword.test4;

public class Test {
	public static void main(String[] args) {
		Student student=new Student("计算机");
//		student.eat();
//		student.walk(100);
//		student.study();
		
		//测试子类重写的方法，有private修饰和没有private修饰
		student.walk(100);
	}
}
