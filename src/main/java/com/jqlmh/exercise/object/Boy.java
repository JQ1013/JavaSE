package com.jqlmh.exercise.object;

public class Boy {
	private String name;
	private int age;
	
	public void setName(String i) {
		this.name=i;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge (int i) {
		this.age=i;
	}
	
	public int getAge() {
		return age;
	}
	
	public void marry(Girl girl) {
		System.out.println("我想娶"+girl.getName());
	}
	
	public void shout() {
		if (age>=22) {
			System.out.println("你可以结婚了");
		}else{
			System.out.println("再谈谈恋爱");
		}
		
	}
}
