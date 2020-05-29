package com.jqlmh.extendskeyword.test4;

public class Person {
	String name;
	int age;
	
	
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void walk(int distance) {
		System.out.println("走路走的距离是"+distance+"公里");
		show();
		eat();
	}
	public void eat() {
		System.out.println("吃饭");
	}
	
	//测试子类不能重写被private修饰的方法
	private void show(){
		System.out.println("我是一个人");
	}
	
	public Object info() {
		return null;
	}
	
	public double info1() {
		return 1.1;
	}
	
	
}
