package com.jqlmh.extendskeyword.test3;

public class CylinderTest {
	public static void main(String[] args) {
		Cylinder c=new Cylinder();
//		c.setRadius(2.1);
//		c.setLength(3.4);
		System.out.println("圆柱体的容积是："+c.findVolume());
		
		System.out.println("圆柱体的表面积为："+c.findArea());
	}

}
