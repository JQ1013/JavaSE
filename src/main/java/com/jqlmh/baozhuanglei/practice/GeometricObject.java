package com.jqlmh.baozhuanglei.practice;

public class GeometricObject {
	protected String color;
	protected double weight;
	
	public GeometricObject() {
		super();
		color="white";
		weight=1.0;
	}

	public GeometricObject(String color, double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	

}
