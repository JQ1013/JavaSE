package com.jqlmh.extendskeyword.test6;

public class SuperTest {
	public static void main(String[] args) {
		Student student=new Student();
		student.show();
		student.stduy();
		
		Student s=new Student("tom", 16, "英语");
		s.show();
		
		System.out.println("*************************");
		Student s2=new Student();   //调用了父类空参的构造器
		
	}

}
