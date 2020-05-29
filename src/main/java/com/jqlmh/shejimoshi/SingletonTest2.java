package com.jqlmh.shejimoshi;
/*
 * 2.懒汉式模式
 */
public class SingletonTest2 {
	public static void main(String[] args) {
		Order o1=Order.getInstance();
		Order o2=Order.getInstance();
		System.out.println(o1==o2);
	}
}
class Order{
	//1.私有化构造器
	private Order(){
		
	}
	
	//2.声明当前类的对象，没有初始化
	private static Order instance=null;
	
	//3.声明public、static的方法，返回当前类的对象
	public static Order getInstance(){
		if (instance==null) {   //判断当前类的对象是不是null，如果不是说才new一个，不然会创建多个对象给o1
			instance=new Order();
		}
		return instance;
	} 
}