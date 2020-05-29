package com.jqlmh.exercise.practice;
/*
 * Java封装性体现
 */
public class PersonTest {
	public static void main(String[] args) {
		Person b=new Person();
		
		//b.age=4;  //不能直接调用
		b.setAge(60);
		b.getAge();  
		
		/*
		 * 权限修饰符的测试
		 */
		
		//b.run(); //run（）方法为private，只能在类内部使用，所以不可见The method run() from the type Person is not visible,
		b.eat();  //缺省，同一个包可以使用
		b.talk();   //public，同一个工程都可以使用
	}

}
