package com.jqlmh.shejimoshi;
/*
 * 手写单例模式
 */
public class SingletonTest {
	
	
}

//饿汉式
class Order1{
	private Order1(){
		
	}
	private static Order1 instance=new Order1();
	public static Order1 getInstance(){
		return instance;
	}
}


//懒汉式
class Bank1{
	private Bank1(){
		
	}
	
	private static Bank1 instance=null;
	
	public static Bank1 getInstance() {
		if (instance==null) {
			instance=new Bank1();
		}
		return instance;
	}
}