package com.jqlmh.jiekou.exer;
/*
 * 定义一个测试类InterfaceTest，创建两个ComparableCircle对象，
 * 调用compareTo方法比较两个类的半径大小。
 */
public class InterfaceTest {
	public static void main(String[] args) {
		
		//比较圆的半径
		ComparableCircle c1=new ComparableCircle(45.01000000);
		ComparableCircle c2=new ComparableCircle(45);
		if (c1.compareTo(c2)>0) {
			System.out.println("c1面积大");
		}else if (c1.compareTo(c2)<0) {
			System.out.println("c2半径大");
		}else {
			System.out.println("两个圆的半径一样");
		}
		
		
		//比较矩形面积
		ComparableRectangle comparableRectangle = new ComparableRectangle(10,1);
		ComparableRectangle comparableRectangle2 = new ComparableRectangle(10,1);
		if (comparableRectangle.compareTo(comparableRectangle2)>0) {
			System.out.println("矩形1面积大");
		}else if (comparableRectangle.compareTo(comparableRectangle2)<0) {
			System.out.println("矩形2面积大");
		}else {
			System.out.println("两个矩形的面积一样");
		}
		
		
	}
}
