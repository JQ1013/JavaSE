package com.jqlmh.extendskeyword.test6;

public class Student extends Person {
	String major;
	int id=101;//学号
	
	public  Student() {
		
	}
	
	public  Student(String major) {
		this.major=major;
	}
	
	
	


	public  Student(String name,int age,String major) {
//		this.name=name;
//		this.age=age;   如果父类的属性被声明为private，则子类的构造器中不能用此种方式声明，需要使用super调用父类的构造器
		super(name, age);//super调用父类的构造器，
		this.major=major;
	}
	
	@Override
	public void eat() {
		System.out.println("学生多吃有营养的东西");
	}
	
	public void stduy() {
		System.out.println("学生：学习知识");
		this.eat();
		super.eat();
	}
	
	public void show() {
		System.out.println("name="+name+",age="+super.age);
		System.out.println("id"+this.id);
		System.out.println("id"+super.id);
	}

	
	public static void main(String[] args) {
		Student student = new Student();
		student.walk();
	}
}
