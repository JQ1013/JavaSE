package com.jqlmh.jiekou.exer;
/*
 * 定 义 矩 形 类 Rectangle 和 ComparableRectangle 类 ， 
 * 在ComparableRectangle类中给出compareTo方法的实现，比较两个矩形的面积大小。
 */
public class Rectangle {
	private Double length; //矩形长
	private Double width; //矩形宽
	
	
	public Rectangle() {
		super();
	}


	public Rectangle(Double length, Double width) {
		super();
		this.length = length;
		this.width = width;
	}


	public Double getLength() {
		return length;
	}

	public Double getWidth() {
		return width;
	}


/**
 * 
 * @Description 获取矩形面积
 * @author LMH
 * @date 2019年7月13日下午7:20:10
 * @return
 */
	public Double findArea() {  
		return length*width;
	}
	
	
}
