package com.jqlmh.extendskeyword.test3;

public class Cylinder extends Circle {
	private double length;

	public Cylinder() {
		length = 1.0;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	
	@Override
	public double findArea() { //返回圆柱体的表面积
		return Math.PI*getRadius()*getRadius()*2+Math.PI*2*getRadius()*getLength();
	}
	/**
	 * 计算圆柱体面积
	 * @Description 
	 * @author LMH
	 * @date 2019年6月12日下午7:55:17
	 * @return 圆柱体面积
	 */
	public double findVolume() {
		return super.findArea()*length;  //使用super关键字调用父类被重写的方法
	}
	
}
