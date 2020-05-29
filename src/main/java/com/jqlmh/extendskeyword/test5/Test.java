package com.jqlmh.extendskeyword.test5;

public class Test {
	public static void main(String[] args) {
		Order order=new Order();
		
		//同一包下可以调用以下
		order.orderDefault=1;
		order.orderProtected=1;
		order.orderPublic=1;
		
		//order.orderPriva=1; //orderDefault=1;
	}

}
