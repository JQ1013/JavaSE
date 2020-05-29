package com.jqlmh.shejimoshi;
/*
 * 1.所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例
 * 2.如何实现
 * 		饿汉式
 * 		懒汉式
 * 
 * 3.饿汉式和懒汉式的区别
 * 		饿汉式：坏处：对象加载时间长
 * 			饿汉式是线程安全的		
 * 		懒汉式好处：延迟对象的创建
 * 			目前写法是不安全的
 */

public class Singleton {
	public static void main(String[] args) {
		Bank b1=Bank.getInstace();
		Bank b2=Bank.getInstace();
		System.out.println(b1==b2);
				
	}
}

//饿汉式单利设计模式
class Bank{
	
	//私有化构造器
	private Bank(){
		
	}
	
	//2.内部创建类的对象
	//3.要求此对象也必须声明为静态的
	private static Bank b1=new Bank();
	//3.提供公共静态的方法，返回类的对象
	
	public static Bank getInstace(){
		return b1;
	}
	
	
	
}