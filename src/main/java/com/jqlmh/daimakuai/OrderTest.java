package com.jqlmh.daimakuai;
/*
 * 对对象属性可以赋值的位置：
 * 		①默认初始化
 * 		②显式初始化/⑤代码块中赋值（谁先写谁先执行）
 * 		③构造器
 * 		④对象.属性和对象.方法
 * 		
 * 
 * 		执行的先后顺序：①-②/⑤-③-④
 */
public class OrderTest {
	public static void main(String[] args) {
		Order o1=new Order();
		System.out.println(o1.orderId);
	}
}


class Order{
//	int orderId =3;
//	{
//		orderId=4;
//	}
	
	{
		orderId=4;
	}
	int orderId =3;
}