package com.jqlmh.exercise.practice1;


import com.jqlmh.exercise.practice.Person;

/*
 * 1.权限修饰符的测试，缺省在不同包里面不可以使用
 * 2.构造器的测试
 */
public class PersonTest {
	public static void main(String[] args) {
		Person b=new Person();
		
		//b.eat();  //eat（）方法是缺省的，在不同包中不能使用
		b.talk();
		
		//构造器的测试
		
		Person b1=new Person(5);  //
		Person b2=new Person("张三");  //
		Person b3=new Person(6,"李四");  //
		
		
	}
}
