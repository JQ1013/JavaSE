package com.jqlmh.extendskeyword.test1;

public class Student extends Person {
	
	public void learn() {
		breath();  
		talk();     //子类可以继承父类的所有方法，无论是直接父类还是间接父类
		System.out.println("学生能学习");
		
	}

}
