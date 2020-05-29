package com.jqlmh.extendskeyword.test3;

public class Circle {
	private double radius;

	public Circle() {
		super(); //子类调用父类的空参构造器
		radius = 1.0; 
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	/**
	 * 计算圆面积
	 * @Description 
	 * @author LMH
	 * @date 2019年6月12日下午7:55:49
	 * @return 圆面积
	 */
	public double findArea() {
		return Math.PI*radius*radius;
	}
	

}
