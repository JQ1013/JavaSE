package com.jqlmh.duotai.exer1;

public class Circle extends GeometricObject{
	private double radius;

	public Circle(String color, double weight, double radius) {
		super(color, weight);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	//计算圆的面积
	@Override
	public double findArea() {
		return Math.PI*radius*radius;
	}
	
}
