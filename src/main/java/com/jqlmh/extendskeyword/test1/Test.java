package com.jqlmh.extendskeyword.test1;

public class Test {
	public static void main(String[] args) {
		Student s=new Student();
		s.learn();  
		
		//System.out.println("name"+s.name); //私有属性，虽然因为封装性不能直接调用，但是子类也是继承了的
		s.setName("李华");
		System.out.println("name："+s.getName());  //父类私有属性，子类可以用get方法获取
	}

}
