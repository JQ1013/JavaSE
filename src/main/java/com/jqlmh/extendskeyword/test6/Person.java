package com.jqlmh.extendskeyword.test6;

public class Person {
	String name;
	int age;
	int id=100; //身份证号
	
	public Person(){
		System.out.println("我是父类的空参构造器");
	}
	
	public Person(String name){
		this.name=name;
	}
	
	public Person(String name,int age){
		this(name);
		this.age=age;
	}
	
	public void eat() {
		System.out.println("人吃饭");
	}
	
	
	public void walk() {
		this.eat();
		System.out.println("人走路");
	}
}
