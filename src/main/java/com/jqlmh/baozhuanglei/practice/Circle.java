package com.jqlmh.baozhuanglei.practice;

public class Circle extends GeometricObject {
	private double radius;

	public Circle() {
		super();
		color="white";
		weight=1.0;
		radius=1.0;
	}

	public Circle(double radius) {
		super();
		color="white";
		weight=1.0;
		this.radius = radius;
	}

	public Circle(double radius, String color, double weight) {
		super(color, weight);
		this.radius=radius;
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double findArea(){
		return Math.PI*radius*radius;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if (obj instanceof Circle) {
			Circle c1=(Circle)obj;
			return this.radius==c1.radius;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Circle[radius="+radius+"]";
	}
	
	

}
