package com.jqlmh.exercise.practice;

public class TriAngle {
	private double base;
	private double height;
	
	
	public TriAngle() {
		super();
	}



	public TriAngle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
	}
	
	

	public double getBase() {
		return base;
	}



	public void setBase(double base) {
		this.base = base;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	public double area() {
		double area=base*height/2;
		return area;
	}

}
