package com.jqlmh.duotai.exer;


public class InstanceTest {
	public static void main(String[] args) {
		InstanceTest i=new InstanceTest();
		Person p=new Person();
//		i.method(p);
		i.method(new Student());
//		i.method(new Graduate());
	}
	
	
	
	public void method(Person e){
		System.out.println(e.getInfo());
		
		if (e instanceof Graduate) {
			System.out.println("a graduated student");
		}
		if (e instanceof Student) {
			System.out.println("a student");
			
		}
		if (e instanceof Person) {
			System.out.println("a person");
		}
	}
}

class Person{
	protected String name="Person";
	protected int age=50;
	public String getInfo() {
		return "Name"+name+"\nAge"+age;
	}
}

class Student extends Person{
	protected String school="pku";
	@Override
	public String getInfo() {
		return "Name"+name+"\nAge"+age+"\nschool"+school;
	}
}

class Graduate extends Student{
	public String major="it";
	@Override
	public String getInfo() {
		return "Name: "+ name + "\nage: "+ age + "\nschool: "+ school+"\nmajor:"+major;
	}
			
}