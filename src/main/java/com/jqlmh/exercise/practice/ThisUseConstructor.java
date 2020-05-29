package com.jqlmh.exercise.practice;
/*
 * this调用构造器
 */
public class ThisUseConstructor {
	public static void main(String[] args) {
		//UseConstuctor uc=new UseConstuctor("你好");
		UseConstuctor uc1=new UseConstuctor("你好",55);
		
	}

}

class UseConstuctor{
	private String name;
	private int age;
	
	public UseConstuctor(){
		System.out.println("空参构造器");
	}
	
	public UseConstuctor(String name){
		this();  //this调用空参数构造器
		this.name=name;
		System.out.println("一个参数构造器");
	}
	
	public UseConstuctor (int age) {
		this.age=age;
	}
	
	public UseConstuctor(String name,int age){
		this(name);  //this调用参数为name的构造器
		this.age=age;
		System.out.println("两个参数的构造器");
	}
	
}
