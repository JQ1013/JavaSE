package com.jqlmh.baozhuanglei.equals;

import java.util.Date;

/*
 * equals（）方法
 * 
 * 一、回顾==的使用
 * ==可以用在基本数据类型和引用数据类型变量的比较中
 * 1、如果比较的是基本数据类型变量，比较的是变量保存的数据是否相等（不一定类型要相同）
 * 2、如果比较的是引用数据类型变量，比较两个对象的地址值是否相同
 * 
 * 二、equals（）方法的使用
 * 1、是一个方法，而非运算符
 * 2、只适用于引用数据类型
 * 3、Object类中equals（）的定义：和==的作用相同，比较两个对象的地址值相同
 * 		public boolean equals(Object obj) {
        	return (this == obj);
    	}
    
    4、像String、Date、File、包装类都 重写了Obiect类的equals（）方法。重写以后，
	比较的不是两个引用的地址是否相同，而是比较两个对象的“实体内容”是否相同	
	
	5、通常情况下，我们自定义的类如果使用equals（）方法，也通常是比较两个对象“实体内容”是否相同。那么我们
	就需要对Object类中的equals（）进行重写
	重写原则：比较两个对象的实体内容是否相同  
 */

public class EqualsTest2 {
	public static void main(String[] args) {
		
		//基本数据类型
		int a=10;
		int b=10;
		double c=10;
		System.out.println(a==b); //true
		System.out.println(a==c); //true
		
		boolean d=true;
//		System.out.println(a==d);  报错，==不能运算boolean类型的变量
		
		char c1=10;  //
		System.out.println(a==c1);   //true   基本数据类型比较的是实际保存的值
		
		char c2='A';
		char c3=65;
		System.out.println(c2==c3);  //true
		
		//引用数据类型题
		Customer c6=new Customer("tom", 23);
		Customer c7=new Customer("tom", 23);
		System.out.println(c6==c7);  //引用数据类型，==比较的是地址值

		//equals()
		System.out.println("****************************");
		System.out.println(c6.equals(c7)); //true,重写过的equals方法
		
		System.out.println("****************************");
		String str1=new String("tom");
		String str2=new String("tom");  //new的对象
		System.out.println(str1.equals(str2)); //true
		
		
		System.out.println("****************************");
		Date date1=new Date(2323232323232L);
		Date date2=new Date(2323232323232L);
		System.out.println(date1.equals(date2));
		
	}

}
