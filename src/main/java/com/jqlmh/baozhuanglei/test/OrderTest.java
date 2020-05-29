package com.jqlmh.baozhuanglei.test;

public class OrderTest {
	public static void main(String[] args) {
		Order o1=new Order(1, "AA");
		Order o2=new Order(2, "BB");
		Order o3=new Order(2, "BB");
		
		System.out.println(o1.equals(o2));
		System.out.println(o1.equals(o3));
		System.out.println(o3.equals(o3));
		
		String str1="AA";
		String str2="AA";
		System.out.println(str1==str2);  //true
		//String的内容存在常量池中，定义的变量相同就复用同一个
		
	}

}
