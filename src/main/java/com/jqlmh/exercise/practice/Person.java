package com.jqlmh.exercise.practice;

public class Person {
	private int  age;
	private String name;
	
	
	public Person() {
		super();
	}

	public Person(int age) {
		super();
		this.age = age;
	}
	
	

	public Person(String name) {
		super();
		this.name = name;
	}
	

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	//设置属性
	public int getAge() {
		return age;
	}
	
	//获取属性
	public void setAge(int age) {
		if (age>0&&age<=130) {
			this.age = age;
		}
		else{
			this.age = 0;
			System.out.println("传入的数据非法");
		}
	}
	
	
	/*
	 * 四种权限修饰符的测试
	 */
	
	//private：类内部使用
	private void run() {
		
	}
	
	//缺省：同一个包中使用
	void eat(){
		
	}
	
	//protected:同一个包和其他包的子类
	
	//public：公共的，同一个工程内都可以使用
	public void talk() {
		
	}
	
}
