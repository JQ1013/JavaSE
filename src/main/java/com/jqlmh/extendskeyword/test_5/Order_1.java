package com.jqlmh.extendskeyword.test_5;


import com.jqlmh.extendskeyword.test5.Order;

/**
 * 不同包下的不是子类
 * @Description
 * @author LMH
 * @version
 * @date 2019年6月12日下午11:05:56
 *
 */
public class Order_1 {
	public static void main(String[] args) {
		Order dOrder=new Order();
		dOrder.orderPublic=3;
		
		//不同包下的普通类，不是子类，不可以调用声明为private，缺省、protected修饰的 方法和属性
//		dOrder.orderPrivate=1;
//		dOrder.orderDefault=1;
//		dOrder.orderProtected=1;
	}
	
}
