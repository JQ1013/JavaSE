package com.jqlmh.extendskeyword.test4;

public class Student extends Person {
	String major;
	public Student(){
		
	}
	
	public Student(String major){
		this.major=major;
	}
	//对父类中的eat（）方法进行了重写
	public void eat() {
		System.out.println("学生应该多吃有营养的食物");
	}
	public void study() {
		System.out.println("学习，专业是："+major);
	}
	
	//父类show（）方法被private修饰，不能被子类重写
	public void show() {
		System.out.println("我是一个学生");
	}
	
	
	//返回值类型测试
	public String info() {
		return null;
	}
	
	/*@Override
	public void walk(int distance) {
		
	}*/
	
	//测试返回值为基本数据类型时候返回值类型要一直
	/*public int info1() {     报错//The return type is incompatible with 
		 Person.info1()
		return 1;
	}*/
}
	

